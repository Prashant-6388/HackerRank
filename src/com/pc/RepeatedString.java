package com.pc;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class RepeatedString {

    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {
    	if(s.length()<=0 || s.length()>100)
    		return 0;
    	
    	if(n>1000000000000L) return 0;
    	
    	long numOfOccurance = 0;
    	for(int i=0;i<s.length();i++) {
    		if(s.charAt(i)=='a') numOfOccurance++;
    	}
    	
    	long extraChars = n % s.length();
    	long totalOccurances = n/s.length() * numOfOccurance;
    	for(int i=0;i<extraChars;i++) {
    		if(s.charAt(i)=='a') totalOccurances++;
    	}
    	return totalOccurances;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
    	
        String s = "a";

        long n = 10;

        long result = repeatedString(s, n);
        
        System.out.println("Result = "+result);
        
    }
}
