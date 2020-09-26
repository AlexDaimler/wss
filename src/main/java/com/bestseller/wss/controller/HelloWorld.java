package com.bestseller.wss.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {
	@RequestMapping(value="helloworld")
	public String sayHello() {
		return "Spring boot : Hello World!";
	}

}
