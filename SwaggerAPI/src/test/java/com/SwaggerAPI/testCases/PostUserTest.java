package com.SwaggerAPI.testCases;

import static io.restassured.RestAssured.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.SwaggerAPI.utilities.BaseClass;
import com.SwaggerAPI.Objects.UserBody;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class PostUserTest extends BaseClass {
	
	UserBody usb = new UserBody();
	String validPostBody = usb.postUserBody();
	String emptyEmailBody = usb.emptyEmail();
	String emptyPassBody = usb.emptyPassword();
	String existingEmailBody = usb.existingEmail();

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
		
		if(username.equals(usb.userName) && !userId.isEmpty()) {
			Assert.assertTrue(true);
		} else {
			System.out.println("FAILED LOG");
			System.out.println(response.asPrettyString());
			Assert.assertTrue(false);
		}
	}
	
	@Test(priority=2)
	public void PSTUSR002() {
		System.out.println("Running PSTUSR002...");
		
		RestAssured.basePath = userPath;
		
		Response response = given()
				.contentType(ContentType.JSON)
				.body(emptyEmailBody)
				.when()
				.post()
				.then()
				.extract().response();
		
		JsonPath jsp = response.jsonPath();
		
		String code = jsp.get("code");
		String message = jsp.get("message");
		
		if(message.contains("UserName and Password required.") && code.equals("1200")) {
			Assert.assertTrue(true);
		} else {
			System.out.println("FAILED LOG");
			System.out.println("code: " + code);
			System.out.println("message: " + message);
			Assert.assertTrue(false);
		}	
	}
	
	@Test(priority=3)
	public void PSTUSR003() {
		System.out.println("Running PSTUSR003...");
		
		RestAssured.basePath = userPath;
		
		Response response = given()
				.contentType(ContentType.JSON)
				.body(emptyPassBody)
				.when()
				.post()
				.then()
				.extract().response();
		
		JsonPath jsp = response.jsonPath();
		
		String code = jsp.get("code");
		String message = jsp.get("message");
		
		if(message.contains("UserName and Password required.") && code.equals("1200")) {
			Assert.assertTrue(true);
		} else {
			System.out.println("FAILED LOG");
			System.out.println("code: " + code);
			System.out.println("message: " + message);
			Assert.assertTrue(false);
		}	
	}
	
	@Test(priority=4)
	public void PSTUSR004() {
		System.out.println("Running PSTUSR004...");
		
		RestAssured.basePath = userPath;
		
		Response response = given()
				.contentType(ContentType.JSON)
				.body(existingEmailBody)
				.when()
				.post()
				.then()
				.extract().response();
		
		JsonPath jsp = response.jsonPath();
		
		String code = jsp.get("code");
		String message = jsp.get("message");
		
		if(message.contains("User exists") && code.equals("1204")) {
			Assert.assertTrue(true);
		} else {
			System.out.println("FAILED LOG");
			System.out.println("code: " + code);
			System.out.println("message: " + message);
			Assert.assertTrue(false);
		}	
	}
	
}
