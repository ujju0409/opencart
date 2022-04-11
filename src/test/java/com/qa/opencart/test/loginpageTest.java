package com.qa.opencart.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.utilities.Constants;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class loginpageTest extends BaseTest {
	
	@Description("login page  title test ")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void  loginPageTitleTest() {
		String  actualtitle=loginpage.gettitle();
		System.out.println("LoginPage title----"+actualtitle);
		Assert.assertEquals(actualtitle, Constants.LOGIN_PAGE_TITLE);
	}
	@Description("login page  url test ")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void  loginPageUrlTest() {
	String actualurl=	loginpage.geturl();
	System.out.println("LoginPage Url ------"+actualurl);
	Assert.assertTrue(actualurl.contains(Constants.LOGIN_PAGE_FRACTION_URL));
	}
	
	@Test@Description("login page  forogot password link  test ")
	@Severity(SeverityLevel.CRITICAL)
	public void  forgotpswTest() {
		Assert.assertTrue(loginpage.forgotpassword());
		
	}

	@Test
	public void loginTest() {
		loginpage.dologin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
}
