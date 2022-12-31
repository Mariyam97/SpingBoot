package com.gl.library.springbootlibrarydesign.model;

public class Main {
	
	private String courseName;
	private String courseType;
	private String instrutorName;
	
	
	
	public Main() {
		
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getCourseType() {
		return courseType;
	}
	public void setCourseType(String courseType) {
		this.courseType = courseType;
	}
	public String getInstrutorName() {
		return instrutorName;
	}
	public void setInstrutorName(String instrutorName) {
		this.instrutorName = instrutorName;
	}
	@Override
	public String toString() {
		return "Main [courseName=" + courseName + ", courseType=" + courseType + ", instrutorName=" + instrutorName
				+ "]";
	}
	public Main(String courseName, String courseType, String instrutorName) {
		super();
		this.courseName = courseName;
		this.courseType = courseType;
		this.instrutorName = instrutorName;
	}
	
	

}
