package com.gl.spring.springjsp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hello")
public class MyController {

	@RequestMapping("/greet")
	public String sayHello(Model model) {
		model.addAttribute("greeting", "welcome to spring boot with thymeleaf");
		return "welcome";
	}
}