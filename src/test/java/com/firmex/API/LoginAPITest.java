package com.firmex.API;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

public class LoginAPITest {

	@Test
	public void firmexLogin() {

		try {

			baseURI = "https://login.firmex.com/authenticate/global";
			RequestSpecification req = RestAssured.given();
			req.header("Content-Type", "application/json");
			JsonObject requestParameters = getJsonString("{\"email\":\"shweta123@gmail.com\",\"password\":\"abc123\"}");
			req.body(requestParameters.toString());
			Response response = req.post("");

			String expectedStr = "{error: {message: \"User credentials are invalid.\", type: \"AccessDenied\"}}";
			String responseStr = response.body().asString();

			JsonObject expectedObj = getJsonString(expectedStr);
			JsonObject responseObj = getJsonString(responseStr);

			// API validation 
			Assert.assertEquals(expectedObj, responseObj); 
			Assert.assertEquals(200, response.getStatusCode());

		} catch (Exception e) {
			System.out.println("Error Message for Firmex API Login:" + e.getMessage());
		}

	}

	private JsonObject getJsonString(String stringToParse) throws Exception {

		return new JsonParser().parse(stringToParse).getAsJsonObject();
	}

}




