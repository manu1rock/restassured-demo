package apiworkers;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import models.User;

public class HandleContent {
	private static ObjectMapper om = new ObjectMapper();
	
	public static <T> T deSerialize(String file, Class<T> t) throws StreamReadException, DatabindException, IOException {
		return om.readValue(new File(file), t);
	}
	
	public static <T> T getContent(String content, Class<T> t) throws JsonMappingException, JsonProcessingException {
		om.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		
		return om.readValue(content, t);
	}
}
