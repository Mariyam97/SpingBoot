package com.gl.library.springbootlibrarydesign.config;

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
				.groupName("Library-API").select()
				.apis(RequestHandlerSelectors.basePackage("com.gl.library.springbootlibrarydesign.controller")).build();

	}

	private ApiInfo apiInfo() {
		// TODO Auto-generated method stub
		return new ApiInfoBuilder().title("Library API")
				.description("Library API reference for developers")
				.termsOfServiceUrl("http://fakeLibrary.com")
				.contact(new Contact("Library-API", "http://fakeLibrary.com", "abc@com"))
				.license("Library Licesene")
				.licenseUrl("http://fakeLibrary.com")
				.version("1.0")
				.build();
	}

}
