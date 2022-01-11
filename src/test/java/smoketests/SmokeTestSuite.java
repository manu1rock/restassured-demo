package smoketests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import apiworkers.ApiWorker;
import apiworkers.HandleContent;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import models.User;
import models.UserRes;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.ResponseAwareMatcher.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.IOException;

public class SmokeTestSuite {
	private Response response;
	
	@Test	
	public void verify_status_code_is_success() {
		given().
		when().
		      get("https://reqres.in/api/users?page=2").
		then().
		      assertThat().
		      statusCode(200);
	}
	
	@Test	
	public void verify_page_number() throws JsonMappingException, JsonProcessingException {
		ApiWorker api = new ApiWorker();
		response = api.getUserList();
		
		UserRes user = HandleContent.getContent(response.getBody().asString(), UserRes.class);
		
		Assert.assertTrue(2 == user.getPage());
	}
	
	@Test
	public void create_new_user_with_valid_input() throws StreamReadException, DatabindException, IOException {
		//arrange
		User user = HandleContent.deSerialize("D:\\Manoj\\Project\\com.restapitesting\\schema\\user.json", User.class);
		
		//act
		ApiWorker api = new ApiWorker();
		response = api.createUser(user);
		
		//assert
		Assert.assertEquals(user.getName(), response.then().extract().path("name").toString());
	}

}















