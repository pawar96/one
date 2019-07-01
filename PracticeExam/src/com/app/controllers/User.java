package com.app.controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.dao.IStudentDao;
import com.app.pojo.Student;

@Controller
@RequestMapping("/user")
public class User {
	@Autowired
	IStudentDao std;

	public User() {
		super();
		System.out.println("In User Controller");
	}
	 
	@GetMapping("/login")
	public String showLoginform()
	{
		System.out.println("in login");
		return "/user/login"; 
	}
	@PostMapping("/login")
	public String processLoginForm(Model map,
			@RequestParam String email,
			@RequestParam String password,
			HttpSession hs)
	{
		System.out.println("process login form");
		try
		{
			Student s=std.validateUser(email, password);
			map.addAttribute("status","Successfull login");
			hs.setAttribute("vendorDetails",s);
			if(s.getName().equals("harsh"))
			{
				List<Student>arr=std.getall();
				map.addAttribute("listofstudent",arr);
				System.out.println(arr);
				System.out.println(s);
				return "user/list";
			}
			
		}catch(RuntimeException e)
		{
			System.out.println("err in ucontr "+e);
			map.addAttribute("status","invalid login,plz retry!!! ");
			return "/user/login";
		}
		return "/vendor/details";
	}
	@GetMapping("/register")
	public String register()
	{
		return "user/register";
	}
	@PostMapping("/register")
	public String registerstudent(Model map,
			@RequestParam String fname,
			@RequestParam String lastname,@RequestParam String email,@RequestParam String subject,@RequestParam String date)
	{
		Student s1=new Student(fname,lastname,email,subject,date);
		String str=std.InserData(s1);
		System.out.println(str);
		return "redirect:/user/login";
		
	}
	
	   
	

}
