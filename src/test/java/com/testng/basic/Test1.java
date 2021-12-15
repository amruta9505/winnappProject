package com.testng.basic;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test1 {
	
	@BeforeClass
	public void openApplication()
	{
		System.out.println("open the application");
	}
	
	@AfterClass
	public void closeApplication()
	{
		System.out.println("close the application");
	}
	@BeforeMethod
	public void loginInToApplication()
	{
		System.out.println("login into application");
	}
	@AfterMethod
	public void logoutFromApplication()
	{
		System.out.println("logout from appilcation");
	}
  @Test
  public void t1() {
	  System.out.println("hello i am test1");
  }
  
  @Test
  public void t2()
  {
	  System.out.println("hello i am test2 ");
  }
  
}
