package tests;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.matcher.RestAssuredMatchers.*;

public class TestsExamples {

	
	@Test
	public void checkResponse() {
		baseURI = "https://reqres.in/api";
		given()
		   .get("/users?page=2")
		.then()
		    //.body("data[1].id", equalTo(8));
		.body("data.last_name", hasItems("Funke","Ferguson"));
		
	}
	
	
}
