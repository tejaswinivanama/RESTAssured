package tests;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;
import org.json.simple.JSONObject;

public class PutPatchDelete {

	@Test
	public void testPut() {
		baseURI ="https://reqres.in/api";
		
		JSONObject request = new JSONObject();
		request.put("name", "teju1");
		request.put("job", "software");
		
		given()
		.body(request.toJSONString())
		.when()
		.put("/users")
		.then()
		.statusCode(200);
		
	}
	
	@Test
	public void testPatch() {
		baseURI ="https://reqres.in/api";
		
		JSONObject request = new JSONObject();
		request.put("name", "teju1");
		request.put("job", "software");
		
		given()
		.body(request.toJSONString())
		.when()
		.patch("/users")
		.then()
		.statusCode(200)
		.log().all();
	}
	
	
	@Test
	public void testDelete() {
		baseURI ="https://reqres.in/api";
		
		given().
		when()
		.delete("/users")
		.then()
		.statusCode(204)
		.log().all();	}
}
