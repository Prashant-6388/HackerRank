package com.pc;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FrequencyQueries {

	// Complete the freqQuery function below.
	static List<Integer> freqQuery(List<List<Integer>> queries) {
		HashMap<Integer, Integer> frequencies = new HashMap<>();
		List<Integer> result = new ArrayList<>();
		for(List<Integer> query : queries) {
			int num1 = (int)query.get(0);
			int num2 = (int)query.get(1);
			
			switch(num1) {
				case 1: if(frequencies.containsKey(num2))
							frequencies.put(num2, frequencies.get(num2)+1);
						else
							frequencies.put(num2, 1);
						
						break;
				case 2: if(frequencies.containsKey(num2) && frequencies.get(num2) > 0) 
							frequencies.put(num2, frequencies.get(num2)-1);
						
						break;
				case 3: if(frequencies.containsValue(num2))
							result.add(1);
						else
							result.add(0);
						break;
				default:
						return null;
			}
		}
		return result;
	}

	public static void main(String[] args) throws IOException {
		/*BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));*/

		int q = Integer.parseInt("8".trim());

		List<List<Integer>> queries = new ArrayList<>();

		/*IntStream.range(0, q).forEach(i -> {
			try {
				queries.add(Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
						.map(Integer::parseInt).collect(toList()));
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		});*/

		String str= "1 5\r\n" + 
				"1 6\r\n" + 
				"3 2\r\n" + 
				"1 10\r\n" + 
				"1 10\r\n" + 
				"1 6\r\n" + 
				"2 5\r\n" + 
				"3 2";
		String list[] =str.split("\r\n");
		for(String arr : list) {
			List<Integer> elements = new ArrayList<Integer>();
			String eles[] = arr.split(" ");
			for(String e: eles)
				elements.add(Integer.parseInt(e));
			queries.add(elements);
		}

		List<Integer> ans = freqQuery(queries);

		/*bufferedWriter.write(ans.stream().map(Object::toString).collect(joining("\n")) + "\n");

		bufferedReader.close();
		bufferedWriter.close();*/
	}
}
