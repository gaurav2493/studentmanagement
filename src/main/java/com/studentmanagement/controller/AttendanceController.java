package com.studentmanagement.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.studentmanagement.components.RollList;
import com.studentmanagement.databasemanager.AttendenceSubmitter;
import com.studentmanagement.databasemanager.StudentListGenerator;

@Controller
public class AttendanceController {
	
	@Autowired
	DataSource dataSource;
	
	
	@RequestMapping(value="/addattendence",method= RequestMethod.POST)
	public String addAttendence(HttpServletRequest request,@RequestParam Map<String,String> allRequestParams, ModelMap model)
	{
		StudentListGenerator studentListGenerator=new StudentListGenerator(dataSource, allRequestParams);
		RollList rollList=studentListGenerator.getAttendenceList();
		System.out.println(rollList.getStudentList().size());
		model.addAttribute("rollList",rollList);
		request.getSession().setAttribute("allReqParamsForAddAttendence",allRequestParams);
		return "addattendence";
	}
	@RequestMapping(value="/submitattendence",method= RequestMethod.POST)
	public String submitAttendence(HttpServletRequest request,@RequestParam Map<String,String> allRequestParams, ModelMap model)
	{
		@SuppressWarnings("unchecked")
		Map<String,String> attribute = (Map<String,String>)request.getSession().getAttribute("allReqParamsForAddAttendence");
		AttendenceSubmitter attendenceSubmitter=new AttendenceSubmitter(dataSource,allRequestParams,attribute);
		attendenceSubmitter.addToAttendence();
		return "submitattendence";
	}

}
