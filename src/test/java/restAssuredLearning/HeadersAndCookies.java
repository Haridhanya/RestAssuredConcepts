package restAssuredLearning;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.http.Header;
public class HeadersAndCookies {

	@Test
	void Cookies()
	{
		Response res=given()
				.when().get("https://reqres.in/api/users?page=2");
		Map<String,String> Cookie=res.getCookies();
		for(String k:Cookie.keySet())
		{
			System.out.println(res.getCookie(k));
		}
		
		
	}
	
	
	//APRAOCH 1:verifying header using then() method
	//@Test
	void Header()
	{
		given()
		.when().get("https://reqres.in/api/users?page=2")
		.then().header("Server", "cloudflare")
		.log().headers();
		
		
	}
	@Test
	void getheader()
	{
		
		
		//GET SINGLE HEADER DETAILS
		Response res=given().when().get("https://reqres.in/api/users?page=2");
		String Header=res.getHeader("Content-Type");
        System.out.println(Header);
		
        //get all header info,actually we can get it through log all
        
        //but here is another approach
        
        
        Headers head=res.getHeaders();
        for(Header hd:head)
        {
        	System.out.println("name : "+hd.getName()); 
        	System.out.println("value : "+hd.getValue()); 
        }
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
