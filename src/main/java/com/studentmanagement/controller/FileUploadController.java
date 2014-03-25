package com.studentmanagement.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.studentmanagement.components.FileUploadForm;
import com.studentmanagement.databasemanager.FileManager;
import com.studentmanagement.databasemanager.NoticeManager;

@Controller
public class FileUploadController {

	@Autowired
	private DataSource dataSource;

	@Autowired
	private String fileSaveUrl;

	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public String displayForm() {
		return "file_upload_form";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute("uploadForm") FileUploadForm uploadForm,
			Model map) {

		boolean uploaded = false;
		List<MultipartFile> files = uploadForm.getFiles();

		Map<String, Long> fileNames = new HashMap<String, Long>();

		if (null != files && files.size() > 0) {

			for (MultipartFile multipartFile : files) {

				String fileName = multipartFile.getOriginalFilename();
				if(fileName.length()==0)
					continue;
				Long l = new Long(new Date().getTime());
				fileNames.put(fileName, l);
				try {
					String url=fileSaveUrl+l;
					multipartFile.transferTo(new File(url));
					uploaded = true;
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}

		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		String author = auth.getName();
		NoticeManager noticeManager = new NoticeManager(dataSource);

		int noticeId = noticeManager.addNotice(uploadForm.getContent(), author,
				uploadForm.getSubject(), uploaded);
		FileManager fileManager = new FileManager(dataSource);
		fileManager.makeDatabaseFileEntry(fileNames, noticeId);

		return "submitted";
	}

}
