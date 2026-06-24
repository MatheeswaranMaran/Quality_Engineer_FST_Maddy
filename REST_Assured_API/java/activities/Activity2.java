package activities;

import java.io.File;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Activity2 {

	// Request and Response Specifications
	RequestSpecification reqSpec;
	ResponseSpecification resSpec;

	// ID Definition
	String id;

	// Setup function
	@BeforeClass
	public void setUp() {
		// Common Request Specification
		reqSpec = new RequestSpecBuilder().setBaseUri("https://api.petstoreapi.com/v1/pets")
				.addHeader("Authorization", "Bearer Matheeswaran").addHeader("Content-Type", "application/json")
				.addHeader("X-Tenant-ID", "550e8400-e29b-41d4-a716-446655443932").build();

		// Common Response Specification
		resSpec = new ResponseSpecBuilder().expectBody("status", Matchers.equalTo("AVAILABLE"))
				.expectResponseTime(Matchers.lessThanOrEqualTo(5000L)).build();
	}

	@Test
	public void postRequest() {
		// JSON request body file
		File inputJSON = new File("src/test/resources/pet.json");

		id = RestAssured.given().relaxedHTTPSValidation().
		// Calling the Request Specification
				spec(reqSpec).
				// Request Body
				body(inputJSON).
				// HTTP Method Specification
				when().post().then().log().all().spec(resSpec).statusCode(201).extract().path("id");

	}
	
	@Test(dependsOnMethods="postRequest")
	public void getRequest() {
		Response res = RestAssured.given().relaxedHTTPSValidation().spec(reqSpec).pathParam("id",id).log().all().
				// Sending the get request
				when().get("/{id}");
		
		res.then().log().all().spec(resSpec).statusCode(200);
	}

	@Test(dependsOnMethods = "getRequest")
	public void deleteRequest() {
		RestAssured.given().relaxedHTTPSValidation().
		// Request Specification
				spec(reqSpec).
				// Path Parameters
				pathParam("id", id).
				// HTTP Method Specification
				when().delete("/{id}").
				// Response
				then().
				// Response Log Function
				log().all().			
				// Assert the status code
				statusCode(204);
	}
}
