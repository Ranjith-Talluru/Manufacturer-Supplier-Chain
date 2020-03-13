package com.ranjith.manfacturer.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.ranjith.manfacturer.util.CustomDateFormatCreator;
import com.ranjith.manfacturer.util.LocalDateTimeAttributeConverter;

import lombok.Data;

@Entity
@Table(name = "manfacturer_details", schema = "public")
@Data

public class ManufacturerDetails {

	@Id
	@Column(name = "MFG_ID")
	private String manufacturerId;

	@Column(name = "MFG_NAME")
	private String manufacturerName;

	@Column(name = "MFG_PHONE_NO")
	private String manufacturerPhone;

	@Column(name = "MFG_EMAIL")
	private String manufacturerEmailId;

	@Column(name = "MFG_ADDRESS")
	private String manufacturerAddress;

	@Column(name = "MFG_ZIPCODE")
	private String manufacturerZipcode;

	@Column(name = "MFG_VEHICLE_TYPES")
	private String manufacturerVehicleType;
	
	@JsonSerialize(using = CustomDateFormatCreator.class) 
	@Convert(converter = LocalDateTimeAttributeConverter.class)
	@Column(name = "CREATED_ON")
	private LocalDateTime createdOn;

}
