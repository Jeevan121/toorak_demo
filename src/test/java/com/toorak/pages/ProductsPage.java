package com.toorak.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class ProductsPage {
	Page page;
	 private final Locator productsTitle;
	 private final Locator productNameFirst;
	 private final Locator productPriceFirst;
	 private final Locator addToCartFirst;
	 private final Locator shoppingCartLnk;
	
	
	public ProductsPage(Page page) {
	    this.page = page;
	    this.productsTitle = page.locator("//span[@class='title']");
	    this.productNameFirst = page.locator("(//div[@class='inventory_item_name '])[position()=1]");
	    this.productPriceFirst= page.locator("(//div[@class='inventory_item_price'])[position()=1]");
	    this.addToCartFirst= page.locator("(//button[text()='Add to cart'])[position()=1]");
	    this.shoppingCartLnk= page.locator("//a[@class='shopping_cart_link']");
	   
	  }
	
	public String getProductTitle() {
		String title=productsTitle.textContent();
		return title;
	}
	
	public String getProductNameFirst() {
		String title=productNameFirst.textContent();
		return title;
	}
	
	public String getProductPriceFirst() {
		String title=productPriceFirst.textContent();
		return title;
	}
	
	public ProductsPage clickAddToCart() {
		addToCartFirst.click();
		return this;
	}
	
	
	public ProductsPage clickOnShoppingCartLink() {
		shoppingCartLnk.click();
		return this;
	}
	

}
