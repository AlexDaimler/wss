package com.bestseller.wss.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class HelloWorld {
	@RequestMapping(value="helloworld")
	public String sayHello() {
		
		log.info("Hello World Controller");
		return "Spring boot : Hello World!";
	}

}
