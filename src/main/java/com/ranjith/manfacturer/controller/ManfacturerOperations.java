package com.ranjith.manfacturer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ranjith.manfacturer.request.ManufacturerDetRequest;
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
	public CommonResponse getManfacturerDetails(@RequestBody ManufacturerDetRequest request) {

		CommonResponse response = new CommonResponse();

		log.info("**************** Fetching Manfacturer Details **********************");

		log.info(" Manufact ID is : {} and Name is : {}", request.getManufacturerId(), request.getManufacturerName());

		response.setMessage("Manfacturer Det Retrieved Succesfully");
		response.setStatus("OK");

		return response;
	}

	
	@GetMapping(value = "/get-By-Id", produces = "application/json")
	public CommonResponse getDetailsByManufacturerId(@RequestParam("id") String manufactId) {

		return manufactOperServ.getManufacturerDetById(manufactId);
	}

	@GetMapping(value = "/get-By-Name", produces = "application/json")
	public CommonResponse getDetailsByManufacturerName(@RequestParam("manufactName") String manufactName) {
		
		 return manufactOperServ.getManufacturerDetByName(manufactName);
	}

	@PutMapping(value = "/update-By-Id", consumes = "application/json", produces = "application/json")
	public CommonResponse updateManfacturerById(@RequestBody ManufacturerDetRequest request) {
		CommonResponse response = new CommonResponse();
		return response;
	}

	@PostMapping(value = "/add", consumes = "application/json", produces = "application/json")
	public CommonResponse addManufacturer(@RequestBody ManufacturerDetRequest request) {
		CommonResponse response = new CommonResponse();
		return response;
	}

	@DeleteMapping(value = "/delete", consumes = "application/json", produces = "application/json")
	public CommonResponse deleteManufacturer(@RequestParam("id") String manufactId) {
		CommonResponse response = new CommonResponse();
		return response;
	}

}
