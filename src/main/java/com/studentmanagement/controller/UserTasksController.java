package com.studentmanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserTasksController {
	
	@RequestMapping(value="/addstudent")
	public String addStudent()
	{
		return "addstudent";
	}
	
	@RequestMapping(value="/addclass")
	public String addClass()
	{
		return "addclass";
	}
	
	@RequestMapping(value="/addsubject")
	public String addSubject()
	{
		return "addsubject";
	}
	
	
	@RequestMapping(value="/selectattendence")
	public String selectAttendence()
	{
		return "selectattendence";
	}
}
