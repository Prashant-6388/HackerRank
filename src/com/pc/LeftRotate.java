package com.pc;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class LeftRotate {

    // Complete the rotLeft function below.
    static int[] rotLeft(int[] a, int d) {
    	if(a.length > 100000) return a;
    	if(d > a.length) return a;
    	
    	int tempArr[] = new int[a.length - d];
    	for(int i=d,j=0;i<a.length;i++,j++) {
    		tempArr[j] = a[i];
    	}
    	
    	for(int i=d-1,j=0;i>=0;i--,j++) {
    		a[a.length-1 -  j]=a[i];
    	}
    	for(int i=0;i<tempArr.length;i++)
    		a[i] = tempArr[i];
    	
    	return a;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String[] nd = "5 4".split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] a = new int[n];

        String[] aItems = "1 2 3 4 5".split(" ");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        int[] result = rotLeft(a, d);
        
        Utils.printArray(result);

    }
}
