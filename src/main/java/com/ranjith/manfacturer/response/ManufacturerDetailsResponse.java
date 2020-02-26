package com.ranjith.manfacturer.response;

import java.util.List;

import com.ranjith.manfacturer.entity.ManufacturerDetails;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class ManufacturerDetailsResponse extends CommonResponse{
	
	private List<ManufacturerDetails> manufacturerDet;

}


