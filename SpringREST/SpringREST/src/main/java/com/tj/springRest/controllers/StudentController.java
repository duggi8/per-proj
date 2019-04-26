package com.tj.springRest.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tj.springRest.beans.Student;

@Controller
public class StudentController {

	@GetMapping(value = "/student")
	public ModelAndView student() {
		return new ModelAndView("student","command", new Student());
	}
	
	@PostMapping(value = "/addStudent")
	public String addStudent(Student student, ModelMap model) {
		model.addAttribute("name", student.getName());
		model.addAttribute("age",student.getAge());
		model.addAttribute("id",student.getId());
		return "result";
	}
}
