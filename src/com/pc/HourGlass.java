package com.pc;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class HourGlass {

    // Complete the hourglassSum function below.
	static int hourglassSum(int[][] arr) {
		int maxSum=-999;
		for (int row = 0; row < arr.length; row++) {
			for (int col = 0; col < arr[0].length; col++) {
				if(row<arr.length-2 && col<arr.length-2) {
					int sum = arr[row][col] + arr[row][col+1] + arr[row][col+2]; //top row
					sum += arr[row+1][col+1]; //middle element
					sum += arr[row+2][col] + arr[row+2][col+1] + arr[row+2][col+2];//bottom row
					
					if(sum > maxSum)
						maxSum = sum;
				}
				else {
					if(arr[row][col] <-9 || arr[row][col] > 9 ) {
						return 0;
					}
				}
					
			}
		}
		return maxSum;
	}

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int[][] arr = { {-1,-1,0,-9,-2,-2},
		        		{-2,-1,-6,-8,-2,-5},
		        		{-1,-1,-1,-2,-3,-4},
		        		{-1,-9,-2,-4,-4,-5},
		        		{-7,-3,-3,-2,-9,-9},
		        		{-1,-3,-1,-2,-4,-5}
		        	  };
        
        /*for (int i = 0; i < 6; i++) {
            String[] arrRowItems = "".split(" ");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }*/
		System.out.println("rows=" + arr.length+", cols = "+arr[0].length);

		int result = hourglassSum(arr);
		System.out.println("max sum=" + result);
    }
}
