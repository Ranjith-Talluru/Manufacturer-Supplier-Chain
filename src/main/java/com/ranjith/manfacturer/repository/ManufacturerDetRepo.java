package com.ranjith.manfacturer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ranjith.manfacturer.entity.ManufacturerDetails;

public interface ManufacturerDetRepo extends JpaRepository<ManufacturerDetails,String>{

}
