package restAssuredLearning;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;



public class ParsingXmlResponse {
//Approach 1:validation in teh then ()
	//2storing in Response variable
	//3.xml path class
	
	
	//@Test 
	void xmlparsing()
	{
		
		given()
		.when().get("https://thetestrequest.com/authors.xml")
		.then()
		.body("objects.object.name[1]", equalTo("Jeffie Wolf I"));
		

	}
	
	//test with xmlpath()method
	//@Test
	void response()
	{
		

		Response Res=given()
		.when().get("https://thetestrequest.com/authors.xml");
		Assert.assertEquals(Res.getStatusCode(), 200);
		String names=Res.xmlPath().get("objects.object.name");
		System.out.println(names);
		

		
	}
	
	@Test
	void xmlpath()
	{
		Response Res=given()
				.when().get("https://thetestrequest.com/authors.xml");
		XmlPath xp=new XmlPath(Res.asString());
		List<String> names=xp.getList("objects.object.name");
		for(String name:names)
		{
		System.out.println(name);
		
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
