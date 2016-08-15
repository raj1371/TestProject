package com.ReadSqlDataTest;

import org.testng.annotations.Test;

import com.ReadSqlData.ReadsqlData;

public class ReadsqlDataTest {
	
	@Test
	public void ReadDataTest() throws Throwable{
		ReadsqlData sqlReader=new ReadsqlData();
		sqlReader.ReadData();
	}

}
