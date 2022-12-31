package com.gl.library.springbootlibrarydesign.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TelescopingConstructor {
	private String courseName;
	private String courseType;
	private String instrutorName;
	
	
	public TelescopingConstructor(String courseName) {
	
		this.courseName = courseName;
	}


	public TelescopingConstructor(String courseName, String courseType) {
		this.courseName = courseName;
		this.courseType = courseType;
	}
	
	
}
