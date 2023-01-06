package com.librarymanagement.librarydesign.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2

public class SwaggerConfig {
	@Bean
	public Docket libraryApi() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
				.groupName("Library_Management-API").select()
				.apis(RequestHandlerSelectors.basePackage("com.librarymanagement.librarydesign")).build();

	}

	private ApiInfo apiInfo() {
		// TODO Auto-generated method stub
		return new ApiInfoBuilder().title("Library_Management API")
				.description("Library_Management API for developers")
				.termsOfServiceUrl("http://LibraryManagement.com")
				.contact(new Contact("Library_Management API", "http://LibraryManagement.com", "lm@design.com"))
				.license("LibraryManagement @CC")
				.licenseUrl("http://LibraryManagement.com")
				.version("1.0")
				.build();
	}
}
