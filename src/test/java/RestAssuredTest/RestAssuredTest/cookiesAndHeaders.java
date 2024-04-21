package RestAssuredTest.RestAssuredTest;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

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
import org.testng.annotations.Test;
import org.testng.internal.Systematiser;

import static org.hamcrest.Matchers.*;
public class cookiesAndHeaders 
{
	//@Test
	void getCookie()
	{
		
		
		Response res = given()
		
		.when().get("https://www.google.com/");
		
//		String cookie_value=res.getCookie("AEC");
//		System.out.println("cookie_value=>"+cookie_value);
		
		Map <String ,String> cookie_values = res.getCookies();
		
		
		for (Map.Entry<String, String> h : cookie_values.entrySet())
		{
		System.out.println(h.getKey() + "     " + h.getValue());
		
		}
	}

	@Test
	void testHeaders()
	{
		
		
		given()
		
		.when().get("https://www.google.com/")
		
         .then()
             .header("Content-Type","text/html; charset=ISO-8859-1")
             .header("Content-Encoding","gzip")
             .header("Server","gws")
             
            // .log().body()
		    // .log().headers()
            // .log().cookies();
             
             .log().all();
	}
	
	@Test
	void getHeaders()
	{
		
		
		Response res=given()
		
		.when().get("https://www.google.com/");
		
		Headers myheader=res.getHeaders();
		
		for(Header hd : myheader)
		{
			System.out.println(hd.getName() +  "   " + hd.getValue());
		}

	}
}
