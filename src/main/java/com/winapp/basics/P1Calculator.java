package com.winapp.basics;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.windows.WindowsDriver;

public class P1Calculator {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		try {
		//specify session info
		DesiredCapabilities cap= new DesiredCapabilities();
		
		//application exe path or app id / Package Family Name
		
		cap.setCapability("app", "Microsoft.WindowsCalculator_8wekyb3d8bbwe!App");
		
		WindowsDriver<WebElement> driver =  new WindowsDriver<>(new URL("http://127.0.0.1:4723/"), cap);
		
		System.out.println(driver.getTitle());
		driver.findElementByName("Two").click();
		driver.findElementByName("Plus").click();
		driver.findElementByName("Three").click();
		driver.findElement(By.name("Equals")).click();
		String res = driver.findElementByAccessibilityId("CalculatorResults").getText();
		String arr[] = res.split(" ");
		
		System.out.println("The Result is: "+arr[arr.length-1]);
		
		
		}
		catch(MalformedURLException e){
			e.printStackTrace();
			
			
		}

	}

}
