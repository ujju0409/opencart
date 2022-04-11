package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountPage {
	
	
	private WebDriver driver ;
	
	// private By locator 
	
	 private By  search = By.name("search");
	 private By Serchbtn = By.cssSelector("div#search button");
	 private By  header = By.cssSelector("div#logo a");
	 private By Accele=By.cssSelector("div#content h2");
	 
	 
	 public AccountPage(WebDriver driver) {
			this.driver = driver;
		}
	  
	//3 Create public page action 
	 public String getAccountpageTitle () {
		return driver.getTitle();
		 
	 }
	 
	 public boolean headerIsDisplay() {
		return  driver.findElement(header).isDisplayed();
	 }
	
	public boolean  SerchbarDisplay() {
		return driver.findElement(search).isDisplayed();
		
	}
	
	public SearchPage doSearch(String productName) {
		WebElement serch=driver.findElement(search);
		serch.clear();
		serch.sendKeys(productName);
		driver.findElement(Serchbtn).click();
		return  new SearchPage(driver);
		
		
	}
	
	public List<String> accountPageList() {
		List<WebElement> list= driver.findElements(Accele);
		List<String>accSecvalList= new ArrayList<String> ();
		for(WebElement e:list) {
			String Text= e.getText();
			accSecvalList.add(Text);
			
		}
		return accSecvalList;
		
	}
	

}
