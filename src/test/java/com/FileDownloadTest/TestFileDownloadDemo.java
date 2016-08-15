package com.FileDownloadTest;

import org.testng.annotations.Test;

import com.FileDownloadDemo.FileDownloadDemo;

public class TestFileDownloadDemo {

	@Test
	public void TestFileDownload() {
		
		FileDownloadDemo fD = new FileDownloadDemo();
		fD.DownloadJava();

	}

}
