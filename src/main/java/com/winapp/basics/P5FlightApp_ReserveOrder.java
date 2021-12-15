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

public class P5FlightApp_ReserveOrder {

	public static void main(String[] args) {
		
		try {
			
			//Start winappdriver before executing this
			
//			//Create Window capabilities
//			DesiredCapabilities flightcap= new DesiredCapabilities();
//			flightcap.setCapability("app", "F:\\Softwares\\WinAppDriver\\FlightsApplication\\FlightsGUI.exe");						
//			
//			//Get control over Window
//			WindowsDriver<WindowsElement> driver =  new WindowsDriver<>(new URL("http://127.0.0.1:4723/"), flightcap);
//			
			
			
			Runtime.getRuntime().exec("C:\\Users\\AJADHA3\\Downloads\\Flights Application\\Flights Application\\FlightsGUI.exe");
			//specify session info
			DesiredCapabilities dcap= new DesiredCapabilities();
						
			//Specify root session
			dcap.setCapability("app", "Root");
			
			//Start Desktop session
			WindowsDriver<WindowsElement> driverRoot =  new WindowsDriver<>(new URL("http://127.0.0.1:4723/"), dcap);			
			
			WindowsElement loginWindow = driverRoot.findElement(By.name("HP MyFlight Sample Application"));
			
			loginWindow.findElement(MobileBy.AccessibilityId("agentName")).sendKeys("john");
			loginWindow.findElement(MobileBy.AccessibilityId("password")).sendKeys("hp");
			loginWindow.findElement(MobileBy.name("OK")).click();
			Thread.sleep(2000);
			
			WindowsElement mainWindow = driverRoot.findElement(By.name("HP MyFlight Sample Application"));
			mainWindow.findElement(MobileBy.AccessibilityId("fromCity")).click();
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}