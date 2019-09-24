package com.cjc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cjc.model.Student;
import com.cjc.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	//@Qualifier("studentService")
	StudentService studentService;
	
	@RequestMapping("/register")
	public String preregister()
	{
		System.out.println("Pre-register");
		return "register";
	}
	
	@RequestMapping("/reg")
	public String registration(@ModelAttribute Student stu)
	{
		System.out.println("Registration");	
		int i=studentService.registerdata(stu);	
		if(i>0)
		{
			return "index";
		}
		else
		{
			return "reg";
		}
	}
	@RequestMapping(value="/log")
	public String loginCheck(@RequestParam("username") String username,@RequestParam("password") String password ,Model model)
	{
		System.out.println(username);
		System.out.println(password);
		List<Student> list=	studentService.loginCheck(username,password);
		System.out.println(list);
		model.addAttribute("data",list);
		return "success";
	}
}
