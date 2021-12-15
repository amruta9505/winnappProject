package com.winapp.basics;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.WindowsElement;

public class P4FlightApp {

	public static void main(String[] args) {
		
		try {
			
			//Start winappdriver before executing this
			
			//Create Window capabilities
			DesiredCapabilities flightcap= new DesiredCapabilities();
			flightcap.setCapability("app", "C:\\Users\\AJADHA3\\Downloads\\Flights Application\\Flights Application\\FlightsGUI.exe");						
			
			//Get control over Window
			WindowsDriver<WindowsElement> driver =  new WindowsDriver<>(new URL("http://127.0.0.1:4723/"), flightcap);
			
			driver.findElement(MobileBy.AccessibilityId("agentName")).sendKeys("john");
			driver.findElement(MobileBy.AccessibilityId("password")).sendKeys("john");
			driver.findElement(MobileBy.AccessibilityId("okButton")).click();
			
			WindowsElement loginFail =  driver.findElement(By.name("Login Failed"));
			loginFail.findElement(By.name("OK")).click();
			
			driver.findElement(By.name("Cancel")).click();
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}