package org.jor.hackerrank.projecteuler;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ProjectEuler {

	public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        // First step is to read the number of cities and clinics
		long n = s.nextLong();
		for (long i = 0; i < n; i++) {
			sumEvenValuesFibonacci(s.nextLong());
			System.out.println(sum);
			sum = 0;
		}
		
	}
	
	public static long sumAllMultiples3and5(long n) {
		long numberOfThrees = (n - 1)/3;
		long numberOfFives = (n - 1)/5;
		long numberOfFifteen = (n - 1)/15;
		
		long n3 = (n - 1) - ((n - 1) % 3);
		long n5 = (n - 1) - ((n - 1) % 5);
		long n15 = (n - 1) - ((n - 1) % 15);

		long sumAllThree = (numberOfThrees * (3 + n3)) / 2;
		long sumAllFive = (numberOfFives * (5 + n5)) / 2;
		long sumAll15 = (numberOfFifteen * (15 + n15)) / 2;
		return sumAllFive + sumAllThree - sumAll15;
		
	}
	
	private static long sum = 0;
	public static long sumEvenValuesFibonacci(long n) {
		if (n > 1) { // && (n % 2) == 0) {
			long fib = sumEvenValuesFibonacci(n - 1) + sumEvenValuesFibonacci(n - 2);
			if (fib % 2 == 0) {
				sum += fib;
			}
			return fib;
		} else return 1;
	}
}
