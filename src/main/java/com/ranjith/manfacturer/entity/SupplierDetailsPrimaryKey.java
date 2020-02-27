package com.ranjith.manfacturer.entity;

import java.io.Serializable;

import javax.persistence.Column;

import lombok.Data;

@SuppressWarnings("all")
@Data
public class SupplierDetailsPrimaryKey implements Serializable {

	@Column(name="")
	private String manufacturerId;

	@Column(name="")
	private String consumerId;

}
