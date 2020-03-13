package com.ranjith.manfacturer.util;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class CustomDateFormatCreator extends JsonSerializer<LocalDateTime> {    
    @Override
    public void serialize(LocalDateTime dateValue, JsonGenerator gen, SerializerProvider arg2) throws 
        IOException, JsonProcessingException {      

		/*
		 * SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss a");
		 * String formattedDate = formatter.format(dateValue);
		 */

        String convertedDate = dateValue.format(DateTimeFormatter.ofPattern("dd-MMM-yyyy HH:mm:ss a"));
        gen.writeString(convertedDate);

    }
}


