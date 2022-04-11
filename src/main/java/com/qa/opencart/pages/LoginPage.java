package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.qameta.allure.Step;

public class LoginPage {
	// private by locator 
	private WebDriver driver;
	
	private By emilid = By.id("input-email");
    private By psw= By.id("input-password");
	private By lognbtn= By.xpath("//input[@type='submit']");
	private By fplink=By.linkText("Forgotten Password");
	private By regLink= By.linkText("Register");
	
	
	// 2. Create the constructor
	
     public LoginPage(WebDriver driver) {
		
		this.driver = driver;
	}

	
    // 3 page action on public layer  
	
        @Step("login to application with username{0} and password{1}")
     public AccountPage dologin(String username,String password) {
    	 driver.findElement(emilid).sendKeys(username);
    	 driver.findElement(psw).sendKeys(password);
    	 driver.findElement(lognbtn).click();
    	 return new AccountPage(driver);
     }
     
     public boolean  forgotpassword()
     {
    	return  driver.findElement(fplink).isDisplayed();
    
     }
     
     public String geturl() {
    	 return driver.getCurrentUrl();
    	 
     }
     
     public String  gettitle() {
    	 return driver.getTitle();
    	 
     }
     
     public RegistrationPage  clickRegistrationLink() {
    	 driver.findElement(regLink).click();
    	 return  new RegistrationPage(driver);
    	 
    	 
     }
     
     
     
}
