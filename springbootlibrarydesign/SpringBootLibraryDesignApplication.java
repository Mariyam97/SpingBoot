package com.gl.library.springbootlibrarydesign;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gl.library.springbootlibrarydesign.model.ComplexObject;
import com.gl.library.springbootlibrarydesign.model.ConstructorInjection;
import com.gl.library.springbootlibrarydesign.model.FullName;
import com.gl.library.springbootlibrarydesign.model.GreatLearning;
import com.gl.library.springbootlibrarydesign.model.Main;
import com.gl.library.springbootlibrarydesign.model.TelescopingConstructor;
import com.gl.library.springbootlibrarydesign.serviceImplementation.ServiceExample;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class SpringBootLibraryDesignApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootLibraryDesignApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		/*
		 * Main obj = new Main(); obj.setCourseName("FSD"); obj.setCourseType("FT");
		 * obj.setInstrutorName("mariyam");
		 * 
		 * System.out.println("Main Object " + obj);
		 * 
		 * System.out.println("Get Method for course name " + obj.getCourseName());
		 * System.out.println("Get Method for course type " + obj.getCourseType());
		 * System.out.println("Get Method for instrutor name " +
		 * obj.getInstrutorName());
		 * 
		 * 
		 * 
		 * Main obj = new Main("FSD","FT","mariyam");
		 * 
		 * System.out.println("Main Object for all agrs constructor " + obj);
		 * 
		 */

		/*
		 * using lombok framework 
		 
		 GreatLearning gl = new GreatLearning(); gl.setCourseName("FSD");
		 gl.setCourseType("FT"); gl.setInstrutorName("mariyam");
		 System.out.println(gl);
		 */

		// Constructor Injection + with lombok annotation
		/*
		 * ConstructorInjection cj = new
		 * ConstructorInjection("ConstructorInjection Design","WEEK 15","MARIYAM");
		 * System.out.println(cj);
		 * 
		 */
		/*Telescoping Constructor

		TelescopingConstructor tc = new TelescopingConstructor("Learning TelescopingConstructor DP", "WEEK 15");
		System.out.println(tc); */

		/* Builder Design Pattern
		TelescopingConstructor tcBuilderonlyC_Name = TelescopingConstructor.builder().courseName("Full stack").build();
		System.out.println(tcBuilderonlyC_Name);
		
		
		TelescopingConstructor tcBuilder = TelescopingConstructor.builder().courseName("Full stack").courseType("FT")
				.build();
		System.out.println(tcBuilder);
*/
		
		/*Complex Object creation
		ComplexObject cobj = ComplexObject.builder()
							.courseName("COMPLEX OBJ COURSE")
							.courseType("EASY")
							.instructorName(FullName.builder().firstName("BIBI").lastName("MARIYAM").build())
							.build();
		System.out.println(cobj);
		*/
		
		//SLF4J INITIALIZER LOGGER
		ComplexObject cobj = ComplexObject.builder()
				.courseName("COMPLEX OBJ COURSE")
				.courseType("EASY")
				.instructorName(FullName.builder().firstName("BIBI").lastName("MARIYAM").build())
				.build();
    log.info("COMPLEX OBJ COURSE -> {} ", cobj);
		
	}

}
