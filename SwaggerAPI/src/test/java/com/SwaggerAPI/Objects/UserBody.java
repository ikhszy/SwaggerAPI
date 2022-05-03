package com.SwaggerAPI.Objects;

import java.util.HashMap;

import org.apache.commons.lang3.RandomStringUtils;

public class UserBody {
	
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
	
	public String emptyEmail() {
		String userBody = "{\n" + 
				"\"userName\": \"" + "\",\n" + 
				"\"password\": \"Welcome@111\"\n" + 
				"}";
		return userBody;
	}
	
	public String emptyPassword() {
		String userBody = "{\n" + 
				"\"userName\": \"" + userName + "\",\n" + 
				"\"password\": \"\"\n" + 
				"}";
		return userBody;
	}
	
	public String existingEmail() {
		String userBody = "{\n" + 
				"\"userName\": \"keongmas@gmail.com\",\n" + 
				"\"password\": \"Welcome@111\"\n" + 
				"}";
		return userBody;
	}
	
	public String emptyBody() {
		String userBody = "{\n" + 
				"}";
		return userBody;
	}
	
	public String userInvalidKeys() {
		String userBody = "{\n" + 
				"\"userNamezS\": \"cucokmeong@gmail.com\",\n" + 
				"\"paword\": \"hey\"\n" + 
				"}";
		return userBody;
	}

}
