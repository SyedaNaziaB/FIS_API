package services;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class BaseService {
	
	public static final String BASE_URI = "https://api.coindesk.com/v1/bpi/currentprice.json";
	public RequestSpecification requestSpecification;
	
	public BaseService() {
		this.requestSpecification = RestAssured.given()
				.baseUri(BASE_URI);
	}
	
	

}
