package com.winapp.basics;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileBy;
import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.WindowsElement;

public class P6FlightApp_ReserveOrder_NewSession {

	public static void main(String[] args) {
		
		try {
			
			//Create Window capabilities
			DesiredCapabilities flightcap= new DesiredCapabilities();
			flightcap.setCapability("app", "C:\\WinAppSoftware\\Flights Application\\Flights Application\\FlightsGUI.exe");						
			
			//Get control over Window
			WindowsDriver<WindowsElement> driver =  new WindowsDriver<>(new URL("http://127.0.0.1:4723/"), flightcap);
			
			driver.findElement(MobileBy.AccessibilityId("agentName")).sendKeys("john");
			driver.findElement(MobileBy.AccessibilityId("password")).sendKeys("hp");
			
			//explicit waiting
			new WebDriverWait(driver, 10)
			.until(ExpectedConditions
					.elementToBeClickable(MobileBy.AccessibilityId("okButton"))).click();
			
//			driver.findElement(MobileBy.AccessibilityId("okButton")).click();
			
			//specify session info
			DesiredCapabilities dcap= new DesiredCapabilities();
						
			//Specify root session
			dcap.setCapability("app", "Root");
			
			//Start Desktop session
			WindowsDriver<WindowsElement> driverRoot =  new WindowsDriver<>(new URL("http://127.0.0.1:4723/"), dcap);			
			
			WindowsElement mainWindow = driverRoot.findElement(By.name("HP MyFlight Sample Application"));
			String wndHandle = mainWindow.getAttribute("NativeWindowHandle");
			
			//Create Window capabilities
			DesiredCapabilities flightwndcap= new DesiredCapabilities();
			flightwndcap.setCapability("appTopLevelWindow", Integer.toHexString(Integer.parseInt(wndHandle)));						
			
			//Get control over Window
			WindowsDriver<WindowsElement> flightDriver =  new WindowsDriver<>(new URL("http://127.0.0.1:4723/"), flightwndcap);

			System.out.println(flightDriver.getTitle());
			flightDriver.findElement(MobileBy.AccessibilityId("fromCity")).click();
			flightDriver.findElement(MobileBy.name("Paris")).click();
			mainWindow.sendKeys("ALT+F4");
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

	}

}