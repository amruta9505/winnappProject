package com.winapp.basics;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.wd.config.Config;
import com.wd.utils.SessionFactory;

import io.appium.java_client.MobileBy;
import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.WindowsElement;

public class P8FlightApp_ReserveOrder_StartWinapp {

	public static void main(String[] args) {

		try {

			//start winapp driver
			ProcessBuilder builder = new ProcessBuilder(Config.WINAPPDRIVER_PATH,Config.PORT_NUMBER).inheritIO();
			Process process= builder.start();
			
			SessionFactory session = new SessionFactory();

			WindowsDriver<WindowsElement> driver = session
					.getAppSession("C:\\WinAppSoftware\\Flights Application\\Flights Application\\FlightsGUI.exe");

			// explicit waiting
			WebDriverWait wait = new WebDriverWait(driver, 10);

			wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("agentName")));
			
			driver.findElement(MobileBy.AccessibilityId("agentName")).sendKeys("john");
			driver.findElement(MobileBy.AccessibilityId("password")).sendKeys("hp");

			
			wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("okButton"))).click();

			// Get control over Window
			WindowsDriver<WindowsElement> flightDriver = session.getAppSessionByName("HP MyFlight Sample Application");

			System.out.println(flightDriver.getTitle());
			
			//select from place
			flightDriver.findElement(MobileBy.AccessibilityId("fromCity")).click();
			flightDriver.findElement(MobileBy.name("Paris")).click();
			System.out.println(flightDriver.findElement(MobileBy.AccessibilityId("fromCity")).getText());			
			
			flightDriver.findElement(MobileBy.AccessibilityId("toCity")).click();
			flightDriver.findElement(MobileBy.name("London")).click();
			//select to place
			flightDriver.findElement(MobileBy.AccessibilityId("PART_Button")).click();
			flightDriver.findElement(By.name("Thursday, September 30, 2021")).click();
			
			flightDriver.findElement(By.name("FIND FLIGHTS")).click();
			
			flightDriver.findElements(By.className("DataGridRow")).get(0).click();
			
			flightDriver.findElement(MobileBy.AccessibilityId("selectFlightBtn")).click();
			
			flightDriver.findElement(MobileBy.AccessibilityId("passengerName")).sendKeys("morningstar");
			
			WindowsElement elm= flightDriver.findElement(By.name("ORDER"));
			
			new Actions(flightDriver).moveToElement(elm).click().build().perform();
			
//			flightDriver.findElement(By.name("ORDER")).click();
			
			new WebDriverWait(flightDriver, 10).until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("orderCompleted")));
			String ordId = flightDriver.findElement(MobileBy.AccessibilityId("orderCompleted")).getText();
			System.out.println(ordId);

			WindowsDriver<WindowsElement> notepadDriver =session.getAppSession("C:\\Windows\\System32\\notepad.exe");
			notepadDriver.findElement(By.name("Text Editor")).sendKeys(ordId);
			
			System.out.println(notepadDriver.getTitle());
			
			System.out.println(flightDriver.getTitle());
			
			//stop winapp driver
			process.destroyForcibly();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}