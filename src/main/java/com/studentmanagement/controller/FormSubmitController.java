package com.studentmanagement.controller;

import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.studentmanagement.components.RollList;
import com.studentmanagement.databasemanager.NewStuffAdder;
import com.studentmanagement.databasemanager.StudentListGenerator;

@Controller
public class FormSubmitController {
	
	@Autowired
	DataSource dataSource;
	
	@RequestMapping(value="/submit_new_student",method= RequestMethod.POST)
	public String addStudentParams(@RequestParam Map<String,String> allRequestParams)
	{
		NewStuffAdder newUserAdder=new NewStuffAdder(dataSource, allRequestParams);
		newUserAdder.addStudent();
		return "submitted";
	}
	@RequestMapping(value="/submit_new_class",method= RequestMethod.POST)
	public String addClassParams(@RequestParam Map<String,String> allRequestParams)
	{
		NewStuffAdder newStuffAdder=new NewStuffAdder(dataSource, allRequestParams);
		newStuffAdder.createNewClass();
		return "submitted";
	}
	@RequestMapping(value="/submit_new_subject",method= RequestMethod.POST)
	public String addSubjectParams(@RequestParam Map<String,String> allRequestParams)
	{
		NewStuffAdder newStuffAdder=new NewStuffAdder(dataSource, allRequestParams);
		newStuffAdder.addSubject();
		return "submitted";
	}
	@RequestMapping(value="/addattendence",method= RequestMethod.POST)
	public String addAttendence(@RequestParam Map<String,String> allRequestParams, ModelMap model)
	{
		StudentListGenerator studentListGenerator=new StudentListGenerator(dataSource, allRequestParams);
		RollList rollList=studentListGenerator.getAttendenceList();
		System.out.println(rollList.getStudentList().size());
		model.addAttribute("rollList",rollList);
		return "addattendence";
	}

}
