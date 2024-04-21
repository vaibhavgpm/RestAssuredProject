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
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class differenentMethodsOfPost {

	int id;

	
	//using hashmap
	//@Test(priority=2)
	void createUserUsingHashmap()
	{
		HashMap data=new HashMap();
		
		data.put("name","pavan");
		data.put("job","trianer");
		
		given().contentType("application/json").body(data)
		
		.when().post("https://reqres.in/api/users")
		
		.then().statusCode(201)
		.body("name", equalTo("pavan"))
		.body("job", equalTo("trianer"))
		.log().all();
	}
	
	//using org.json json library
	//@Test(priority=3)
	void createUserUsingJSONObject()
	{
		JSONObject data=new JSONObject();
		
		data.put("name","john");
		data.put("job","teacher");
		
		given().contentType("application/json").body(data.toString())   //toString need to used with
		
		.when().post("https://reqres.in/api/users/")
		
		.then().statusCode(201)
		.body("name", equalTo("john"))
		.body("job", equalTo("teacher"))
		.log().all();
	}
	
	//using POJO
	//	@Test(priority=3)
		void createUserUsingPOJO()
		{
			POJO data=new POJO();
			
			data.setName("jon");
			data.setJob("teach");
			
			given().contentType("application/json").body(data)   //toString need to used with
			
			.when().post("https://reqres.in/api/users/")
			
			.then().statusCode(201)
			.body("name", equalTo("jon"))
			.body("job", equalTo("teach"))
			.log().all();
		}
	
	
		//using External Json File
		@Test(priority=3)
		void createUserUsingExternalJsonFile()
		{
		      JSONParser parser = new JSONParser();
		      JSONObject jsonObject = null;

		        try (Reader reader = new FileReader("C:\\Users\\lenovo\\Desktop\\CIS Form Qualibar\\persistent.json")) 
		        {

		             jsonObject = (JSONObject) parser.parse(reader);
		            
		            System.out.println(jsonObject);
		            
//		            String states = (String) jsonObject.get("name");
//		            System.out.println(states);
//
//		            String name = (String) jsonObject.get("job");
//		            System.out.println(name);
		            
		        } catch (IOException e) {
		            e.printStackTrace();
		        } catch (ParseException e) {
		            e.printStackTrace();
		        }
			
			given().contentType("application/json").body(jsonObject.toString())   //toString need to used with
			
			.when().post("https://reqres.in/api/users/")
			
			.then().statusCode(201)
			.body("name", equalTo("Ameye"))
			.body("job", equalTo("hr"))
			.log().all();
		}
	

		
		
}


