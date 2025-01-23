package tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.response.Response;
import models.BPI;
import models.Currency;
import models.CurrentPrice;
import services.CurrentPriceService;

public class ApiTest {
	
	private CurrentPriceService priceService;
	
	@BeforeClass
	public void setUp() {
		priceService = new CurrentPriceService();
	}
	
	@Test
	public void currentPriceTestJsonPath() {
		Response response = priceService.getCurrentPrice();
		Map<String, Object> responseMap = response.jsonPath().getMap("");
		Map<String, Object> bpi = (Map<String, Object>) responseMap.get("bpi");
		
		Map<String, Object> currency = (Map<String, Object>) bpi.get("GBP");
		
		Assert.assertTrue(bpi.containsKey("USD"), "USD not present");
		Assert.assertTrue(bpi.containsKey("GBP"), "GBP not present");
		Assert.assertTrue(bpi.containsKey("EUR"), "EUR not present");
		
		Assert.assertEquals(currency.get("description"),"British Pound Sterling");
		
	}
	
	@Test
	public void currentPriceTestUsingPojo() {
		
		String response = priceService.getCurrentPrice().asPrettyString();
		
		ObjectMapper mapper = new ObjectMapper();
		CurrentPrice currentPriceResponse;
		try {
			currentPriceResponse = mapper.readValue(response, CurrentPrice.class);
			BPI bpi = currentPriceResponse.getBpi();
			Currency currency = bpi.getGBP();
			Assert.assertEquals(bpi.getUSD().getCode(), "USD");
			Assert.assertEquals(bpi.getGBP().getCode(), "GBP");
			Assert.assertEquals(bpi.getEUR().getCode(), "EUR");
			Assert.assertEquals(currency.getDescription(), "British Pound Sterling");
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	}

}
