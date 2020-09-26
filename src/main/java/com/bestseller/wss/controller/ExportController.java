package com.bestseller.wss.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fr.third.springframework.web.bind.annotation.RequestParam;

@RestController
public class ExportController {

	@GetMapping(value="/completeQty2Xlsx")
	public String completeQty2Xlsx(@RequestParam(value = "fr_home")String fr_homeString, @RequestParam(value = "report_name") String reportNameString) {
		
		return null;
	}
	
}
