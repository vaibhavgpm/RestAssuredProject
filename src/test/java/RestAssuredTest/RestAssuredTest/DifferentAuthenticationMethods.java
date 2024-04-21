package RestAssuredTest.RestAssuredTest;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.io.File;
import java.io.FileReader;

import com.google.common.io.Files;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;


import org.json.simple.parser.JSONParser;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;

public class DifferentAuthenticationMethods {

	//basic digest and preemtive are more or less same
	//	@Test(priority=1)
		void testBasicAuthentication()
		{
		
			
			given()
			   .auth().basic("postman","password")
			
			.when()
			   .get("https://postman-echo.com/basic-auth")
			
			.then()
			    .statusCode(200)
				.body("authenticated", equalTo(true))
				.log().all();
		}
		
		
	//	@Test(priority=2)
		void testDigestAuthentication()
		{
		
			
			given()
			   .auth().digest("postman","password")
			
			.when()
			   .get("https://postman-echo.com/basic-auth")
			
			.then()
			    .statusCode(200)
				.body("authenticated", equalTo(true))
				.log().all();
		}
		
		
	//	@Test(priority=3)
		void testPreemtiveAuthentication()
		{
		       //preemtive combination of digest and basic
			
			given()
			   .auth().preemptive().basic("postman","password")
			
			.when()
			   .get("https://postman-echo.com/basic-auth")
			
			.then()
			    .statusCode(200)
				.body("authenticated", equalTo(true))
				.log().all();
		}
		
		//@Test(priority=3)
		void testBearerAuthentication()
		{
		      
			
			String bearerToken = "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";
			
			given()
			   .headers("Authorization" ,"Bearer " +bearerToken)
			
			.when()
			   .get("https://api.github.com/user/repos")
			
			.then()
			    .statusCode(200)
				.log().all();
		}
		
		
		//@Test(priority=4)
		void testOAuth1Authentication()
		{
		       
			
			given()
			   .auth().oauth("consumerKey", "consumerSecret", "accessToken","secretToken")
			
			.when()
			   .get("url")
			
			.then()
			    .statusCode(200)
				.body("authenticated", equalTo(true))
				.log().all();
		}
	
		@Test(priority=5)
		void testOAuth2Authentication()
		{
			
			
			given()
			   .auth().oauth2("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")
			
			.when()
			   .get("https://api.github.com/user/repos")
			
			.then()
			    .statusCode(200)
				.log().all();
		}
		
		
}
