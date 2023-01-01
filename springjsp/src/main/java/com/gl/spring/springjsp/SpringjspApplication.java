package com.gl.spring.springjsp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.gl.spring.springjsp"})
public class SpringjspApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringjspApplication.class, args);
		System.out.println("welcome to Spring boot project");
	}

}
