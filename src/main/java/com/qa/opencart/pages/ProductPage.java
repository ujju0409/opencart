package com.qa.opencart.pages;

import java.time.Duration;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.opencart.utilities.ElementUtil;

public class ProductPage {

	//1 private licator
	
	private WebDriver driver;
	private ElementUtil eleutil;
	
	
	private By Header = By.cssSelector("#content h1");
	private By imagecount=By.xpath("//a[@class='thumbnail']//img");
	private By qty= By.id("input-quantity");
	private By addtocart= By.id("button-cart");
	private By metaData=By.xpath("(//ul[@class='list-unstyled'])[7]/li");
	private By pricedata= By.xpath("(//ul[@class='list-unstyled'])[8]/li");
	private By message = By.cssSelector(".alert.alert-success.alert-dismissible");
	
	private Map<String,String>productinfo;
	
	public ProductPage(WebDriver driver) {
		
		this.driver = driver;
	}
	
	
	public  int  imagecount () {
	return 	driver.findElements(imagecount).size();
	}
	
	public String getHeader() {
		return driver.findElement(Header).getText();
		
	}
	
	public void  getQantity(String qantity) {
		WebElement quantity=driver.findElement(qty);
		quantity.clear();
		quantity.sendKeys(qantity);
	}
    	
	
	public String addTocart() {
		driver.findElement(addtocart).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));// sel 4.x
		return wait.until(ExpectedConditions.visibilityOfElementLocated(message)).getText();
		
		
	}
	
	
	
	public Map<String, String> getInfoofProduct() {
		 productinfo= new LinkedHashMap<String,String>();
		 productinfo.put("productname", getHeader());
		 productinfo.put("number of qantity", String.valueOf(imagecount()));
		 getMetaData();
		 getprodcutPrice();
		 return productinfo;
		
	}
	
	   public  Map<String, String> getMetaData() {
//		Brand: Apple
//		Product Code: Product 18
//		Reward Points: 800
//		Availability: Out Of Stock
		
		 List<WebElement>  metadatalist=driver.findElements(metaData);
		    for(WebElement e:metadatalist)
		    {
			String text= e.getText().trim();
			String meta[]=text.split(":");
			String mataKey=meta[0].trim();
			String Matavalue=meta[1].trim();
			productinfo.put(mataKey, Matavalue);
			
		    }return productinfo;
		    }
			
		 private void getprodcutPrice() {
			 
//			 $2,000.00
//			 Ex Tax: $2,000.00
			List<WebElement> productprice= driver.findElements(pricedata);
			
			String price =productprice.get(0).getText().trim();
			String Exprice = productprice.get(1).getText().trim();
			
			 productinfo.put("price", price);
		     productinfo.put("Exprice", Exprice);
		     
		 }
			
		
	}
	
	
	
	
	

