package examples;

import java.util.HashMap;
import java.util.Map;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class FirstTest {
	// POST Request: https://api.petstoreapi.com/v1/pets
	@Test(priority = 1)
	public void postRequestTest() {
		// Request Body Initialization
		Map<String, Object> reqBody = new HashMap<>();
		reqBody.put("name", "Shen");
		reqBody.put("species", "BIRD");
		reqBody.put("breed", "Peacock");
		reqBody.put("ageMonths", 240);
		reqBody.put("price", "400");
		reqBody.put("currency", "USD");
		reqBody.put("status", "AVAILABLE");

		// Request Specifications
		RestAssured.given().relaxedHTTPSValidation().
		// Common part of the request URL
				baseUri("https://api.petstoreapi.com/v1/pets").
				// Required Headers of the request
				header("Content-Type", "application/json"). // The content types are all same. //
				// header(ContentType.JSON)
				header("Authorization", "Bearer Matheeswaran")
				.header("X-Tenant-ID", "550e8400-e29b-41d4-a716-446655443932").
				// Request Body
				body(reqBody).
				// Request Log Functions
				log().all().
				// HTTP Method Specification
				when().post().
				// Response
				then().
				// Response Log Functions
				log().body().
				// Assertions
				statusCode(201).body("status", Matchers.equalTo("AVAILABLE"));
	}

	// GET Request: https://api.petstoreapi.com/v1/pets?status=AVAILABLE

	@Test(dependsOnMethods = "postRequestTest")
	public void getRequestWithQueryParams() {
		// Request Specification
		Response response = RestAssured.given().relaxedHTTPSValidation().
		// Common part of the request URL
				baseUri("https://api.petstoreapi.com/v1/pets")
				// Request Headers
				.header("X-Tenant-ID", "550e8400-e29b-41d4-a716-446655443932").
				// Query Parameters
				queryParam("status", "AVAILABLE").
				// Log Functions
				log().all().
				// HTTP Method Specification
				when().get();

		// Get the response body
		System.out.println(response.getBody().asString());
		System.out.println(response.getBody().asPrettyString());

		// Get the response header
		System.out.println(response.getHeaders().asList());

		// Get the response status code
		System.out.println(response.getStatusCode());

		// Extract values from the response JSON
		String petStatus = response.then().extract().path("status");

		System.out.println(petStatus);

	}

	// DELETE Request: https://api.petstoreapi.com/v1/pets/{id}
	@Test(dependsOnMethods = "getRequestWithQueryParams")
	public void deleteRequestWithPathParam() {
		// Request Specification
		RestAssured.given().relaxedHTTPSValidation().
		// Common part of the request URL
				baseUri("https://api.petstoreapi.com/v1/pets")
				// Request Headers
				.header("X-Tenant-ID", "550e8400-e29b-41d4-a716-446655443932")
				.header("Authorization", "Bearer Matheeswaran").
				// Path Parameter
				pathParam("id", "019eda4e-bf47-77f0-9d6a-b8940f807b9e").
				// Log Functions
				log().all().
				// HTTP Method Specification
				when().delete("/{id}").then().log().all().statusCode(204);
	}

}
