package com.wd.tng;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;

public class Test1Calculator extends TestBaseCalculator {
	@Test
	public void Test1Add() {
		try {
			driver.findElementByName("Two").click();
			driver.findElementByName("Plus").click();
			driver.findElementByName("Three").click();
			driver.findElement(By.name("Equals")).click();
			String res = driver.findElementByAccessibilityId("CalculatorResults").getText();
			String arr[] = res.split(" ");

			System.out.println("The Result is: " + arr[arr.length - 1]);

			Assert.assertEquals(arr[arr.length - 1], "5");
			Reporter.log("Add Functionality Successful");
		} catch (Exception | Error e) {
			Reporter.log("Add Functionality is Failed");
			Assert.fail(e.getMessage());
		}
	}
	@Test
	public void Test2Mul() {
		try {
			driver.findElementByName("Two").click();
			driver.findElement(MobileBy.AccessibilityId("multiplyButton")).click();
			driver.findElementByName("Three").click();
			driver.findElement(By.name("Equals")).click();
			String res = driver.findElementByAccessibilityId("CalculatorResults").getText();
			String arr[] = res.split(" ");

			System.out.println("The Result is: " + arr[arr.length - 1]);

			Assert.assertEquals(arr[arr.length - 1], "6");
			Reporter.log("Multiplication Functionality Successful");
		} catch (Exception | Error e) {
			Reporter.log("Multiplication Functionality is Failed");
			Assert.fail(e.getMessage());
		}
	}
}
