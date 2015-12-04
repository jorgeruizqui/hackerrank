package org.jor.amazon;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class TestTreeMaps {

	public static void main(String[] args) {
		
		Tree<Integer> tree = new Tree<Integer>(1);
		
		tree.addLeaf(5);
		tree.addLeaf(89);
		tree.addLeaf(55);
		
		System.out.println(tree.toString());
		
		int [] arr = new int [2];
		arr[0] = 1000000001;
		arr[1] = 1000000002;
		
		
		System.out.println(calculateBigSum(arr));
		
		
	}
	
    public static BigDecimal calculateBigSum(int [] arr) {
        
        if (arr.length <= 0) {
            return new BigDecimal(0);
        }
        
        BigDecimal sum = new BigDecimal(arr[0]);
        for (int i = 0; i < arr.length; i++) {
            sum = sum.add(new BigDecimal(arr[i]));
        }
        return sum;
    }
}
