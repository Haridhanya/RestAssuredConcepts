package restAssuredLearning;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.testng.annotations.Test;

public class sampleRequest {
	
	
	@Test
	public void getUser()
	{
		given()
		.when().get("https://reqres.in/api/users?page=2")
		.then()
		.statusCode(200).body("page", equalTo(2))
		.log().all();
	}
	
	@Test
	public void CreateUser()
	{
		HashMap data=new HashMap();
		data.put("name", "hari");
		data.put("job", "sdet");
		given().contentType("application/json").body(data)
		.when().post("https://reqres.in/api/users")
		.then()
		.statusCode(201).log().all();
		
	}
	@Test
	public void updateUser()
	{
		HashMap data=new HashMap();
		data.put("name", "haridhanya");
		data.put("job", "sdet");
		given()
		.when().put("https://reqres.in/api/users/396")
		.then()
		.statusCode(200).log().all();
		
	}
	
	@Test
	public void DeleteUser()
	{
		given()
		.when().delete("https://reqres.in/api/users/396")
		.then();
	}
	@Test 
	public void z()
	{
		int id;
		id=when().get("https://reqres.in/api/users/2").getStatusCode();
		System.out.println("status from the api : "+id);
	}


}
