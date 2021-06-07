package PragatiTraining.RestAssuredDemo;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetUser {
	
	@Test
	public void getUser() {
		RestAssured.baseURI = "https://reqres.in/";
		RequestSpecification request = RestAssured.given();
		Response response = request.get("/api/users/2");
		System.out.println(response.asPrettyString());
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test
	public void getUserList() {
		RestAssured.baseURI = "https://reqres.in/";
		RequestSpecification request = RestAssured.given();
		request.queryParam("page", "2");
		Response response = request.get("/api/users");
		JsonPath body = response.jsonPath();
		int totalUSers = body.getList("data").size();
		Assert.assertEquals(totalUSers, 6);
	}

	
	
}
