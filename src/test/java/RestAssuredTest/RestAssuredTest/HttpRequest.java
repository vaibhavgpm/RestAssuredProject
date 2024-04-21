package RestAssuredTest.RestAssuredTest;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.io.File;
import com.google.common.io.Files;
import java.io.IOException;
import java.util.HashMap;

import org.testng.Assert;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class HttpRequest {

	int id;
	//@Test(priority=1)
	void getUsers()
	{
		given()
		
		.when()
		  .get("https://reqres.in/api/users?page=2")
		
		.then()
			.statusCode(200)
				.body("page",equalTo(2))  //Rest Assured Matchers
				.log().all(); 
		
	}
	
	
	@Test(priority=2)
	void createUser()
	{
		HashMap data=new HashMap();
		
		data.put("name","pavan");
		data.put("job","trianer");
		
		id=given().contentType("application/json").body(data)
		
		.when().post("https://reqres.in/api/users").jsonPath().getInt("id");
		
		//.then().statusCode(201).log().all();
	}
	
	//@Test(priority=3,dependsOnMethods= {"createUser"})
	void updateUser()
	{
		HashMap data=new HashMap();
		
		data.put("name","john");
		data.put("job","teacher");
		
		given().contentType("application/json").body(data)
		
		.when().put("https://reqres.in/api/users/"+id)
		
		.then().statusCode(200).log().all();
	}
	
	//@Test(priority=4)
	void deleteUser()
	{
		
		
		given()
		
		.when().delete("https://reqres.in/api/users/"+id)
		
		.then().statusCode(204).log().all();
	}
	
}
