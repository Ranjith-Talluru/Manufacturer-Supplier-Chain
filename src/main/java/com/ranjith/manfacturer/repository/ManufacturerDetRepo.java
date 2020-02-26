package com.ranjith.manfacturer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ranjith.manfacturer.entity.ManufacturerDetails;

public interface ManufacturerDetRepo extends JpaRepository<ManufacturerDetails,String>{
	
	public List<ManufacturerDetails> findByManufacturerId(String manufactId);
	
	public List<ManufacturerDetails> findByManufacturerName(String manufactName);

}
