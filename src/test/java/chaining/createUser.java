package chaining;



import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import java.io.File;
import java.io.FileReader;

import com.google.common.io.Files;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.json.simple.parser.JSONParser;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import org.testng.internal.Systematiser;

import static org.hamcrest.Matchers.*;

import org.json.JSONObject;

import com.github.javafaker.Faker;

public class createUser {
	
	
	@Test
	void test_createUser(ITestContext context)
	{
		Faker faker =new Faker();
		
		JSONObject data = new JSONObject();
		
		data.put("name", faker.name().fullName());
		data.put("gender", "Male");
		data.put("email", faker.internet().emailAddress());
		data.put("status" , "inactive");
		
		String bearerToken ="3d2d3b6743433c6e6e5ade011f566ee3d833cf46d0f4d7b1737296f3a4318477";
		
		int id =given()
		   .headers("Authorization" ,"Bearer " +bearerToken)
		   .contentType("application/json")
		   .body(data.toString())
		
		.when()
		   .post("https://gorest.co.in/public/v2/users")
		   .jsonPath().getInt("id");
		
		System.out.println("Generated Id " +id);
		
		context.getSuite().setAttribute("user_id", id);
		   
		
		
		
		
		
				
	}

}
