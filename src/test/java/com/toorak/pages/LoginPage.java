package com.toorak.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class LoginPage {
	
	@SuppressWarnings("unused")
	private final Page page;
	
	@SuppressWarnings("unused")
	private final Locator signInLnk;
	
	private final Locator userNameTxt;
	private final Locator passwordTxt;
	private final Locator loginBtn;
	
	public LoginPage(Page page) {
	    this.page = page;
	    this.signInLnk = page.locator("//button[contains(text(),'Sign in')]");
	    this.userNameTxt=page.locator("//input[@id='user-name']");
	    this.passwordTxt=page.locator("//input[@id='password']");
	    this.loginBtn=page.locator("//input[@id='login-button']");
	  }
	
	public void loginIntoApplication(String userName,String password) {
		userNameTxt.fill(userName);
		passwordTxt.fill(password);
		loginBtn.click();
	}

}
