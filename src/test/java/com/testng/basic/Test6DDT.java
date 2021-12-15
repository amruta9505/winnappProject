package com.testng.basic;

import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Test6DDT {
	@Test(dataProvider = "getData")
	public void test1( String...param) {
		System.out.println(param[0]);
		System.out.println(param[1]);
		System.out.println(param[2]);
		System.out.println(param[3]);
		
		Reporter.log("execute with :" +param[0]+param[1]+param[2]+param[3]);

		
	}

	@DataProvider
   public String[][] getData()
   {
	  String data[][]=new String[3][4];
	  //1st
	  data[0][0]="aaa";
	  data[0][1]="bbb";
	  data[0][2]="ccc";
	  data[0][3]="***";
	  
	  //2nd
	  data[1][0]="ddd";
	  data[1][1]="eee";
	  data[1][2]="fff";
	  data[1][3]="***";
	  
	//3nd
	  data[2][0]="ggg";
	  data[2][1]="hhh";
	  data[2][2]="iii";
	  data[2][3]="***";
	   
	  return data;

   }
}
