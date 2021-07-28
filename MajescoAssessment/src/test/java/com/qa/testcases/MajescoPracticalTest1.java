package com.qa.testcases;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.base.TestBase;
import com.qa.pojo.BoredAPIResponse;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;


public class MajescoPracticalTest1 {

	@Test
	public void getKey() throws JsonMappingException, JsonProcessingException {
		
		
		// Create a request specification 
		RequestSpecification request= RestAssured.given();
		
		//Adding URI
		request.baseUri("https://www.boredapi.com/api/activity");
		
		// Calling GET method on URI. After hitting we get Response
		Response response = request.get();
		
		String resString = response.asString();
		System.out.println("Response Details : " + resString);
 
		
		ValidatableResponse valRes = response.then();
		valRes.statusCode(200);
		valRes.statusLine("HTTP/1.1 200 OK");
		
		ObjectMapper objectMapper = new ObjectMapper();
		BoredAPIResponse boredAPIResponse = objectMapper.readValue(resString, BoredAPIResponse.class);
		int key = boredAPIResponse.getKey();
		System.out.println("Key value is " + key);
		
		String activity = boredAPIResponse.getActivity();
		String type = boredAPIResponse.getType();
		int participants = boredAPIResponse.getParticipants();
		int price = boredAPIResponse.getPrice();
		String link= boredAPIResponse.getLink();
		key= boredAPIResponse.getKey();
		int accessibility=boredAPIResponse.getAccessibility();
		

		
		String strRegex = ".*";
		String intRegex = "[0-9]+";
		
		Assert.assertEquals(activity.matches(strRegex), true);
		Assert.assertEquals(type.matches(strRegex), true);
		Assert.assertEquals(String.valueOf(participants).matches(intRegex), true);
		Assert.assertEquals(String.valueOf(price).matches(intRegex), true);
		Assert.assertEquals(link.matches(strRegex), true);
		Assert.assertEquals(String.valueOf(key).matches(intRegex), true);
		Assert.assertEquals(String.valueOf(accessibility).matches(intRegex), true);
		
		
		
		
		
		
		
		
		
		
 
	}

}
