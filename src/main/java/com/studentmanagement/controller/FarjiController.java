package com.studentmanagement.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
public class FarjiController {
	
	@RequestMapping(value="/geturi")
	public @ResponseBody String byParameter(HttpServletResponse response, HttpServletRequest request) {
		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		System.out.println("sf");
		return "Authenticated";
	}
}
