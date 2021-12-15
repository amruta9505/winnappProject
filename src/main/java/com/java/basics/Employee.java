package com.java.basics;

public class Employee {

	private int age = 25; //20-60
	
	public int getAge() {
		return this.age;
	}
	
	public void setAge(int age) {
		if(age>60) {
			System.out.println("Employee age must be less than or equal 60");
		}else if(age<20) {
			System.out.println("Employee age must be greater than or equal 20");
		}else {
			this.age = age;
		}
	}
	
	
}