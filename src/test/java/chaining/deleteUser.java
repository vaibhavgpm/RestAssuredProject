package chaining;

import static io.restassured.RestAssured.given;

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

public class deleteUser {
	
	@Test
	void getUser(ITestContext context)
	{
		
		int id=(int) context.getAttribute("user_id");
	
	String bearerToken ="3d2d3b6743433c6e6e5ade011f566ee3d833cf46d0f4d7b1737296f3a4318477";
	
	given()
	   .headers("Authorization" ,"Bearer " +bearerToken)
	   .contentType("application/json")
	   .pathParam("id", id )
	   
	
	.when()
	   .delete("https://gorest.co.in/public/v2/users/{id}")
	   
	.then()
	   .statusCode(204)
	   .log().all();
	  
	
	}

}
