package PragatiTraining.RestAssuredDemo;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SimplePostRequest {

	@Test
	public void RegistrationSuccessful()
	{ 
	 RestAssured.baseURI ="https://demoqa.com/utilities/customer";
	 RequestSpecification request = RestAssured.given();
	 
	 JSONObject requestParams = new JSONObject();
	 requestParams.put("FirstName", "Virender"); // Cast
	 requestParams.put("LastName", "Singh");
	 requestParams.put("UserName", "sdimpleuser2dd2011");
	 requestParams.put("Password", "password1");
	 
	 requestParams.put("Email",  "sample2ee26d9@gmail.com");
	 request.body(requestParams.toJSONString());
	 Response response = request.post("/register");
	 
	 int statusCode = response.getStatusCode();
	 Assert.assertEquals(statusCode, 201);
	 
	 //Assert.assertEquals(statusCode, "201");
	 String successCode = response.jsonPath().get("SuccessCode");
	 Assert.assertEquals( "Correct Success code was returned", successCode, "OPERATION_SUCCESS");
	

	} 
}
