package com.ranjith.manfacturer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ranjith.manfacturer.entity.ManufacturerDetails;

@Repository
public interface ManufacturerDetRepo extends JpaRepository<ManufacturerDetails,String>{
	
	@Transactional(readOnly=true)
	public List<ManufacturerDetails> findByManufacturerId(String manufactId);
	
	public List<ManufacturerDetails> findByManufacturerName(String manufactName);
	
	@Transactional
	public void deleteByManufacturerId(String manufactId);

}
