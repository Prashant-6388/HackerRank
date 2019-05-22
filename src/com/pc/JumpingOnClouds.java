package com.pc;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class JumpingOnClouds {

    // Complete the jumpingOnClouds function below.
    static int jumpingOnClouds(int[] c) {
    	int jump=0;
    	if(c.length<2 || c.length >100)
    		return 0;
    	if(c[0]!= 0 || c[c.length-1]!=0)
    		return 0;
    	
    	for(int i=0;i<c.length;i++) {
    		if(c[i]!=0 && c[i]!=1) 
    			return 0;
    		else {
    			if(c[i] == 0 ) {
    				if((i+2 < c.length) && c[i+2]==0) {
    					i++;
    				}
    				jump++;
    			}
    		}
    	}
    	return jump-1;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int n = 7;

        int[] c = new int[n];

        String[] cItems = "0 0 1 0 0 1 0".split(" ");

        for (int i = 0; i < n; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int result = jumpingOnClouds(c);
        System.out.println("jumps = "+result);
    }
}
