package tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class GetPostRequests {

	//@Test
	public void getReq(){
		baseURI="https://reqres.in/api";

		given().get("/users?page=2")
		.then()
		.body("data[1].last_name", equalTo("Ferguson"))
		.body("data[0].last_name", equalTo("Lawson"))
		.body("data.email", hasItems("michael.lawson@reqres.in","lindsay.ferguson@reqres.in"));

	}

	@Test
	public void postReq(){
		baseURI="https://reqres.in/api";

		JSONObject jbody = new JSONObject();
		jbody.put("name", "teju");
		jbody.put("job", "software");

		given()
		.body(jbody.toJSONString())
		.when()
		.post("/users")
		.then()
		.statusCode(201);
	}
}
