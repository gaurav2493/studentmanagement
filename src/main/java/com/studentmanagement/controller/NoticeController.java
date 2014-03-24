package com.studentmanagement.controller;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.studentmanagement.databasemanager.NoticeManager;

@Controller
public class NoticeController {
	
	@Autowired
	DataSource dataSource;
	
	@RequestMapping(value="/notice/uploadnotice",method=RequestMethod.POST)
	public String uploadNotice(@RequestParam("content") String content,@RequestParam("subject") String subject)
	{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String author=auth.getName();
		NoticeManager noticeManager=new NoticeManager(dataSource);
		noticeManager.addNotice(content, author,subject,false);
		return "submitted";
	}
	
	@RequestMapping(value="/notice/uploadpage")
	public String uploadPage()
	{
		return "noticeuploadpage";
	}

}
