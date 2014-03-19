package com.studentmanagement.controller;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.studentmanagement.components.Profile;
import com.studentmanagement.databasemanager.ProfileManager;

@Controller
public class ProfileController {
	
	@Autowired
	DataSource dataSource;
	
	@RequestMapping(value="/profile/getprofile")
	public String getProfile(@RequestParam("rollno") int rollNo, ModelMap model)
	{
		ProfileManager profileManager=new ProfileManager(dataSource);
		Profile profile=profileManager.getProfile(rollNo);
		model.addAttribute("profile", profile);
		return "getprofile";
	}

}
