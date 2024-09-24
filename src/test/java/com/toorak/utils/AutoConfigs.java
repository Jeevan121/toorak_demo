package com.toorak.utils;

public class AutoConfigs {
	
	public static String applicationUrl = PropertiesUtils.initEnvironmentProperties().getProperty("environmentUrl");
	public static String apiEndPoint = PropertiesUtils.initEnvironmentProperties().getProperty("api_end_point");
	public static String browserType = PropertiesUtils.initAutomatioProperties().getProperty("BrowserType");
	
	public static String userList="/users?page=2";
	public static String filePath = "example.txt";
	
}
