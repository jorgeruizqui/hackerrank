package org.jor.amazon;

import java.util.Arrays;
import java.util.Scanner;

public class AmazonTest {

	public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        // First step is to read the number of cities and clinics
		int n = s.nextInt();
		int b = s.nextInt();
        
        // Once we have the numbers, read the population of each city and complete the population array
		long [] arrPopCities = new long[n];
		for (int i = 0; i < n; i++) {
			arrPopCities[i] = s.nextLong();
		}
        
        // The first assingment is one clinic for each city
		long [] arrAssignment = new long[n];
		Arrays.fill(arrAssignment, 1);
		
		// Next steps, assignment of the rest of the clinics
		// We have B - N clinics
		int clinicsLeft = b - n;
		
		while (clinicsLeft > 0) {
			// 1. Obtain the city with more population according to the current assignment
			int index = 0;
			long currentMax = 0;
			for (int i = 0; i < arrPopCities.length; i++) {
				long current = arrPopCities[i] / arrAssignment[i];
				if (current > currentMax) {
					currentMax = current;
					index = i;
				}
			}
			
			// Assignment of a new clinic to this city
			arrAssignment[index] = arrAssignment[index] + 1;
			clinicsLeft--;
		}
		
		long maxAssignment = 0;
		for (int i = 0; i < arrPopCities.length; i++) {
			long current = arrPopCities[i] / arrAssignment[i];
			if (current > maxAssignment) {
				maxAssignment = current;
			}
		}
		
		System.out.println("MAX:" + maxAssignment);
		

	}

	/**
	 * Method to
	 * 
	 * @param arr
	 */
	public static void printArrayReverseOrder(int[] arr) {
		for (int i = (arr.length - 1); i >= 0; i--) {
			System.out.print(arr[i] + " ");
		}
	}

}
