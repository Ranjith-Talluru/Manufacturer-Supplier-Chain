package com.ranjith.manfacturer.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
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
	
	private HibernateTemplate hibernateTemplate;
	private Session session;
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		hibernateTemplate = new HibernateTemplate(sessionFactory);
		session = sessionFactory.openSession();
	}

	public ManufacturerDetailsResponse getManufacturerDetById(String manufactId) {
		log.info("------------------- Manufact Oper Serv getManufacturerDetById  -------------------");
		ManufacturerDetailsResponse response = new ManufacturerDetailsResponse();
		try {

			List<ManufacturerDetails> manufactDet = manufactRepo.findByManufacturerId(manufactId);
			log.info("Manufacturer Name for Id {}  is  {} ", manufactId, manufactDet.get(0).toString());
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
		log.info("Manufacturer Details are  {} " ,manufactDet.get(0).toString());
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
	

	/**
	 * @param manufactDet
	 *  
	 * Used Hibernate Implementation to Update Details
	 */
	public ManufacturerDetailsResponse updateManfacturerById(ManufacturerDetRequest manufactDet) {
		log.info("------------------- Manufact Oper Serv updateManfacturerById  -------------------");
		ManufacturerDetailsResponse response = new ManufacturerDetailsResponse();
		try {
			ManufacturerDetails manufactDetSave = new ManufacturerDetails();
			boolean isNullOrEmpty = manufactUtility.hasNullOrEmptyString(manufactDet.getManufacturerId(),
					manufactDet.getManufacturerName(), manufactDet.getManufacturerVehicleType(),
					manufactDet.getManufacturerZipcode(), manufactDet.getManufacturerPhone());
			if (isNullOrEmpty) {
				manufactDetSave.setManufacturerId(manufactDet.getManufacturerId());
				manufactDetSave.setManufacturerName(manufactDet.getManufacturerName());
				manufactDetSave.setManufacturerPhone(manufactDet.getManufacturerPhone());
				manufactDetSave.setManufacturerVehicleType(manufactDet.getManufacturerVehicleType());
				manufactDetSave.setManufacturerZipcode(manufactDet.getManufacturerZipcode());
				hibernateTemplate.saveOrUpdate(manufactDetSave);
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
			boolean isNullOrEmpty = manufactUtility.hasNullOrEmptyString(manufactDet.getManufacturerId(),
					manufactDet.getManufacturerName(), manufactDet.getManufacturerEmailId(),manufactDet.getManufacturerAddress(), manufactDet.getManufacturerVehicleType(),
					manufactDet.getManufacturerZipcode(), manufactDet.getManufacturerPhone());
			if (isNullOrEmpty) {
				
				manufactDetSave.setManufacturerId(manufactDet.getManufacturerId());
				manufactDetSave.setManufacturerName(manufactDet.getManufacturerName());
				manufactDetSave.setManufacturerPhone(manufactDet.getManufacturerPhone());
				manufactDetSave.setManufacturerEmailId(manufactDet.getManufacturerEmailId());
				manufactDetSave.setManufacturerAddress(manufactDet.getManufacturerAddress());
				manufactDetSave.setManufacturerVehicleType(manufactDet.getManufacturerVehicleType());
				manufactDetSave.setManufacturerZipcode(manufactDet.getManufacturerZipcode());
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

			manufactRepo.deleteByManufacturerId(manufactId);
			log.info("ManufacturerId {} Deleted  ", manufactId);
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
