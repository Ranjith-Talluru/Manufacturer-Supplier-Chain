package com.ranjith.manfacturer.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="MANFACTURER_DETAILS")
@Data

public class ManufacturerDetails {

	private String manufacturerName;
	
	private String manufacturerId;
	
	private String manufacturerPhone;
	
	private String manufacturerAddress;
	
	private String manufacturerZipcode;
	
	private String manufacturerVehicleType;

}
