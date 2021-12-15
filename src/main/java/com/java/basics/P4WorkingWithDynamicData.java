package com.java.basics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;

public class P4WorkingWithDynamicData {

	public static void main(String[] args) {
		
		//Read Data from grid and check user name exist or not
		
		// Collection Framework classes
		
		// List, Set, Map
		
		List<String> empIds = new ArrayList<>();
		empIds.add("id1");
		empIds.add("id2");
		empIds.add("id3");
		
		System.out.println(empIds.get(0));
		
		//driver.findElements(locator) return list of webelements
		//List<WebElement>
		
		//To store unique data
		
//		Set<Integer> uniqData = new HashSet<>();
		TreeSet<Integer> uniqData = new TreeSet<>();
		uniqData.add(30);
		uniqData.add(30);
		uniqData.add(20);
		uniqData.add(10);
		uniqData.add(20);
		uniqData.add(30);
		uniqData.add(40);
		
		
		NavigableSet<Integer> dData =uniqData.descendingSet();
		
		for(int n : uniqData) {
			System.out.println(n);
		}
		
		for(int n : dData) {
			System.out.println(n);
		}
		
		login("john", "hp");
		
		String [] userData = {"john", "hp"};
		login(userData);
		
		List<String> userData1 = Arrays.asList("john", "hp");
		
		HashMap<String, String> userMap= new HashMap<>();
		userMap.put("username", "john");
		userMap.put("password", "hp");
		login(userMap);
	}

	public static void login(String userName, String password) {
		System.out.println("Login with "+userName+" and "+password);
	}
	
	public static void login(String data[]) {
		System.out.println("Login with "+data[0]+" and "+data[1]);
	}
	
	public static void login(List<String> data) {
		System.out.println("Login with "+data.get(0)+" and "+data.get(1));
	}
	
	public static void login(HashMap<String, String> data) {
		System.out.println("Login with "+data.get("username")+" and "+data.get("password"));
	}
	
}





