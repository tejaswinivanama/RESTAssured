package tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;

import io.restassured.http.ContentType;
import static io.restassured.matcher.RestAssuredMatchers.matchesXsdInClasspath;
public class SOAPXmlRequests {
	
	@Test 
	public void postReq() throws IOException{
		baseURI="http://www.dneonline.com/";

		File f = new File("./SOAPXmls/SOAPReq.xml");
		FileInputStream fis=new FileInputStream(f);
		
		String requestBody = IOUtils.toString(fis,"UTF-8");
		

		given().
		contentType("text/xml")
		.accept(ContentType.XML)
		.body(requestBody)
		.when()
		.post("/calculator.asmx")
		.then()
		.statusCode(200).log().all()
		.and()
		.body("//*:AddResult.text()",equalTo("18"))
		.and()
		.assertThat().body(matchesXsdInClasspath("calculator.xsd"));
	}
}
