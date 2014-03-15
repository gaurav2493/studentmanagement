package com.studentmanagement.controller;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.studentmanagement.databasemanager.ExamReports;

@Controller
public class AcademicMarksController {
	
	@Autowired
	DataSource dataSource;
	
	@RequestMapping(value="/academicreports")
	public String academicReports(ModelMap model)
	{
		ExamReports examReports=new ExamReports(dataSource);
		model.addAttribute("examList", examReports.getExamTypes());
		return "academicreports";
	}
	@RequestMapping(value="/addexam")
	public String addExams(ModelMap model)
	{
		return "addexam";
	}
	@RequestMapping(value="/createnewexam",method=RequestMethod.POST )
	public String createNewExam(ModelMap model,@RequestParam(value = "exam_name") String param)
	{
		ExamReports examReports=new ExamReports(dataSource);
		examReports.createNewExam(param);
		return "submitted";
	}
	@RequestMapping(value="/examreport",method=RequestMethod.GET )
	public String examReport(ModelMap model,@RequestParam(value = "examid") String param)
	{
		//ExamReports examReports=new ExamReports(dataSource);
		//examReports.createNewExam(param);
		return "submitted";
	}
}
