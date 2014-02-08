package com.studentmanagement.controller;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TeacherLoginController {
	
	@Autowired
	DataSource dataSource;
	
	@RequestMapping(value="/",method= RequestMethod.GET)
	public String teacherlogin(ModelMap model)
	{
		return "homepage";
	}
	@RequestMapping(value="/loginfailed",method= RequestMethod.GET)
	public String getNoticeXml(ModelMap model)
	{
		
			model.addAttribute("error", "true");
			return "homepage";
	}
}
