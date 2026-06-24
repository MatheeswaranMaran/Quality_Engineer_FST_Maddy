package activities;

import java.util.HashMap;
import java.util.Map;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Activity1 {
	// URL Initialization
	String url;

	// ID
	String id;

	@BeforeClass
	public void setUp() {
		url = "https://api.petstoreapi.com/v1/pets";
	}

	@Test
	public void postRequest() {
		// Request Body Initialization
		Map<String, Object> reqBody = new HashMap<>();
		reqBody.put("name", "Shen");
		reqBody.put("species", "BIRD");
		reqBody.put("breed", "Peacock");
		reqBody.put("ageMonths", 240);
		reqBody.put("price", "400");
		reqBody.put("currency", "USD");
		reqBody.put("status", "AVAILABLE");

		Response res = RestAssured.given().relaxedHTTPSValidation().
		// Common URL
				baseUri(url)
				// Required Headers
				.header("Authorization", "Bearer Matheeswaran")
				.header("X-Tenant-ID", "550e8400-e29b-41d4-a716-446655443932").
				// Request Body
				body(reqBody).
				// HTTP Method Specification
				when().post();

		// Extract the id from the response
		id = res.then().extract().path("id");

		res.then().log().all().statusCode(201).body("name", Matchers.equalTo("Shen"));
	}

	@Test(dependsOnMethods = "postRequest")
	public void deleteRequest() {
		RestAssured.given().relaxedHTTPSValidation().
		// Common URL
				baseUri(url).
				// Required Header
				header("Authorization", "Bearer Matheeswaran")
				.header("X-Tenant-ID", "550e8400-e29b-41d4-a716-446655443932").
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
