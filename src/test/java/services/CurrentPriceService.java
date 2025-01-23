package services;

import io.restassured.response.Response;

public class CurrentPriceService extends BaseService {

	public Response getCurrentPrice() {
		return requestSpecification.get().then().extract().response();
	}
}
