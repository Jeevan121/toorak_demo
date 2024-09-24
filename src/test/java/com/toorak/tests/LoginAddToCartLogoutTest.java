package com.toorak.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.toorak.dataproviders.DataProviderUtils;
import com.toorak.utils.AutoConfigs;
import com.toorak.utils.BaseTest;
import com.toorak.utils.FileUtils;

public class LoginAddToCartLogoutTest extends BaseTest{
	
	@BeforeTest
	public void setUp() {
		launchApplication(AutoConfigs.applicationUrl);
	}
	
	@Test(dataProviderClass = DataProviderUtils.class,dataProvider = "loginAddToCartLogoutTest",enabled=true,alwaysRun=true)
	public void loginAddToCartLogoutTest(String userName,String password,String title) {
	   	//Login into the application
		getLoginPage().loginIntoApplication(userName, password);
		//validate Should Land into the products page
		Reporter.log("The Title of the Product Page ::"+getProductsPage().getProductTitle());
		Assert.assertEquals(getProductsPage().getProductTitle().toString().trim(),title,"not landed in the product page");
		
		//Retrieving the first product name from the product page
		String firstProductName=getProductsPage().getProductNameFirst();
		Reporter.log("the first product name::::"+firstProductName);
		
		//Retrieving the first product price from the product page
		String firstProductPrice=getProductsPage().getProductPriceFirst();
		Reporter.log("the first product price::::"+firstProductPrice);
		
		//writing retrived product name and price  into the text file 
		FileUtils.writeIntoTextFile(AutoConfigs.filePath, firstProductName, firstProductPrice);
		
		//adding into the cart and then navigating into the shopping cart
		getProductsPage().clickAddToCart().clickOnShoppingCartLink();
		
		//Retrieving the Product Name and Price from Text File in the List
		List<String> itemsNamePriceLst=FileUtils.readTextFile(AutoConfigs.filePath);
		
		//Validating added items name and price YourCartPage Against List.
		Assert.assertEquals(getYourCartPage().getYourCartItemName(), itemsNamePriceLst.get(0),"added Item name is not found in the cart page");
		Assert.assertEquals(getYourCartPage().getYourCartItemPrice(), itemsNamePriceLst.get(1),"added Item name is not found in the cart page");
		
		//Opening the Menu and then logging out from the application
		getYourCartPage().openMenu().logout();
	}
	
	@AfterMethod
	public void tearDown() {
		getPage().close();
	}
}
