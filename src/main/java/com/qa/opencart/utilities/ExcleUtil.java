package com.qa.opencart.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcleUtil {

	 public   static String TEST_DATA_SHEET_PATH="./Resource/TestData/DemoCartData.xlsx";
	 public  static String SET_DATA_PATH="./Resource/TestData/SetCellData.xlsx";
	 public static String  PRODUCT_DATA_PATH= "./Resource/TestData/ProductData.xlsx";
	 public  static String IMAGECOUNT_DATA_PATH="./Resource/TestData/ImageCountData.xlsx";
	private static  Workbook book;
	private static Sheet sheet;
	private static Row row;
	private static Cell cell;
	
	public static Object[][] getTestData(String sheetName ,String path) {
		Object data[][]=null;
		try {
			FileInputStream ip = new FileInputStream(path);
			 try {
				book=WorkbookFactory.create(ip);
			} catch (InvalidFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 sheet= book.getSheet(sheetName);
			 data= new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
			 
			 for(int i = 0; i<sheet.getLastRowNum();i++) {
				 for (int j=0;j<sheet.getRow(0).getLastCellNum();j++) {
					 data[i][j]=sheet.getRow(i+1).getCell(j).toString();
				 }
			 }
			
			 
			 
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (EncryptedDocumentException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return data;
	}
	
//	public  static void  setTestData(String sheetName, String setValue) {
//		
//		try {
//			FileInputStream ip = new FileInputStream(SET_DATA_PATH);
//			 book=WorkbookFactory.create(ip);
//			 sheet= book.getSheet(sheetName);
//			 sheet.getRow(0);
//			 cell= row.createCell(1);
//			 cell.setCellValue(setValue);
//			 FileOutputStream fo = new FileOutputStream(SET_DATA_PATH);
//			 book.write(fo);
//			 book.close();
//			 fo.close();
//			 ip.close();
//			 
//			 
//			 
//			 
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (EncryptedDocumentException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}
	
	
}
