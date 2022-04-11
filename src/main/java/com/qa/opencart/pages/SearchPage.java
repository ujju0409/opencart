package com.qa.opencart.pages;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage {
	
	//1 private By locator 
	
	private WebDriver driver;
	
	
	
	
	private By searchheader= By.cssSelector("div#content h1");
	private By productele= By.xpath("//div[@class='caption']//a");
	
	
	public SearchPage(WebDriver driver) {
		
		this.driver = driver;
	}
	
	
	
	
	public boolean searchHeaderDisplay() {
		return driver.findElement(searchheader).isDisplayed();
		
	}
	
	public int getProductCount() {
		List<WebElement> countlist=driver.findElements(productele);
		return countlist.size();
		
	}
	
	public List<String> getProductlist() {
		List<WebElement> countlist=driver.findElements(productele);	
		List<String>productlist=new ArrayList<String>();
		for(WebElement e:countlist) {
		String text= e.getText();
		productlist.add(text);
		}
		return productlist;
	}
	
	
	public ProductPage selectproduct(String productname) {
		List<WebElement> countlist=driver.findElements(productele);	
		for(WebElement e:countlist) {
			String text= e.getText();
			if(text.equals(productname)){
				e.click();
				break;
			}
		} return new ProductPage(driver);
		
	}
	
}

