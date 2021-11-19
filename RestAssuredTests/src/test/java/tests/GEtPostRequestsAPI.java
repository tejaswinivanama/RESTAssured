package tests;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;
import org.json.simple.JSONObject;

public class GEtPostRequestsAPI {

	@Test
	public void getReq() {
		baseURI = "http://localhost:3000";
		
		given()
		.get("/users")
		.then()
		.statusCode(200).log().all();
		//.body("users[1].firstname", equalTo("Teja")).log().all();
		//.body("data[1].subjectId", equalTo(1));
		
	}
	
	@Test
	public void postReq() {
		baseURI = "http://localhost:3000";
		JSONObject request = new JSONObject();
		request.put("firstname", "T");
		request.put("lastname", "J");
		request.put("subjectId", 1);
		
		
		
	given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(request.toJSONString())
	.when()
		.post("/users")
	.then()
		.statusCode(201).log().all();
		
	}	
	@Test
	public void putReq() {
		
		baseURI = "http://localhost:3000";
		JSONObject request = new JSONObject();
		request.put("firstname", "V");
		request.put("lastname", "G");
		request.put("subjectId", 1);
		
		
		
	given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(request.toJSONString())
	.when()
		.put("/users/2")
	.then()
		.statusCode(200).log().all();
		
	}	
	
	
	@Test
	public void patchReq() {
		
		baseURI = "http://localhost:3000";
		JSONObject request = new JSONObject();
		request.put("firstname", "Var");
		
		
		
	given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(request.toJSONString())
	.when()
		.patch("/users/2")
	.then()
		.statusCode(200).log().all();
		
	}	
	
	@Test
	public void deleteReq() {
		
		baseURI = "http://localhost:3000";
		given()		
		.when()
		.delete("users/2")
		.then()
		.statusCode(200).log().all();
		
	}	
}
