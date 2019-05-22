package com.pc;
import java.io.IOException;
import java.util.Scanner;

public class MatchingPairs {

    // Complete the sockMerchant function below.
    static int sockMerchant(int n, int[] ar) {
        int count,pairs=0;
        for(int i=0;i<n-2;i++)
        {
            count=1;
            if(ar[i] > 0)
	            for(int j=i+1;j<n;j++){
	                if(ar[i] == ar[j]) {
	                	count++; 
	                	ar[j]=-1;
	                }
	            }
            pairs += count/2;
        }
        return pairs;
    }
    
    public static void printArray(int arr[]) {
    	for(int i=0;i<arr.length;i++) {
    		System.out.print(" "+arr[i]);
    	}
    	System.out.println("");
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = 9;
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] ar = new int[n];

        String[] arItems = {"10","20","20","10","10","30","50","10","20"};
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        int result = sockMerchant(n, ar);

        System.out.println("Res : "+result);

    }
}
