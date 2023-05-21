package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.model.Student;
import com.service.StudentServiceImpl;

@Controller
public class StudentController {
	
	@Autowired
	StudentServiceImpl ss;
	
	@RequestMapping("/")
	public String loginPage()
	{
		return "login";
	}
	
	@RequestMapping("/registerPage")
	public String registerPage()
	{
		return "registration";
	}
	
	@RequestMapping("/register")
	public String insertStudent(@ModelAttribute Student s)
	{
		int check = ss.insertStudent(s);
		if(check>0)
		{
			return "login";
		}
		else {
			return "registration";
		}
	}
	
	@RequestMapping("/log")
	public String loginCheckk(@RequestParam String username,@RequestParam String password,ModelMap map)
	{
		if(username.equalsIgnoreCase("Admin")&&password.equals("Admin@121"))
		{
			List<Student> studentlist = ss.loginCheck(username, password);
			System.out.println(studentlist);
			map.addAttribute("studentlist",studentlist);
			return "success";
		}
		else {
			return "login";
		}
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteStudent(@PathVariable("id")int id,ModelMap map )
	{
		List<Student> studentlist = ss.deleteStudentById(id);
		if(!studentlist.isEmpty()||studentlist!=null)
		{
			map.addAttribute("studentlist",studentlist);
			return "success";
		}
		else
		{
			map.addAttribute("msg","delete unsuccesful");
			return "success";
		}
		
		
	}
	
	@RequestMapping("/edit/{id}")
	public String editStudent(@PathVariable("id")int id,ModelMap map)
	{
		Student s = ss.editStudent(id);
		map.addAttribute("s",s);
		return "edit";
	}
	
	@RequestMapping("/update")
	public String updateStudent(@ModelAttribute Student s,ModelMap map)
	{
		List<Student> studentlist=ss.updateStudent(s);
		map.addAttribute("studentlist",studentlist);
		return "success";
	}
}
