package com.java.basics;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P2OopsBasics {

	public static void main(String[] args) {
		
		//Encapsulation : Protect Data
			//Getters and Setters
		
		Employee emp1 = new Employee();
		Employee emp2 = new Employee();
		
		System.out.println(emp1.getAge());		
		
		System.out.println(emp2.getAge());
		
		emp1.setAge(19);
		System.out.println(emp1.getAge());
		emp1.setAge(61);
		System.out.println(emp1.getAge());
		
		emp1.setAge(30);
		
		emp2.setAge(35);
		
		System.out.println(emp1.getAge());
		System.out.println(emp2.getAge());
		
		Gmail gm = new Gmail();
		gm.search();
		gm.search("winapp");
		
		Google g1 = new Google();
		g1.search();
		
		Google g2 = new Gmail();
		g2.search(); //override
		
		Altroz alt = new Altroz();
		alt.changeCarType(); //interface default can be accessed using instance
		TataCars.changeBrand(); //interface static can be accessed using interface name
		
		//interface with one abstract method is called functional interface
		//this will be used for lambda expression
		
		//class var = new classname();
		//parentclass var = new childclassname();
		//interface var = new classname();
		
//		ChromeDriver driver = new ChromeDriver();
		
		WebDriver driver = new ChromeDriver();
		
		TakesScreenshot ts = (TakesScreenshot) driver;
//		alt.addAGradeSteel();
//		alt.addGPS();
//		alt.addRightHandSteering();
//		alt.changeCarType();
//		alt.addRightHandSteering();
		
		TataCars car2 = new Altroz();
		car2.addAGradeSteel();
		car2.addGPS();
		car2.changeCarType();
		
		Irs car3 = (Irs) car2;
	}

}
