package com.toorak.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class YourCartPage {
		
	 Page page;
	 private final Locator yourCartItemName;
	 private final Locator yourCartItemPrice;
	 private final Locator openMenu;
	 private final Locator logoutLnk;
	
	
	 public YourCartPage(Page page) {
		 this.page=page;
		 this.yourCartItemName=page.locator("//div[@class='inventory_item_name']");
		 this.yourCartItemPrice=page.locator("//div[@class='inventory_item_price']");
		 this.openMenu=page.locator("//button[text()='Open Menu']");
		 this.logoutLnk=page.locator("//a[text()='Logout']");
	 }
	 
	 public String getYourCartItemName() {
			String title=yourCartItemName.textContent();
			return title;
	 }
		
	 public String getYourCartItemPrice() {
			String title=yourCartItemPrice.textContent();
			return title;
	 }
	 
	 public YourCartPage  openMenu() {
			openMenu.click();
			return this;
	 }
	 
	 public YourCartPage  logout() {
		 logoutLnk.click();
		 return this;
	 }

}
