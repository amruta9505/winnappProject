package com.wd.tng;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.wd.config.Config;
import com.wd.utils.SessionFactory;

import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.WindowsElement;

public class TestBaseCalculator {
	ProcessBuilder builder;
	Process process;
	WindowsDriver<WindowsElement> driverRoot;
	WindowsDriver<WindowsElement> driver;
	SessionFactory session = new SessionFactory();
	
	@BeforeSuite
	public void StartWinAppDriver() {

		try {
			builder = new ProcessBuilder(Config.WINAPPDRIVER_PATH, Config.PORT_NUMBER).inheritIO();
			process = builder.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@AfterSuite
	public void closeWinAppDriver() {
		process.destroyForcibly();
	}

	@BeforeTest
	public void OpenRootSession() {
		session = new SessionFactory();

		driverRoot = session.getDesktopSession();
	}

	@AfterTest
	public void CloseRootSession() {
		driverRoot.quit();
	}
	
	@BeforeTest
	public void OpenAppSession() {
		driver = session.getAppSession(Config.CALC_APP_ID);
	}

	@AfterTest
	public void CloseAppSession() {
		driver.quit();
	}
}
