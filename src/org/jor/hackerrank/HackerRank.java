package org.jor.hackerrank;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class HackerRank {

	public static void main(String[] args) {
		
		int [][] arr = new int [2][2];
		arr[0][0] = 1;
		arr[0][1] = 2;
		arr[1][0] = 3;
		arr[1][1] = 9;
		
		System.out.println(calculateDiagonalDifference(arr));
		
		System.out.println("fractionOfElements");
		int[] arr2 = {-4, 3, -9, 0, 4, 1};
		float [] result = fractionOfElements(arr2);
		System.out.println(result[0]);
		System.out.println(result[1]);
		System.out.println(result[2]);
		
		System.out.println("Stair Case");
		System.out.println(drawStairCase(6));

		System.out.println("Format Date");
		System.out.println(timeFormat("07:05:45PM"));
		System.out.println(timeFormat("11:34:23AM"));
		
		System.out.println("UTOPIAN TREE 4:" + utopianTree(4));
		System.out.println("FACTORIAL:" + extraLongFactorial(25));
		
		System.out.println("SCANNER TEST:");
//        Scanner s = new Scanner(System.in);
//        int n = s.nextInt();
//        int [] arrScan = new int[n];
//        for (int i = 0; i < n; i++) {
//        	arrScan[i] = s.nextInt();
//        }
//        
//        printArrayReverseOrder(arrScan);
	}
	
	public static void printArrayReverseOrder(int [] arr) {
		for (int i = (arr.length - 1); i >= 0; i--) {
			System.out.print(arr[i] + " ");
		}
	}
	
	
	public static int calculateDiagonalDifference(int [][] arr) {
	
		int diffDiagonalOne = 0;
		int diffDiagonalTwo = 0;
		int n = arr.length;
		
		for (int i = 0; i < n; i++) {
			diffDiagonalOne += arr[i][i]; 
			diffDiagonalTwo += arr[i][n -1 - i]; 
		}


		return Math.abs(diffDiagonalOne - diffDiagonalTwo); 
		
	}
	
	
	public static float [] fractionOfElements(int [] arr) {
		int positive = 0;
		int negative = 0;
		int zero = 0;
		
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < 0) negative++;
			else if (arr[i] > 0) positive++;
			else zero++;
		}
		
		float [] rto = new float [3];
		
		rto[0] = positive / (float) arr.length;
		rto[1] = negative / (float) arr.length;
		rto[2] = zero / (float) arr.length;
		
		return rto;
	}
	
	public static String drawStairCase(int n) {
		String character = "#";
		
		StringBuffer sb = new StringBuffer("");
		for (int i = 0; i < n; i++) {
			
			for (int j = 0; j < n; j++) {
				if (j < n - i - 1) sb.append(" ");
				else  sb.append(character);
			}
			sb.append("\n");
		}
		
		return sb.toString();
	}
	
	public static String timeFormat(String date) {
		String rto = "";
		//String convertedDate = date.replace("AM", "a").replace("PM", "p");
		SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ssa");
		SimpleDateFormat sdfToShow = new SimpleDateFormat("HH:mm:ss");
		try {
			Date d = sdf.parse(date);
			rto = sdfToShow.format(d);
		} catch (Exception e) {
		}
		
		return rto;
	}
	
	
	public static int utopianTree(int n) {
		int rto = 1;
		
		if (n > 0)  {
			int i = 1;
			while (i <= n) {
				if (i % 2 == 0) {
					rto +=1;
				} else {
					rto *= 2;
				}
				i++;
			}
		}
		return rto;
	}
	
	public static BigDecimal extraLongFactorial(int n) {
		
		if (n == 0) {
			return new BigDecimal(1);
		} else {
			return new BigDecimal(n).multiply(extraLongFactorial(n - 1));
		}
		
	}

	public static int largestHourglass6x6(int [][] matrix) {
		int currentMax = 0;
		
		for (int i = 0; i < matrix.length - 3; i++) {
			for (int j = 0; j < matrix.length - 3; j++) {
				int sum = matrix[i][j] + matrix[i][j + 1] + matrix[i][j + 2];
				sum +=  matrix[i + 1][j + 1];
				sum += matrix[i + 2][j] + matrix[i + 2][j + 1] + matrix[i + 2][j + 2];
				
				if (sum > currentMax) {
					currentMax = sum;
				}
			}
		}
		return currentMax;
	}
}
