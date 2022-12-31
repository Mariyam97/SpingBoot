package com.gl.library.springbootlibrarydesign.serviceImplementation;

import org.springframework.stereotype.Service;

import com.gl.library.springbootlibrarydesign.model.GreatLearning;
import com.gl.library.springbootlibrarydesign.service.ExampleService;

import lombok.extern.slf4j.Slf4j;

@Service
//logger 
@Slf4j
public class ServiceExample implements ExampleService {
	
	@Override
	public GreatLearning get() {
		log.info("inside get method");
		GreatLearning gl = new GreatLearning();
		gl.setCourseName("Spring boot");
		gl.setCourseType("IT");
		gl.setInstrutorName("SARDAR");
		return  gl;
	
		
	}
	@Override
	public GreatLearning customInfo(String courseName, String courseType, String instrutorName) {
		log.info("inside custom info method");
		GreatLearning gl = new GreatLearning();
		gl.setCourseName(courseName);
		gl.setCourseType(courseType);
		gl.setInstrutorName(instrutorName);
		
		return gl;

}
	
}
