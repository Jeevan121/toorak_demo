package com.toorak.dataproviders;

import java.io.File;

import org.testng.annotations.DataProvider;

import com.toorak.utils.ExcelUtils;


public class DataProviderUtils {

	  @DataProvider(name="loginAddToCartLogoutTest")
	  public static Object[][] loginAddToCartLogoutTest(){
		  final Object[][] objReturn = ExcelUtils.getTableArray(
			        System.getProperty("user.dir") +File.separator+"testdata"+File.separator+"Automation_Test_Input_Data.xls", "demo", "loginAddToCartLogoutTest");
			    return objReturn;

	  }
	  
	  @DataProvider(name="addToCartTestV3")
	  public static Object[][] addToCartTestV3(){
		  final Object[][] objReturn = ExcelUtils.getTableArray(
			        System.getProperty("user.dir") +File.separator+"testdata"+File.separator+"Automation_Test_Input_Data.xls", "demo", "addToCartTestV3");
			    return objReturn;

	  }
	
}
