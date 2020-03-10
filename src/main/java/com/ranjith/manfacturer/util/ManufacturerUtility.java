package com.ranjith.manfacturer.util;

import java.util.stream.Stream;

import org.apache.commons.lang3.StringUtils;
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

	public static boolean hasNullOrEmptyString(String... values) {
		boolean hasNullOrEmptyString = Stream.of(values).anyMatch(StringUtils::isBlank);
		return hasNullOrEmptyString;
	}
}
