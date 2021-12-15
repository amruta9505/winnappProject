package com.winapp.basics;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.WindowsElement;

public class P2AttachRunningApp {

	public static void main(String[] args) {
		
		try {
			
			//Start winappdriver before executing this
			
			Runtime.getRuntime().exec("calc");
			
			//specify session info
			DesiredCapabilities dcap= new DesiredCapabilities();
						
			//Specify root session
			dcap.setCapability("app", "Root");
			
			//Start Desktop session
			WindowsDriver<WindowsElement> driverRoot =  new WindowsDriver<>(new URL("http://127.0.0.1:4723/"), dcap);			
			
			//print desktop name
			System.out.println(driverRoot.getTitle());
			
			//get windows by window name
			List<WindowsElement>lstWindows= driverRoot.findElementsByName("Calculator");
			
			//get NativeWindowHandle attribute
			String wndHandle = lstWindows.get(0).getAttribute("NativeWindowHandle");
			
			//Create Window capabilities
			DesiredCapabilities calcap= new DesiredCapabilities();
			calcap.setCapability("appTopLevelWindow", Integer.toHexString(Integer.parseInt(wndHandle)));						
			
			//Get control over Window
			WindowsDriver<WindowsElement> driver =  new WindowsDriver<>(new URL("http://127.0.0.1:4723/"), calcap);
			
			driver.findElement(By.name("Two")).click();
			driver.findElement(By.name("Plus")).click();
			driver.findElement(By.name("Three")).click();
			driver.findElement(By.name("Equals")).click();
			String res = driver.findElement(MobileBy.AccessibilityId("CalculatorResults")).getText();
			String arr[] = res.split(" ");
			
			System.out.println("The Result is: "+arr[arr.length-1]);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}