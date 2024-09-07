package ApiChaining;


import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.restassured.response.ValidatableResponse;


public class getUser {

	
	@Test
	void getUser1(ITestContext context)
	{
		String bearerToken="6720d9eda218b5d9736dc243a6621464ca8dfdb71849e091b7b72dc9945d432c";
		int id=(Integer)context.getSuite().getAttribute("user_id");
		given()
		.pathParam("id", id)
		.header("Authorization","Bearer "+bearerToken)
		.when().get("https://gorest.co.in/public/v2/users/{id}")
		.then().log().all();
	}
	
}
