package com.testng.basic;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BaseTest {
	
	@BeforeSuite
	public void startApplication()
	{
		
	}
	@AfterSuite
	public void closeApllication()
	{
		
	}
	@BeforeTest
	public void startDesktopSession()
	{
		
	}
	@AfterTest
	public void closeDesktopSession()
	{
		
	}
	@BeforeClass
	public void startAppSession()
	{
		
	}
	@AfterClass
	public void stopAppSession()
	{
		
	}
	
//  @Test
//  public void f() {
//  }
}
