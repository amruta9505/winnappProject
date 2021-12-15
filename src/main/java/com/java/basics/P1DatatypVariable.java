package com.java.basics;

import java.util.Iterator;

public class P1DatatypVariable {

	public static void main(String[] args) {
		
		long creditCard = 4444_3333_2222_1111L;
		//premitive
		//byte	: Byte
		//short : Short
		//int	: Integer
		//long	: Long
		//float : Float
		//double: Double
		//char	: Character
		//boolean : Boolean

		//Wrapper Types : 
		
		//Reference Types
		
		String x = "10";
		String y = "20";
		System.out.println(x+y);
		System.out.println(Integer.parseInt(x) + Integer.parseInt(y));
		
		String isThere = "true";
		if (Boolean.parseBoolean(isThere)) {
			
		}
//		String, Object
//		Object is the super class in java
		
		//Arrays
		//Fixed Length & Type Specific
		
		// new Array, {}
		
		//Conditions : IF, Switch
		//Loops : For, While, Do While
		//For Loops : index based for loop, iterator based, foreach internal loop
		
		//Class, Object, Method:
		
		//Class with main method : Reusable and executable
		// new ClassNAme()
		// static : Accessed using using class/instance, Class members, Can access only static members from static area
		// instance : Creates new memory allocation
		
		
		//Access Modifiers
		// public, private, protected, default
		
		P1DatatypVariable dv = new P1DatatypVariable();
		System.out.println(dv.DemoAdd(2, 3));
		System.out.println(dv.DemoAdd(2, 3, 4));
		dv.DemoAddAll(10,20,30,40);
		
		int [] data = {10,20,30};
		dv.DemoAddAll(10,20,30);
	}

	private int DemoAdd(int a, int b) {

		return a+b;
	}
	//over loaded
	private int DemoAdd(int a, int b,int c) {

		return a+b+c;
	}
	
	private void DemoAddAll(int...n) { 
		
		//JavaScriptExecutor
		
		// n is rest parameter
		System.out.println(n[0]);
		//for each
		for (int i:n) {			
			System.out.println(i);
		}
	}
	
}












