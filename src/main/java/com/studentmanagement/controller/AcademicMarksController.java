package com.studentmanagement.controller;

import java.util.Calendar;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.studentmanagement.databasemanager.ExamReports;
import com.studentmanagement.databasemanager.StudentListGenerator;
import com.studentmanagement.databasemanager.SubjectsChooser;

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
		examReports.createNewExamType(param);
		return "submitted";
	}
	@RequestMapping(value="/academicreports/options",method=RequestMethod.GET )
	public String academicreportsOptions(ModelMap model,@RequestParam(value = "examid") int examid,HttpServletRequest request)
	{
		HttpSession session = request.getSession();
		session.setAttribute("examid", new Integer(examid));
		return "examoptions";
	}
	@RequestMapping(value="/academicreports/uploadmarks",method=RequestMethod.GET )
	public String uploadmarks(ModelMap model,HttpServletRequest request)
	{
		int year = Calendar.getInstance().get(Calendar.YEAR);
		Map<String, String> subjectMap=new SubjectsChooser(dataSource).getAllSubjects();
		model.addAttribute("currentYear", new Integer(year));
		model.addAttribute("subjectsMap", subjectMap);
		return "uploadmarks";
	}
	@RequestMapping(value="/academicreports/uploadmarks/insertmarks",method=RequestMethod.GET )
	public String insertmarks(ModelMap model,@RequestParam Map<String,String> allRequestParams,HttpServletRequest request)
	{
		StudentListGenerator studentListGenerator=new StudentListGenerator(dataSource, allRequestParams);
		Map<Integer, String> rollList =studentListGenerator.getStudentList();
		request.getSession().setAttribute("examparams", allRequestParams);
		model.addAttribute("rollList", rollList);
		return "insertmarks";
	}
	@RequestMapping(value="/academicreports/uploadmarks/submitmarks",method=RequestMethod.POST )
	public String submitmarks(@RequestParam Map<String,String> allRequestParams,HttpServletRequest request)
	{
		HttpSession session=request.getSession();
		ExamReports examReports=new ExamReports(dataSource);
		examReports.insertMarks(allRequestParams, session);
		return "submitted";
	}
	
}
