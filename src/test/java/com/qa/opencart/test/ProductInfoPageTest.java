package com.qa.opencart.test;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.utilities.ExcleUtil;

public class ProductInfoPageTest extends BaseTest {
	
	@BeforeClass
	public void  productpageSetup() {
		loginpage.dologin(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@DataProvider
	public Object[][]  getHeaderDataExcle() {
      Object[][] productdata= ExcleUtil.getTestData("productinfo",ExcleUtil.PRODUCT_DATA_PATH);
   return productdata;
		
	}
	
	
//	@DataProvider
//	public Object[][] headerProduct() {
//		Object[][]header=new Object[][] {
//			                             {"macbook","MacBook Pro","MacBook Pro"},
//			                             {"iphone","iPhone","iPhone"},
//			                             {"MacBook","MacBook Air","MacBook Air"}
//		};
//		return header;
//	}

	
	@Test(dataProvider = "getHeaderDataExcle")
	public void productinfoHaderTest(String productName,String SelectProduct,String Productheader) 
	{
		searchpage=accountpage.doSearch(productName);
	    productpage =searchpage.selectproduct(SelectProduct);
		String actualhedaer= productpage.getHeader();
		System.out.println(actualhedaer);
		Assert.assertEquals(actualhedaer, Productheader);
		
	}
	@DataProvider
	public Object[][] getProductDataExcle() {
	Object[][] data=	 ExcleUtil.getTestData("imgcount", ExcleUtil.IMAGECOUNT_DATA_PATH);
	return data;
		 
	}
	
//	@DataProvider
//	public Object[][] imageCountData() {
//		Object[][] data= new Object[][] {
//			                            {"MacBook","MacBook Air",4},
//			                            {"iphone","iPhone",6}
//			                            };
//		return data ;	                             
//	}
//	
	
	   @Test (dataProvider = "getProductDataExcle")        
		public void imageCountTest(String productName , String selectProduct, String imgCount) 
		 {
		searchpage	= accountpage.doSearch(productName);
		productpage  = searchpage.selectproduct(selectProduct);
		int actualimagcount=productpage.imagecount();
		System.out.println(actualimagcount);
	    int img=(int)Double.parseDouble(imgCount);
		Assert.assertEquals(actualimagcount,img);
			 
		}
	   
//	   @Test
//	   public void productInfoTest() {
//		   searchpage=accountpage.doSearch("MacBook");
//		   productpage=searchpage.selectproduct("MacBook Pro");
//		Map<String,String> actualinfo= productpage.getInfoofProduct();
//		//System.out.println(actualinfo);
//		actualinfo.forEach((k,v) -> System.out.println(k+":"+v));
//	   }
//	   
//	   @Test
//	   public void getMetaTest() {
//	   searchpage=accountpage.doSearch("MacBook");
//	   productpage=searchpage.selectproduct("MacBook Pro");
//	Map<String,String> actualdata=  productpage.getMetaData();
//	System.out.println(actualdata);
//	   }

	  @DataProvider
	   public Object[][] addCartData() {
		   Object[][]data1= new Object[][] {
			   {"MacBook","MacBook Air","1"},
			   {"iphone","iPhone","2"},
			   {"apple","Apple Cinema 30\"","1"}
			   };
			   return data1;
	   }
	   
	   
	   //(dataProvider = "imageCountData") 
	   @Test(dataProvider = "addCartData")
	   public void addtocart(String Productname,String selectProduct,String Qtn) {
		   searchpage	= accountpage.doSearch(Productname);
			productpage  = searchpage.selectproduct(selectProduct);
			productpage.getQantity(Qtn);
		String actualmsg=	productpage.addTocart();
		System.out.println(actualmsg);
			
			
	   }
	   
	   
	  
		
	
}
