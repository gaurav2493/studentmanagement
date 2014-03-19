package com.studentmanagement.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.studentmanagement.components.FileUploadForm;

@Controller
public class FileUploadController {
	
	private String saveDirectory = "C:/Users/Devesh/Desktop/";
	
	@RequestMapping(value = "/show", method = RequestMethod.GET)
    public String displayForm() {
        return "file_upload_form";
    }
     
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(
            @ModelAttribute("uploadForm") FileUploadForm uploadForm,
                    Model map) {
    	
         
        List<MultipartFile> files = uploadForm.getFiles();
 
        List<String> fileNames = new ArrayList<String>();
         
        if(null != files && files.size() > 0) {
            for (MultipartFile multipartFile : files) {
 
                String fileName = multipartFile.getOriginalFilename();
                fileNames.add(fileName);
                try {
					multipartFile.transferTo(new File(saveDirectory + multipartFile.getOriginalFilename()));
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
 
            }
        }
         
        map.addAttribute("files", fileNames);
        return "file_upload_success";
    }

}
