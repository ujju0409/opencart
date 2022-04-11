package com.qa.opencart.test;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.utilities.Constants;



public class AccountPageTest  extends BaseTest{
	
	
	@BeforeClass
	public void accPageLogin() {
		accountpage=loginpage.dologin(prop.getProperty("username"), prop.getProperty("password"));
		
		
	}
	
	@Test
	public void accPageTitleTest() {
	String actualtitle=	accountpage.getAccountpageTitle();
	System.out.println(actualtitle);
    Assert.assertEquals(actualtitle,Constants.ACCOUNT_PAGE_TITLE);
    
	}
	@Test
	public void headerIsExit() {
		Assert.assertTrue(accountpage.headerIsDisplay());
	} 
	@Test
	public void serchbarTest() {
		Assert.assertTrue(accountpage.SerchbarDisplay());
	}
	@Test
     public void accSectionTest() {
	List<String> actuallist=	accountpage.accountPageList();
	System.out.println(actuallist);
	Assert.assertEquals(actuallist,Constants.ACCOUNT_SECTION_LIST);
	}
}
