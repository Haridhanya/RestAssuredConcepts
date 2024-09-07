package restAssuredLearning;


import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
public class ParsingJSONResponseBody {

	//approach 1:using then () validation
	//@Test
	void parsingresponse()
	{
		given()
		.when().get("https://reqres.in/api/users?page=2")
		.then().statusCode(200).body("data[3].first_name", equalTo("Byron"));
	}
	
	
	//approach 2 :using response variable and testng assertions
	//@Test
	void parseResponseUsingResponseVar()
	{
		
	
	Response res=given()
			.when().get("https://reqres.in/api/users?page=2");
	Assert.assertEquals(res.getStatusCode(), 200);
	//get first name to a variable
	
	String name=res.jsonPath().getString("data[3].first_name").toLowerCase();
	System.out.println(name);
	}
	
	//approach for parsing/getting data from json object when its dynamic data
	@Test
	void jsonobject_parsing()
	{
		Response res=given().contentType(ContentType.JSON)
				.when().get("https://reqres.in/api/users?page=2");
		JSONObject jo=new JSONObject(res.asString());
		String name=jo.getJSONArray("data").getJSONObject(3).get("first_name").toString();
		System.out.println("name :: "+name);
				
		//get all first name
		for(int i=0;i<jo.getJSONArray("data").length();i++)
		{
			String name1=jo.getJSONArray("data").getJSONObject(i).get("first_name").toString();
			System.out.println("name : "+name1);
		}
		
	}
	
	
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
