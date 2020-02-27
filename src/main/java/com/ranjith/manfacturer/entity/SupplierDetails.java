package com.ranjith.manfacturer.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table(name = "SUPPLIER_DETAILS")
@Entity
public class SupplierDetails {

	@EmbeddedId
	private SupplierDetailsPrimaryKey supplierDetPk;

	@Column(name="")
	private String supplierName;

	@Column(name="")
	private String supplierPhone;

	@Column(name="")
	private String supplierAddress;

	@Column(name="")
	private String supplierZipcode;

}
