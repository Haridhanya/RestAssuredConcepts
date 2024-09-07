package ApiChaining;


import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.restassured.response.ValidatableResponse;
public class deleteUser {
	
	
	@Test
	void deleteUser1(ITestContext context)
	{

		String bearerToken="6720d9eda218b5d9736dc243a6621464ca8dfdb71849e091b7b72dc9945d432c";
		int id=(int) context.getSuite().getAttribute("user_id");
		
		given().header("Authorization","Bearer "+bearerToken).pathParam("id", id)
		.when().delete("https://gorest.co.in/public/v2/users/{id}")
		.then()
		.log().all();
		
		
	}
	

}
