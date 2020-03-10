package com.ranjith.manfacturer.request;

import lombok.Data;

@Data
public class ManufacturerDetRequest {

	private String manufacturerId;

	private String manufacturerName;

	private String manufacturerPhone;

	private String manufacturerEmailId;

	private String manufacturerAddress;

	private String manufacturerZipcode;

	private String manufacturerVehicleType;

}
