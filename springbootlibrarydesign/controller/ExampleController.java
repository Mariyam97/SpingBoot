package com.gl.library.springbootlibrarydesign.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gl.library.springbootlibrarydesign.model.GreatLearning;
import com.gl.library.springbootlibrarydesign.service.ExampleService;

//@Controller
@RestController
public class ExampleController {
	/*
	@GetMapping("/info")
	//@ResponseBody
	public GreatLearning get() {
		GreatLearning gl = new GreatLearning();
		gl.setCourseName("Spring boot");
		gl.setCourseType("IT");
		gl.setInstrutorName("SARDAR");
		return  gl;
	
		
	}
	
	@PostMapping("/customInfo")
	public GreatLearning customInfo(String courseName, String courseType, String instrutorName) {
		GreatLearning gl = new GreatLearning();
		gl.setCourseName(courseName);
		gl.setCourseType(courseType);
		gl.setInstrutorName(instrutorName);
		
		return gl;

}
*/
	
	// Service Tier 
	
	@Autowired  //new object creation done by spring boot
	ExampleService serviceExample;
	
	@GetMapping("/info")
	//@ResponseBody
	public GreatLearning get() {
		return  serviceExample.get();
	}

	@PostMapping("/customInfo")
	public GreatLearning customInfo(String courseName, String courseType, String instrutorName) {
		return  serviceExample.customInfo(courseName, courseType, instrutorName);
	}
}
