package com.toorak.tests;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.microsoft.playwright.APIRequest;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Playwright;
import com.toorak.utils.AutoConfigs;

public class GetAPIDemoTest {
	
	@Test
	public void getAPIDemoTest() {
		
		Playwright playwright = Playwright.create();
		APIRequest request = playwright.request();
		APIRequestContext apiRequestContext = request.newContext();
		
		APIResponse response = apiRequestContext.get(AutoConfigs.apiEndPoint+AutoConfigs.userList);
		int statusCode = response.status();
		Reporter.log("The Status Code"+statusCode);
		Assert.assertEquals(statusCode, 200,"api is not working");
		
	}

}
