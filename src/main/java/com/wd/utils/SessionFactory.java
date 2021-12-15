package com.wd.utils;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.WindowsElement;

public class SessionFactory {
	private WindowsDriver<WindowsElement> driverRoot;
	public WindowsDriver<WindowsElement> getDesktopSession() {		
		
		if(isSessionActive(driverRoot)) {
			return driverRoot;
		}
		
		// specify session info
		DesiredCapabilities dcap = new DesiredCapabilities();

		// Specify root session
		dcap.setCapability("app", "Root");

		// Start Desktop session
		
		try {
			driverRoot = new WindowsDriver<>(new URL("http://127.0.0.1:4723/"), dcap);

			return driverRoot;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;

	}
	
	public WindowsDriver<WindowsElement> getAppSession(String appIdOrPath) {
		
		// specify session info
		DesiredCapabilities appcap = new DesiredCapabilities();

		// Specify AppId or Path
		appcap.setCapability("app", appIdOrPath);

		// Start App session
		WindowsDriver<WindowsElement> driverApp;
		
		try {
			driverApp = new WindowsDriver<>(new URL("http://127.0.0.1:4723/"), appcap);

			return driverApp;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		return null;
	
	}
	
	public WindowsDriver<WindowsElement> getAppSessionByName(String appWindowName) {
		
		WindowsElement mainWindow = getDesktopSession().findElement(By.name(appWindowName));
		String wndHandle = mainWindow.getAttribute("NativeWindowHandle");
		
		//Create Window capabilities
		DesiredCapabilities wndcap= new DesiredCapabilities();
		wndcap.setCapability("appTopLevelWindow", Integer.toHexString(Integer.parseInt(wndHandle)));						
		
		//Get control over Window
		try {
			WindowsDriver<WindowsElement> appDriver =  new WindowsDriver<>(new URL("http://127.0.0.1:4723/"), wndcap);
			return appDriver;
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
	
	public WindowsDriver<WindowsElement> getAppSessionByLocator(By locator) {
		
		WindowsElement mainWindow = getDesktopSession().findElement(locator);
		String wndHandle = mainWindow.getAttribute("NativeWindowHandle");
		
		//Create Window capabilities
		DesiredCapabilities wndcap= new DesiredCapabilities();
		wndcap.setCapability("appTopLevelWindow", Integer.toHexString(Integer.parseInt(wndHandle)));						
		
		//Get control over Window
		try {
			WindowsDriver<WindowsElement> appDriver =  new WindowsDriver<>(new URL("http://127.0.0.1:4723/"), wndcap);
			return appDriver;
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
	
	public WindowsElement getAppWindowByLocator(By locator) {
		
		WindowsElement mainWindow = getDesktopSession().findElement(locator);						
		
		return mainWindow;
	}
	
	public WindowsElement getAppWindowByName(String appWindowName) {
		
		WindowsElement mainWindow = getDesktopSession().findElement(By.name(appWindowName));						
		
		return mainWindow;
	}
	
	
	private boolean isSessionActive(WindowsDriver<WindowsElement> session) {
		
		try {
			session.getTitle();
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}
}