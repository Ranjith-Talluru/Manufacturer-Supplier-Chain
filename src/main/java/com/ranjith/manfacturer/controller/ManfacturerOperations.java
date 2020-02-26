package com.ranjith.manfacturer.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ranjith.manfacturer.request.CommonRequest;
import com.ranjith.manfacturer.response.CommonResponse;

import lombok.extern.slf4j.Slf4j;

@RequestMapping(value = "/manfacturer")
@RestController
@Slf4j
public class ManfacturerOperations {
	
	@PostMapping(value="/get-Details" ,produces="application/json")
	public CommonResponse getManfacturerDetails(@RequestBody CommonRequest request) {
		
		CommonResponse response = new CommonResponse();
		
		log.info("**************** Fetching Manfacturer Details **********************");
		log.info("Pass is "+request.getPassword());
		
		log.info(" Username is : {} and Pass is : {}",request.getUserName(),request.getPassword());

		response.setMessage("Manfacturer Det Retrieved Succesfully");
		response.setStatus("OK");

		return response;

	}

}
