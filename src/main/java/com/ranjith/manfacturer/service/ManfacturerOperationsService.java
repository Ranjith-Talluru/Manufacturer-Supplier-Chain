package com.ranjith.manfacturer.service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ranjith.manfacturer.entity.ManufacturerDetails;
import com.ranjith.manfacturer.repository.ManufacturerDetRepo;
import com.ranjith.manfacturer.request.ManufacturerDetRequest;
import com.ranjith.manfacturer.response.ManufacturerDetailsResponse;
import com.ranjith.manfacturer.util.ManufacturerUtility;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@SuppressWarnings("all")
public class ManfacturerOperationsService {

	@Autowired
	private ManufacturerDetRepo manufactRepo;

	@Autowired
	private ManufacturerUtility manufactUtility;

	public ManufacturerDetailsResponse getManufacturerDetById(String manufactId) {
		log.info("------------------- Manufact Oper Serv getManufacturerDetById  -------------------");
		ManufacturerDetailsResponse response = new ManufacturerDetailsResponse();
		try {

			List<ManufacturerDetails> manufactDet = manufactRepo.findByManufacturerId(manufactId);
			log.info("Manufacturer Details Retrieved from DB If founf for Id :: {}",manufactId);
			response.setManufacturerDet(manufactDet);
			response.setMessage(manufactUtility.readProperty("MANU_DET_RET_SUCC"));
			response.setStatus(manufactUtility.readProperty("0"));
		} catch (Exception e) {
			log.info("Exception Occurred Due to :: {}", e);
			response.setMessage(manufactUtility.readProperty("DEF_MSG"));
			response.setStatus(manufactUtility.readProperty("1"));
		}
		return response;
	}

	public ManufacturerDetailsResponse getManufacturerDetByName(String manufactName) {
		log.info("------------------- Manufact Oper Serv getManufacturerDetByName  -------------------");
		ManufacturerDetailsResponse response = new ManufacturerDetailsResponse();
		try {

			List<ManufacturerDetails> manufactDet = manufactRepo.findByManufacturerName(manufactName);
			log.info("Manufacturer Details are  {} ", manufactDet.get(0).toString());
			response.setManufacturerDet(manufactDet);
			response.setMessage(manufactUtility.readProperty("MANU_DET_RET_SUCC"));
			response.setStatus(manufactUtility.readProperty("0"));
		} catch (Exception e) {
			log.info("Exception Occurred Due to :: {}", e);
			response.setMessage(manufactUtility.readProperty("DEF_MSG"));
			response.setStatus(manufactUtility.readProperty("1"));
		}
		return response;
	}


	public ManufacturerDetailsResponse updateManfacturerById(ManufacturerDetRequest manufactDet) {
		log.info("------------------- Manufact Oper Serv updateManfacturerById  -------------------");
		ManufacturerDetailsResponse response = new ManufacturerDetailsResponse();
		try {
			ManufacturerDetails manufactDetSave = new ManufacturerDetails();
			boolean isNullOrEmpty = manufactUtility.hasNullOrEmptyString(manufactDet.getManufacturerId(),
					manufactDet.getManufacturerName(), manufactDet.getManufacturerVehicleType(),
					manufactDet.getManufacturerZipcode(), manufactDet.getManufacturerPhone());
			if (!isNullOrEmpty) {
				manufactDetSave.setManufacturerId(manufactDet.getManufacturerId());
				manufactDetSave.setManufacturerName(manufactDet.getManufacturerName());
				manufactDetSave.setManufacturerPhone(manufactDet.getManufacturerPhone());
				manufactDetSave.setManufacturerVehicleType(manufactDet.getManufacturerVehicleType());
				manufactDetSave.setManufacturerZipcode(manufactDet.getManufacturerZipcode());
				manufactDetSave.setCreatedOn(LocalDateTime.now());
				manufactRepo.save(manufactDetSave);
				response.setMessage(manufactUtility.readProperty("MANU_DET_SAVE_SUCC"));
				response.setStatus(manufactUtility.readProperty("0"));
			} else {
				response.setMessage(manufactUtility.readProperty("FIELDS_MISSING"));
				response.setStatus(manufactUtility.readProperty("1"));
			}

		} catch (Exception e) {
			log.info("Exception Occurred Due to :: {}", e);
			response.setMessage(manufactUtility.readProperty("DEF_MSG"));
			response.setStatus(manufactUtility.readProperty("1"));
		}
		return response;
	}

	public ManufacturerDetailsResponse addManufacturer(ManufacturerDetRequest manufactDet) {
		log.info("------------------- Manufact Oper Serv addManufacturer  -------------------");
		ManufacturerDetailsResponse response = new ManufacturerDetailsResponse();
		try {
			ManufacturerDetails manufactDetSave = new ManufacturerDetails();
			log.info("Manufacturer Addition :: Manufact Det ::  {} "+ manufactDet.toString());
			boolean isNullOrEmpty = manufactUtility.hasNullOrEmptyString(manufactDet.getManufacturerId(),
					manufactDet.getManufacturerName(), manufactDet.getManufacturerEmailId(),
					manufactDet.getManufacturerAddress(), manufactDet.getManufacturerVehicleType(),
					manufactDet.getManufacturerZipcode(), manufactDet.getManufacturerPhone());
			if (!isNullOrEmpty) {

				manufactDetSave.setManufacturerId(manufactDet.getManufacturerId());
				manufactDetSave.setManufacturerName(manufactDet.getManufacturerName());
				manufactDetSave.setManufacturerPhone(manufactDet.getManufacturerPhone());
				manufactDetSave.setManufacturerEmailId(manufactDet.getManufacturerEmailId());
				manufactDetSave.setManufacturerAddress(manufactDet.getManufacturerAddress());
				manufactDetSave.setManufacturerVehicleType(manufactDet.getManufacturerVehicleType());
				manufactDetSave.setManufacturerZipcode(manufactDet.getManufacturerZipcode());
				manufactDetSave.setCreatedOn(LocalDateTime.now());
				manufactRepo.save(manufactDetSave);
				response.setMessage(manufactUtility.readProperty("MANU_DET_SAVE_SUCC"));
				response.setStatus(manufactUtility.readProperty("0"));
			} else {
				response.setMessage(manufactUtility.readProperty("FIELDS_MISSING"));
				response.setStatus(manufactUtility.readProperty("1"));
			}

		} catch (Exception e) {
			log.info("Exception Occurred Due to :: {}", e);
			response.setMessage(manufactUtility.readProperty("DEF_MSG"));
			response.setStatus(manufactUtility.readProperty("1"));
		}
		return response;
	}

	public ManufacturerDetailsResponse deleteManufacturerDetById(String manufactId) {
		log.info("------------------- Manufact Oper Serv deleteManufacturerDetById  -------------------");
		ManufacturerDetailsResponse response = new ManufacturerDetailsResponse();
		try {
			log.info( "Deleting ManufacturerId {}  ", manufactId);
			manufactRepo.deleteByManufacturerId(manufactId);
			response.setMessage(manufactUtility.readProperty("MANU_DET_RET_SUCC"));
			response.setStatus(manufactUtility.readProperty("0"));
		} catch (Exception e) {
			log.info("Exception Occurred Due to :: {}", e);
			response.setMessage(manufactUtility.readProperty("DEF_MSG"));
			response.setStatus(manufactUtility.readProperty("1"));
		}
		return response;
	}
}
