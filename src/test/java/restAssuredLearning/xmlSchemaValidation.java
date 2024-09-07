package restAssuredLearning;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.matcher.RestAssuredMatchers;
import io.restassured.response.ValidatableResponse;


public class xmlSchemaValidation {
	
	
	@Test
	void xmlSchemaValidation()
	{
		given()
		.when().get("https://thetestrequest.com/authors.xml")
		.then().assertThat()
		.body(RestAssuredMatchers.matchesXsdInClasspath("xmlSchema.xsd"));
	}
	
	

}




