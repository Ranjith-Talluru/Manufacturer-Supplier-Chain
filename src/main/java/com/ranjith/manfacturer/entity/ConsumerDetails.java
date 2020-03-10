package com.ranjith.manfacturer.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table(name = "CONSUMER_DETAILS", schema="public")
@Entity

public class ConsumerDetails {

	@Id
	@Column(name = "CNSMR_ID")
	private String consumerId;

	@Column(name = "CNSMR_NAME")
	private String consumerName;

	@Column(name = "CNSMR_PHONE_NO")
	private String consumerPhone;

	@Column(name = "CNSMR_EMAIL")
	private String consumerEmailId;

	@Column(name = "CNSMR_ADDRESS")
	private String consumerAddress;

	@Column(name = "CNSMR_ZIPCODE")
	private String consumerZipcode;

	@Column(name = "CNSMR_HOLDING_VEHICLE_TYPES")
	private String consumerHoldingVehicleType;
	
	@Column(name = "CREATED_ON")
	private String createdOn;

}
