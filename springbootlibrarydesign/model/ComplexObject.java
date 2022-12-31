package com.gl.library.springbootlibrarydesign.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ComplexObject {
	private String courseName;
	private String courseType;
	private FullName instructorName;
	
}
