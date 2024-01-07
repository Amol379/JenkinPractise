package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Home {

	@RequestMapping("/hello")
	public String sayHello() {
		System.out.println("i am home");
		return "home";
	}
}
