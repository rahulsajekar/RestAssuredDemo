package PragatiTraining.RestAssuredDemo;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateUser {

	@Test
	public void createUser() {
		RestAssured.baseURI = "https://reqres.in/";
		RequestSpecification request = RestAssured.given();
		
		JSONObject body = new JSONObject();
		body.put("name", "morpheus");
		body.put("job", "leader");
		
		request.body(body.toJSONString());
		
		Response response = request.post("/api/users");
		Assert.assertEquals(response.getStatusCode(),201);
		Assert.assertTrue(response.asString().contains("id"));
	}
	
}
