package com.gl.library.springbootlibrarydesign.service;

import com.gl.library.springbootlibrarydesign.model.GreatLearning;

public interface ExampleService {

	GreatLearning get();

	GreatLearning customInfo(String courseName, String courseType, String instrutorName);

}