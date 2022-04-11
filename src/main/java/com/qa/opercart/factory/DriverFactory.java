package com.qa.opercart.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	public WebDriver driver;
	public Properties prop;
	public OptionManager op;
	public static ThreadLocal<WebDriver> tlDriver=new ThreadLocal<WebDriver>();
	
	
	
	
	
	public WebDriver init_driver(Properties prop)
	{
		 String browserName=prop.getProperty("browser").trim();
		 op = new OptionManager(prop);
		 
		
		if(browserName.equalsIgnoreCase("chrome")) 
		{
			WebDriverManager.chromedriver().setup();
			//driver= new ChromeDriver(op.getChromeOption());
			tlDriver.set(new ChromeDriver(op.getChromeOption()));
			
		}
		else if(browserName.equalsIgnoreCase("firfox"))
		{
			WebDriverManager.firefoxdriver().setup();
			 driver= new FirefoxDriver();
			 //tlDriver.set(new FirefoxDriver(optionsManager.getFirefoxOptions()));

		}
		else if(browserName.equalsIgnoreCase("safari")) 
		{
			driver= new SafariDriver();
			
		}
		else 
		{
		System.out.println("please  enetr valid  browser name ");
		}
		
		getDriver().get(prop.getProperty("url").trim());
		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
		
		return getDriver();
	}
	
	public static WebDriver  getDriver() {
		   return  tlDriver.get();
	   }
	   
	
	
	
	
   public Properties init_prop() {
	   
	   prop= new Properties();
	   FileInputStream ip = null;
	   
	 String envName=  System.getProperty("env");
	 System.out.println(envName);
	   if(envName==null) {
		   System.out.println("no env given.......hence runing in qa env");
		   try {
			ip = new FileInputStream("./Resource/cofig/qa.cofig.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   }
	   
	   else {
		   try {
		   switch (envName.toLowerCase()) {
		case"qa":
			ip = new FileInputStream("./Resource/cofig/qa.cofig.properties");
			
			break;
		case"dev":
		   ip = new FileInputStream("./Resource/cofig/dev.config.properties");
			
			break;
		case"pro":
			ip = new FileInputStream("./Resource/cofig/pro.config.properties");
			
			break;
		default:
			System.out.println("plese pass the right browser");
			break;
		}
	   }catch (Exception e) {
		
	}
		   } 
		   
	  
		try {
			prop.load(ip);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	 
	   
	 return prop;  
	 
	   
   }
   
   
   
   public static String  getScreenshot() {
	   File srcFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
	  String path= System.getProperty("user.dir")+"/screenshot/"+System.currentTimeMillis()+".png";
	  File destination= new File(path);
	   try {
		FileUtils.copyFile(srcFile, destination);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 return path;
	   
   }
   

}




