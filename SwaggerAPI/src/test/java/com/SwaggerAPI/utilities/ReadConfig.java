package com.SwaggerAPI.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
Properties prop;
	
	public ReadConfig() {
		File src = new File("./Configuration/config.properties");
		
		try {
			FileInputStream fis = new FileInputStream(src);
			prop = new Properties();
			prop.load(fis);
			
		} catch(Exception e) {
			System.out.println("exception: " + e.getMessage());
		}
	}
	
	public String getBaseURI() {
		String baseURI = prop.getProperty("baseURI");
		return baseURI;
	}
	
	public String getBooksPath() {
		String booksPath = prop.getProperty("booksPath");
		return booksPath;
	}
	
	public String getBookPath() {
		String bookPath = prop.getProperty("bookPath");
		return bookPath;
	}
	
	public String getAuthPath() {
		String authPath = prop.getProperty("authPath");
		return authPath;
	}
	
	public String getTokenPath() {
		String tokenPath = prop.getProperty("tokenPath");
		return tokenPath;
	}
	
	public String getUserPath() {
		String userPath = prop.getProperty("userPath");
		return userPath;
	}

}
