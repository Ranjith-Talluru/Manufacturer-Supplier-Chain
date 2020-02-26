package com.ranjith.manfacturer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ranjith.manfacturer.entity.ManufacturerDetails;
import com.ranjith.manfacturer.repository.ManufacturerDetRepo;
import com.ranjith.manfacturer.request.CommonRequest;
import com.ranjith.manfacturer.response.ManufacturerDetailsResponse;
import com.ranjith.manfacturer.util.ManufacturerUtility;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ManfacturerOperationsService {
	
	@Autowired
	private ManufacturerDetRepo manufactRepo;
	
	@Autowired
	private ManufacturerUtility manufactUtility;

	public ManufacturerDetailsResponse getManufacturerDetById(CommonRequest request) {
		ManufacturerDetailsResponse response = new ManufacturerDetailsResponse();
		try {
		
		List<ManufacturerDetails> manufactDet = manufactRepo.findByManufacturerId(request.getUserName());
		log.info("Manufacturer Name for Id {}  is  {} ", request.getUserName() ,manufactDet.get(0).toString());
		response.setManufacturerDet(manufactDet);
		response.setMessage(manufactUtility.readProperty("MANU_DET_RET_SUCC"));
		response.setStatus(manufactUtility.readProperty("0"));
		}catch (Exception e) {
			log.info("Exception Occurred Due to :: {}",e);
			response.setMessage(manufactUtility.readProperty("DEF_MSG"));
			response.setStatus(manufactUtility.readProperty("1"));
		}
		return response;
	}

}
