package RestAssuredTest.RestAssuredTest;
import java.util.HashMap;

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

public class PathAndQuerryParameter {

	int id;
	@Test(priority=1)
	void testQueryAndPathParameter()
	{
		given()
		.pathParam("mypath","users")
		.queryParam("page",2)
		.queryParam("id",5)
		
		.when()
		  .get("https://reqres.in/api/{mypath}")
		
		.then()
			.statusCode(200)
				.log().all(); 
	}
	}

