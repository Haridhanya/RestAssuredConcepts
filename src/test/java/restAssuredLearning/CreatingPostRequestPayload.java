package restAssuredLearning;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
//import java.io.File;
import java.util.HashMap;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.http.Headers;

import io.restassured.response.Response;
import pojoClass.poJoClass;
import io.restassured.http.Header;

public class CreatingPostRequestPayload {

	//1.using Hashmap
	//2.using org.json
	//3.using POJO Class
	//4.using External json file
	//@Test
	void PayloadHashMap()
			{
		HashMap<String,String> data= new HashMap();
		data.put("name", "jam");
		data.put("job", "makes bread tastier");
		given().body(data)
		.when().post("https://reqres.in/api/users")
		.then()
		.statusCode(201).log().all();
		
			}
	//@Test void OrgJson()
	{
		JSONObject jo=new JSONObject();
		jo.put("name", "butter");
		jo.put("job", "makes bread even worst");
		given().body(jo.toString())
		.when().post("https://reqres.in/api/users")
		.then().statusCode(201).log().all();
	}

	
	//@Test
	void POJOClass()
	{
		poJoClass ob=new poJoClass();
		ob.setJob("make you sweet");
		ob.setName("sugar");
		given().body(ob)
		.when().post("https://reqres.in/api/users").then().statusCode(201)
		.log().all();
	}
	
	@Test
	void ExternalJson() throws FileNotFoundException
	{
		File f=new File(".\\student.json");
		FileReader fr=new FileReader(f);
		JSONTokener jt=new JSONTokener(fr);
		JSONObject ob=new JSONObject(jt);
		given().body(ob.toString())
		.when().post("https://reqres.in/api/users").then().statusCode(201)
		.log().all();
		
		
		
	}
}
