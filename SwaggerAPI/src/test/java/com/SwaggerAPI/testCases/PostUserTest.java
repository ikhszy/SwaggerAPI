package com.SwaggerAPI.testCases;

import static io.restassured.RestAssured.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.SwaggerAPI.utilities.BaseClass;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class PostUserTest extends BaseClass {
	
	String validPostBody = postUserBody();

	@Test(priority=1)
	public void PSTUSR001() {
		System.out.println("Running PSTUSR001...");
		
		RestAssured.basePath = userPath;
		
		Response response = given()
				.contentType(ContentType.JSON)
				.body(validPostBody)
				.when()
				.post()
				.then()
				.extract().response();

		JsonPath jsp = response.jsonPath();
		
		String userId = jsp.get("userID");
		String username = jsp.get("username");
		
		if(username.equals(userName) && !userId.isEmpty()) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}
	
}
