package com.ranjith.manfacturer.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class ManufacturerUtility {

	@Autowired
	private Environment env;

	public String readProperty(String key) {
		return env.getProperty(key);

	}
}
