package com.commonTest;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.commonTest.XL_Reader;

public class TestUtil extends TestBase {
	
//	public static boolean isskip(String testcase) {
//
//		for (int rowNum = 2; rowNum <= datatable.getRowCount("Test Cases"); rowNum++) {
//			if (testcase.equals(datatable.getCellData("Test Cases", "TCID", rowNum))) {
//				if (datatable.getCellData("Test Cases", "Runmode", rowNum).equals("Y"))
//					return false;
//				else
//					return true;
//
//			}
//
//		}
//
//		return false;
//	}
//
//	// get the data from xls file
//	public static Object[][] getData(String testName) {
//		// return test data;
//		// read test data from xls
//		if (datatable == null) {
//			// load the suite 1 sheet
//
//			datatable = new XL_Reader(System.getProperty("user.dir") + "//src//Config//ExpectedData.xlsx");
//
//		}
//		int rows = datatable.getRowCount(testName) - 1;
//		if (rows <= 0) {
//			Object[][] testData = new Object[1][0];
//			return testData;
//
//		}
//		rows = datatable.getRowCount(testName); // 3
//		int cols = datatable.getColumnCount(testName);
//		System.out.println("Test Name -- " + testName);
//		System.out.println("total rows -- " + rows);
//		System.out.println("total cols -- " + cols);
//		Object data[][] = new Object[rows - 1][cols];
//
//		for (int rowNum = 2; rowNum <= rows; rowNum++) {
//
//			for (int colNum = 0; colNum < cols; colNum++) {
//				data[rowNum - 2][colNum] = datatable.getCellData(testName, colNum, rowNum);
//				System.out.println(data[rowNum - 2][colNum]);
//			}
//		}
//
//		return data;
//
//	}
//
//	// store screenshots
//
//	public static boolean setData(String testName, String data) {
//
//		String path = System.getProperty("user.dir") + "//src//Config//TestData.xlsx";
//		boolean isPassed = false;
//		System.out.println("File location::::" + path);
//
//		if (datatable == null) {
//			// load the suite 1 sheet
//			datatable = new XL_Reader(path);
//
//		}
//		int rows = datatable.getRowCount(testName) - 1;
//		if (rows > 0) {
//
//			rows = datatable.getRowCount(testName);// 3
//			int cols = datatable.getColumnCount(testName);
//			System.out.println("Test Name -- " + testName);
//			System.out.println("total rows -- " + rows);
//			System.out.println("total cols -- " + cols);
//
//			for (int rowNum = 2; rowNum <= rows; rowNum++) {
//
//				for (int colNum = 0; colNum < cols; colNum++) {
//					isPassed = datatable.setCellData(testName, "Result", rowNum, data);
//					System.out.println("Test::" + isPassed);
//				}
//			}
//
//		}
//
//		return isPassed;
//
//	}
//
//	public static void setCellValue(String testName,String colName, int rowNum, String data1) {
//
//		String path = System.getProperty("user.dir") + "//src//Config//TestData.xlsx";
//
//		System.out.println("File location::::" + path);
//
//		if (datatable == null) {
//			// load the suite 1 sheet
//			datatable = new XL_Reader(path);
//
//		}
//
//		datatable.setCellData(testName, colName, rowNum, data1);
//
//	}
//
//	public static void takeScreenShot(String fileName) {
//		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//		try {
//			FileUtils.copyFile(scrFile,
//					new File(System.getProperty("user.dir") + "\\screenshots\\" + fileName + ".jpg"));
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

}
