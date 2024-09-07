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

public class PathAndQueryParam {

	//url: "https://reqres.in/api/users?page=2"
	
	@Test
	void PathAndQueryParam_Leraning()
	{
		
		given().pathParam("path", "users")
		.queryParam("page", 2)
		.when()
		.get("https://reqres.in/api/{path}")
		.then().log().all();
		
		
		
	}
	
	
}
