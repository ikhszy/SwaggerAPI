package com.SwaggerAPI.utilities;

import java.util.HashMap;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;

import io.restassured.RestAssured;

public class BaseClass {

	ReadConfig reader = new ReadConfig();
	
	public String baseURI = reader.getBaseURI();
	public String booksPath = reader.getBooksPath();
	public String bookPath = reader.getBookPath();
	public String authPath = reader.getAuthPath();
	public String tokenPath = reader.getTokenPath();
	public String userPath = reader.getUserPath();
	
	@SuppressWarnings("rawtypes")
	public HashMap map = new HashMap();
	public String userName = randomString() + "@gmail.com";
	
	public String randomString() {
		String rdmString = RandomStringUtils.randomAlphanumeric(8);
		return rdmString;
	}
	
	public String randomNumber() {
		String rdmNum = RandomStringUtils.randomNumeric(3);
		return rdmNum;
	}
	
	public String postUserBody() {
		String userBody = "{\n" + 
				"\"userName\": \"" + userName + "\",\n" + 
				"\"password\": \"Welcome@111\"\n" + 
				"}";
		return userBody;
	}
	
	@BeforeClass
	public void setup() {
		RestAssured.baseURI = baseURI;
	}
}
