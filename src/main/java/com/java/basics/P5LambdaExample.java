package com.java.basics;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class P5LambdaExample {
	//java built in functional interface list
	//https://docs.oracle.com/javase/8/docs/api/java/util/function/package-summary.html
	
	//implementing Selenium 4 relative locator concept in selenium 3 using lambdas
	//https://www.qtpsudhakar.com/2021/06/customizing-selenium-4-relative-locator.html
	
	public static void main(String[] args) {

		CalcImp ci = new CalcImp();
		ci.doCalc(10, 20);

		calculate(100, 200, ci);

		calculate(2, 3, new CalcListener() {
			public void doCalc(int a, int b) {

				System.out.println(a * b);
			}
		});

		calculate(15, 30, (int a, int b) -> System.out.println(a * b));

		// fluent wait

//		WebDriver driver = null;
//
//		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
//				.pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class);
//
//		WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
//			public WebElement apply(WebDriver driver) {
//				return driver.findElement(By.id("foo"));
//			}
//		});
//
//		WebElement foo1 = wait.until((WebDriver driver1) -> driver1.findElement(By.id("foo")));

	}

	public static void calculate(int a, int b, CalcListener calc) {
		calc.doCalc(a, b);
	}
}

interface CalcListener { // functional interface
	public void doCalc(int a, int b);
}

class CalcImp implements CalcListener {
	public void doCalc(int a, int b) {
		System.out.println(a + b);
	}
}