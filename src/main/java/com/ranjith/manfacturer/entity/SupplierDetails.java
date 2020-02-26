package com.ranjith.manfacturer.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table(name = "SUPPLIER_DETAILS")
@Entity
public class SupplierDetails {

	private String manufacturerId;

	private String consumerId;

	private String supplierName;

	private String supplierPhone;

	private String supplierAddress;

	private String supplierZipcode;

}
