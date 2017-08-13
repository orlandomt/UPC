package com.springboot.json;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class JsonHourSimpleSerializer extends JsonSerializer<Date> {
    private SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss.SSS'Z'");
    //new SimpleDateFormat("dd/MM/yyyy");

	@Override
	public void serialize (Date value, JsonGenerator gen, SerializerProvider arg2)
	    throws IOException, JsonProcessingException {
	gen.writeString(formatter.format(value));
	}
}

