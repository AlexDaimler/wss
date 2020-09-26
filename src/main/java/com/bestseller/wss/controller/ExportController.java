package com.bestseller.wss.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bestseller.wss.service.CompleteQty2XlsxService;
import com.bestseller.wss.service.impl.CompleteQty2XlsxServiceImp;
import com.fr.third.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@RestController
public class ExportController {
	
	@GetMapping(value="/completeQty2Xlsx")
	public String completeQty2Xlsx(@RequestParam(value = "fr_home")String frHomeString, @RequestParam(value = "report_name") String reportNameString) {
		log.info("ExportController");
		CompleteQty2XlsxService service = new CompleteQty2XlsxServiceImp();
		try {
			service.completeQty2Xlsx(frHomeString, reportNameString);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.error(e.getMessage());
		}
		
		return null;
	}
	
}
