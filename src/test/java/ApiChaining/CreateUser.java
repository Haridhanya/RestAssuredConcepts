package ApiChaining;


import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.restassured.response.ValidatableResponse;

public class CreateUser {

	
	//Access Token :6720d9eda218b5d9736dc243a6621464ca8dfdb71849e091b7b72dc9945d432c
	//we are going to create a new record and new id will be created .using that id we are going to chain other request from 
	//differnt classes.
	
	@Test
	void CreateUser(ITestContext context) {
		
		JSONObject data=new JSONObject();
		Faker fr=new Faker();
		data.put("name",fr.name().firstName());
		data.put("email",fr.internet().emailAddress());
		data.put("gender","Female");
		data.put("status","active");
		
		String bearerToken="6720d9eda218b5d9736dc243a6621464ca8dfdb71849e091b7b72dc9945d432c";
		
		int id=given().contentType("application/json").body(data.toString())
	     .header("Authorization","Bearer "+bearerToken)
		.when().post("https://gorest.co.in/public/v2/users").jsonPath().getInt("id");
		System.out.println(id);
		context.getSuite().setAttribute("user_id", id);
		
	}
}
