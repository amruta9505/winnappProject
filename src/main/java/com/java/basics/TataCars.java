package com.java.basics;

public interface TataCars {
	
	

		public void addAGradeSteel();
		public void addGPS();
		
		public static void changeBrand() {
			System.out.println("brand is changed");
		}
		
		public default void changeCarType() {
			System.out.println("car type changed");
		}
	

}
