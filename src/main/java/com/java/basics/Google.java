package com.java.basics;

	public class Google {

		void search() {

			System.out.println("Search in Google");
		}
	}

	class Gmail extends Google {

		//over ride
		void search() {
			super.search();
//			System.out.println("Search in gmail");
		}
		
		//overload
		void search(String kw) {

			System.out.println("Search in gmail with keyword "+kw);
		}
	}


