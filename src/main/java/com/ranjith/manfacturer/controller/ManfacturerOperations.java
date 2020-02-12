package com.ranjith.manfacturer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ranjith.manfacturer.response.CommonResponse;

import lombok.extern.slf4j.Slf4j;

@RequestMapping(value = "/manfacturer")
@RestController
@Slf4j
public class ManfacturerOperations {
	
	@GetMapping(value="/get-Details" ,produces="application/json")
	public CommonResponse getManfacturerDetails() {
		
		CommonResponse response = new CommonResponse();
		
		log.info("**************** Fetching Manfacturer Details **********************");

		response.setMessage("Manfacturer Det Retrieved Succesfully");
		response.setStatus("OK");

		return response;

	}

}
