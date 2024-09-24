package com.toorak.utils;

import java.util.List;

import org.testng.Assert;
import org.testng.Reporter;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.toorak.pages.LoginPage;
import com.toorak.pages.ProductsPage;
import com.toorak.pages.YourCartPage;

public class BaseTest {
		
	private static ThreadLocal<Playwright> tlPlaywright = new ThreadLocal<>();
	private static ThreadLocal<Browser> tlBrowser = new ThreadLocal<>();
	private static ThreadLocal<Page> tlPage = new ThreadLocal<>();
	private static ThreadLocal<BrowserContext> tlBrowserContext = new ThreadLocal<>();
	
	public static Playwright getPlaywright() {
		return tlPlaywright.get();
	}

	public static Browser getBrowser() {
		return tlBrowser.get();
	}

	public static BrowserContext getBrowserContext() {
		return tlBrowserContext.get();
	}

	public static Page getPage() {
		return tlPage.get();
	}

	public static void launchApplication(String url) {
		try {
			createPlayWrightInstanceIgnoreHttpsErrors(AutoConfigs.browserType);
			getPage().navigate(url.trim());
			Reporter.log("browser launched using "+url);

		} catch (Exception e) {
			Assert.fail("Url is not secured and Hosted on Http");
			Reporter.log("Exception Caught in launching the application::" + e);
		}

	}

	
	public static void createPlayWrightInstanceIgnoreHttpsErrors(String browserType) {
		if (getPlaywright() == null) {
			tlPlaywright.set(Playwright.create());
		}
		switch (browserType.strip().toLowerCase()) {
		case "chromium":
			tlBrowser.set(getPlaywright().chromium()
					.launch(new BrowserType.LaunchOptions().setHeadless(false)
							.setSlowMo(1000).setArgs(List.of("--start-maximized"))));
			break;
		case "chrome":
			tlBrowser.set(getPlaywright().chromium()
					.launch(new BrowserType.LaunchOptions().setChannel("chrome")
							.setHeadless(false).setSlowMo(1000)
							.setArgs(List.of("--start-maximized"))));
			break;
		case "safari":
			tlBrowser.set(getPlaywright().webkit()
					.launch(new BrowserType.LaunchOptions().setHeadless(false)
							.setSlowMo(1000).setArgs(List.of("--start-maximized"))));
			break;
		case "firefox":
			tlBrowser.set(getPlaywright().firefox()
					.launch(new BrowserType.LaunchOptions().setHeadless(false)
							.setSlowMo(1000).setArgs(List.of("--start-maximized"))));
			break;
		case "edge":
			tlBrowser.set(getPlaywright().chromium()
					.launch(new BrowserType.LaunchOptions().setChannel("msedge")
							.setHeadless(false).setSlowMo(1000)
							.setArgs(List.of("--start-maximized"))));
		default:
			System.out.println("pass valid browser name");
			break;
		case "incognito":
			tlBrowser.set(getPlaywright().chromium()
					.launch(new BrowserType.LaunchOptions().setChannel("msedge")
							.setHeadless(false).setSlowMo(1000)
							.setArgs(List.of("--start-maximized"))));
		}
		tlBrowserContext.set(getBrowser()
				.newContext(new Browser.NewContextOptions().setIgnoreHTTPSErrors(false).setViewportSize(null)));

		tlPage.set(getBrowserContext().newPage());

	}
			
	LoginPage loginPage;
	public LoginPage getLoginPage() {
		if(loginPage==null) {
			loginPage = new LoginPage(getPage());
		}
		return loginPage;
	}
	
	ProductsPage productsPage;
	public ProductsPage getProductsPage() {
		if(productsPage==null) {
			productsPage = new ProductsPage(getPage());
		}
		return productsPage;
	}
	
	YourCartPage yourCartPage;
	public YourCartPage getYourCartPage() {
		if(yourCartPage==null) {
			yourCartPage = new YourCartPage(getPage());
		}
		return yourCartPage;
	}

}
