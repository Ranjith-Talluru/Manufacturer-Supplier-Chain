package com.ranjith.manfacturer.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table(name = "CONSUMER_DETAILS")
@Entity

public class ConsumerDetails {

	private String consumerName;

	private String consumerId;

	private String consumerPhone;

	private String consumerAddress;

	private String consumerZipcode;

	private String consumerVehicleType;

	private String consumerHoldingVehicleType;

}
