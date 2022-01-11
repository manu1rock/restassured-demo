package apiworkers;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import models.User;
import models.UserRes;

public class ApiWorker {
	private final String BASE_URL = "https://reqres.in/";
	private RequestSpecification request;
	
	public ApiWorker() {
		RestAssured.baseURI = BASE_URL;
		request = RestAssured.given();
		request.header("Content-Type", "application/json");
	}
	
	public Response createUser(User user) throws StreamReadException, DatabindException, IOException {		

		return request.body(user).post(Endpoints.users());
	}
	
	public Response getUserList() {
		
		return request.get(Endpoints.listUsers());
	}

}
