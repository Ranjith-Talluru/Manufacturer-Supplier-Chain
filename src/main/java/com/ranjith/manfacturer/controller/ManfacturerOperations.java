package com.ranjith.manfacturer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ranjith.manfacturer.request.CommonRequest;
import com.ranjith.manfacturer.response.CommonResponse;
import com.ranjith.manfacturer.service.ManfacturerOperationsService;

import lombok.extern.slf4j.Slf4j;

@RequestMapping(value = "/manfacturer")
@RestController
@Slf4j
public class ManfacturerOperations {

	@Autowired
	private ManfacturerOperationsService manufactOperServ;

	@PostMapping(value = "/get-Details", consumes = "application/json", produces = "application/json")
	public CommonResponse getManfacturerDetails(@RequestBody CommonRequest request) {

		CommonResponse response = new CommonResponse();

		log.info("**************** Fetching Manfacturer Details **********************");
		log.info("Pass is " + request.getPassword());

		log.info(" Username is : {} and Pass is : {}", request.getUserName(), request.getPassword());

		response.setMessage("Manfacturer Det Retrieved Succesfully");
		response.setStatus("OK");

		return response;

	}

	@PostMapping(value = "/get-By-Id", consumes = "application/json", produces = "application/json")
	public CommonResponse getDetailsByManufacturerId(@RequestBody CommonRequest request) {

		return manufactOperServ.getManufacturerDetById(request);
	}

	@PostMapping(value = "/get-By-Name", consumes = "application/json", produces = "application/json")
	public CommonResponse getDetailsByManufacturerName(@RequestBody CommonRequest request) {
		CommonResponse response = new CommonResponse();
		return response;
	}

	@PostMapping(value = "/update-By-Id", consumes = "application/json", produces = "application/json")
	public CommonResponse updateManfacturerById(@RequestBody CommonRequest request) {
		CommonResponse response = new CommonResponse();
		return response;
	}

	@PostMapping(value = "/add", consumes = "application/json", produces = "application/json")
	public CommonResponse addManufacturer(@RequestBody CommonRequest request) {
		CommonResponse response = new CommonResponse();
		return response;
	}

	@PostMapping(value = "/delete", consumes = "application/json", produces = "application/json")
	public CommonResponse deleteManufacturer(@RequestBody CommonRequest request) {
		CommonResponse response = new CommonResponse();
		return response;
	}

}
