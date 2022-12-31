package com.gl.library.springbootlibrarydesign.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConstructorInjection {

	private String courseName;
	private String courseType;
	private String instrutorName;
/*
	public ConstructorInjection(String courseName, String courseType, String instrutorName) {
		super();
		this.courseName = courseName;
		this.courseType = courseType;
		this.instrutorName = instrutorName;
	}
*/
	@Override
	public String toString() {
		return "ConstructorInjection [courseName=" + courseName + ", courseType=" + courseType + ", instrutorName="
				+ instrutorName + "]";
	}
}
