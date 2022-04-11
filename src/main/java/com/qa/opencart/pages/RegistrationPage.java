package com.qa.opencart.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.opencart.utilities.Constants;
import com.qa.opencart.utilities.JavaScriptUtil;

public class RegistrationPage {
	
	
	
	private WebDriver driver;
	private JavaScriptUtil js;
  // 1 private By locator 
	
	 private By ftname = By.id("input-firstname");
	 private By ltname = By.id("input-lastname");
	 private By emailid= By.id("input-email");
	private By telephonenumber= By.id("input-telephone");
	private By psw= By.id("input-password");
	private By confirmpsw=By.id("input-confirm");
	private By scbYes= By.xpath("//label[@class='radio-inline']//input[@type='radio' and @value='1']");
	private By scbNo = By.xpath("(//input[@type='radio'])[3]");
	private By chkd=By.name("agree");
	private By conBtn=By.xpath("//input[@type='submit']");
	private By msg= By.cssSelector("#content h1");
	private By logLink= By.linkText("Logout");
	private By regLink= By.linkText("Register");
	
	
	
	
	public RegistrationPage(WebDriver driver) {
		super();
		this.driver = driver;
        js = new JavaScriptUtil(driver);
		
	}
	

	public void completeRegistration(String firstName, String LastName, String EmailId, String Telephone, String password,
			                          String Subscribe ) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.DEFAULT_TIMEOUT));
		  wait.until(ExpectedConditions.visibilityOfElementLocated(ftname)).sendKeys(firstName);
		
		//driver.findElement(ftname).sendKeys(firstName);
		WebElement lt=driver.findElement(ltname);
		js.flash(lt);
		lt.sendKeys(LastName);
		
		driver.findElement(emailid).sendKeys(EmailId);
		driver.findElement(telephonenumber).sendKeys(Telephone);
		driver.findElement(psw).sendKeys(password);
		driver.findElement(confirmpsw).sendKeys(password);
		driver.findElement(chkd).click();
		driver.findElement(conBtn).click();
//		js.flash(ele);
//		ele.click();
		
		
//		  if (Subscribe.equalsIgnoreCase("yes")) {
//			 wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.DEFAULT_TIMEOUT));
//				  wait.until(ExpectedConditions.visibilityOfElementLocated(scbYes)).click();;
//			  //driver.findElement(scbYes).click();
//			  
//		  }else {
//			  driver.findElement(scbNo).click();
//		  }
		
		
	}
	
	 public String  sucessMsg() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.DEFAULT_TIMEOUT));
		 String text= wait.until(ExpectedConditions.visibilityOfElementLocated(msg)).getText();
		 driver.findElement(logLink).click();
			driver.findElement(regLink).click();
			return text;
	 }
	
}
