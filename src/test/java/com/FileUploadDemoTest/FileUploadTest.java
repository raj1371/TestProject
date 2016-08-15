package com.FileUploadDemoTest;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.FileUploadDemo.FileUpload;
import com.FileUploadDemo.FileUploadAutoIT;
import com.commonTest.TestBase;

public class FileUploadTest extends TestBase {

//	@Test
//	public void FileUploadtest() throws IOException, AWTException {
//
//		FileUpload fup = new FileUpload(getDriver1());
//
//		String strFile = fup.upLoadFile();
//
//		System.out.println("File UploadTest passed");
//
//		Assert.assertEquals(strFile.contains("Rajes_New.docx"), true);
//
//	}

	 @Test
	 public void FileUploadAutoIT() throws IOException, AWTException {
	
	 FileUploadAutoIT fupAutoit = new FileUploadAutoIT(getDriver1());
	
	 String strFile = fupAutoit.upLoadFileAutoIT();
	
	 System.out.println("Fileupload Auto it test passed");
	
	 Assert.assertEquals(strFile.contains("Rajes_New.docx"), true);
	
	 }

}
