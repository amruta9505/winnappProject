package com.java.basics;

public class P3AbstractClassExample {

	public static void main(String[] args) {
		
//		new CommonFeatures() //gives error

		new Module1().demo();
	}

}

class Module1 extends CommonFeatures{

	public void demo() {
		//implements abstract methods here
		System.out.println("demo called");
	}
	
}

abstract class  CommonFeatures{
	//a,b,c
	// 5 common functionalities
	
	// common
	// can have normal and abstract methods
	
	public abstract void demo();
	
}