package ApiChaining;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.restassured.response.ValidatableResponse;

public class updateUser {

	

	@Test
	void updateUser1(ITestContext context) {
		
		JSONObject data=new JSONObject();
		Faker fr=new Faker();
		data.put("name",fr.name().firstName());
		data.put("email",fr.internet().emailAddress());
		data.put("gender","Female");
		data.put("status","Inactive");
		
		String bearerToken="6720d9eda218b5d9736dc243a6621464ca8dfdb71849e091b7b72dc9945d432c";
		int id=(Integer) context.getSuite().getAttribute("user_id");
		given().contentType("application/json").body(data.toString())
		.header("Authorization","Bearer "+bearerToken)
		.pathParam("id", id)
		.when().put("https://gorest.co.in/public/v2/users/{id}")
		.then().log().all();
		System.out.println(id);
		
	}
	
}
