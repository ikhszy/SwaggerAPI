package com.SwaggerAPI.utilities;

import org.testng.annotations.BeforeClass;
import io.restassured.RestAssured;

public class BaseClass {

	ReadConfig reader = new ReadConfig();
	
	public String baseURI = reader.getBaseURI();
	public String booksPath = reader.getBooksPath();
	public String bookPath = reader.getBookPath();
	public String authPath = reader.getAuthPath();
	public String tokenPath = reader.getTokenPath();
	public String userPath = reader.getUserPath();
	
	@BeforeClass
	public void setup() {
		RestAssured.baseURI = baseURI;
	}
}
