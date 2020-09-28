package com.bestseller.wss.controller;

import java.util.Date;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bestseller.wss.util.DateTools;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class HelloWorld {
	@RequestMapping(value="helloworld")
	public String sayHello() {
		
		log.info(DateTools.getDateTime(new Date(), 0));
		log.info(DateTools.getDateTime(new Date(), -1));	
		log.info("Hello World Controller");
		return "Spring boot : Hello World!";
	}

}
