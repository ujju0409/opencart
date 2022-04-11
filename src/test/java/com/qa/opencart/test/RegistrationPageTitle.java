package com.qa.opencart.test;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.utilities.ExcleUtil;

public class RegistrationPageTitle extends BaseTest {
	
	
	@BeforeClass
	public void registaionSetup() {
		rp=loginpage.clickRegistrationLink();
		
	}	
		@DataProvider
		public Object[][]  getRegDataExcle() {
		Object regdata[][]=	ExcleUtil.getTestData("Sheet1",ExcleUtil.TEST_DATA_SHEET_PATH);
		return regdata;
			
			
		}

	
//	@DataProvider
//	public Object[][] registarionData() {
//		Object[][]data=new Object[][] {
//			                           {"radhe","patel","1234567890","123@gm","yes"},
//			                           {"ridhi","shah","9099224425","@234gm","yes"},
//			                           {"rakesh","zala","9494939392","9099@gmail.com","yes"}
//		};
//		return data;
	//}
	
	public String getRandom() {
		Random random= new Random();
	String email=	"javaselenium"+random.nextInt(1000)+"@gmail.com";
	return email;
	}
	

	@Test(dataProvider = "getRegDataExcle")
	public void RegistartionTest(String fName, String lName, String phone,String pass,String Sub) {
		rp.completeRegistration(fName,lName,getRandom(),phone,pass,Sub);
		String actualmsg=rp.sucessMsg();
		System.out.println(actualmsg);
		//ExcleUtil.setTestData("Sheet1", actualmsg);
		Assert.assertEquals(actualmsg, "Your Account Has Been Created!");
	}
	

}
