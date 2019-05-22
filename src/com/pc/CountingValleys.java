package com.pc;

import java.io.IOException;
import java.util.Scanner;

public class CountingValleys {

    // Complete the countingValleys function below.
    static int countingValleys(int n, String s) {
		int numOfValleys = 0;
		int downSteps = 0;
		for (int i = 0; i < n; i++) {
			if (s.charAt(i) == 'D') {
				downSteps++;
			} else {
				if (downSteps > 1) {
					downSteps--;
					while (++i < n && s.charAt(i) == 'U') {
						downSteps--;
					}
					if (downSteps <= 0 && i > 0)
						numOfValleys++;
				}
			}
		}
    	/*int numOfValleys = 0;
    	int downSteps = 0;
    	for(int i=0;i<n;i++) {
     		if(s.charAt(i)=='D') {
    			downSteps ++;
    		}
    		else if(s.charAt(i)=='U')
    		{
    			if(downSteps>0) {
    				downSteps --;
	    			if(downSteps == 0 && i>0)
	    				numOfValleys++;
    			}
    		}
    	}
    	return numOfValleys;*/
    	return numOfValleys;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int n = 10;
        

//        String s = "UDDDUDUU";
//        String s ="UDUUUDUDDD";
        String s = "DUDDDUUDUU";
/*        String s ="DDUDUDDUDDUDDUUUUDUDDDUUDDUUDDDUUDDUUU"
        		+ "UUUDUDDDDUDDUUDUUDUDUUUDUUUUUDDUDDDDUD"
        		+ "DUDDDDUUUUDUUDUUDUUDUDDD";*/
        int result = countingValleys(n, s);

        System.out.println("Result = "+result);
    }
}