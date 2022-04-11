package com.qa.opencart.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.opencart.pages.AccountPage;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.ProductPage;
import com.qa.opencart.pages.RegistrationPage;
import com.qa.opencart.pages.SearchPage;
import com.qa.opercart.factory.DriverFactory;

public class BaseTest {
	
public WebDriver driver;
public DriverFactory dp;
public Properties prop;
public  LoginPage loginpage ;
public  AccountPage accountpage;
public  SearchPage searchpage;
public ProductPage productpage;
public RegistrationPage rp;

	
	@BeforeTest
	public void setup() {
	    dp = new DriverFactory();
        prop=dp.init_prop();
        driver =  dp.init_driver(prop);
        loginpage =  new LoginPage(driver);
        accountpage= new AccountPage(driver);
        searchpage = new SearchPage(driver);
        productpage= new ProductPage(driver);
      
	} 
      @AfterTest
      public void TearDown() {
    	   driver.quit();
    	  
    	  
      }
	
	

}
