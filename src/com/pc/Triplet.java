package com.pc;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

public class Triplet2 {

    // Complete the countTriplets function below.
    static long countTriplets(List<Long> arr, long r) {
    	HashMap<Long,Long> possiblilities = new HashMap<>();
    	HashMap<Long,Long> combos = new HashMap<>();
    	long triplets=0;
    	for(long num : arr) {
    		
    		long combosNum = combos.get(num)==null?0:combos.get(num);
			triplets += combosNum;
			
    		long nextNum = num * r;

    		long nextCombo = (combos.get(nextNum)==null?0:combos.get(nextNum)) + (possiblilities.get(num)==null?0:possiblilities.get(num));
    		
    		combos.put(nextNum, nextCombo);
    		
    		long nextPossibilites = (possiblilities.get(nextNum)==null?0:possiblilities.get(nextNum))+1;
    		
    		possiblilities.put(nextNum,nextPossibilites);
    	}
    	return triplets;
    }

    public static void main(String[] args) throws IOException {
        //BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nr = "6 5".replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nr[0]);

        long r = Long.parseLong(nr[1]);

        List<Long> arr = Stream.of("1 5 5 25 125 625".replaceAll("\\s+$", "").split(" "))
            .map(Long::parseLong)
            .collect(toList());

        long ans = countTriplets(arr, r);

        //"1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1"
        //expected = 161700
        /*bufferedWriter.write(String.valueOf(ans));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();*/
    }
}

///////////////////////////////
/*As a base consider a triplet made up of numbers A,B and C (where B = A* r and C = A* r * r = B* r).

For each value (say X) in the array, you have to consider that X may be an A, B and/or C in some triplet.

When can X be a middle of a triplet (that is case X = B in the triplet)? -> when I already have had one or more previous values which will fulfill 
the requirements of A for this B. 
So we need to check if there are any previous A's "waiting" for this B. Here we just check the map mentioned in the previous comment.
If there's any that means that we need to consider how many A's are "waiting" to know how many 2/3 complete triplets we'd now have with this X.

Similarly to the previous comment we will then let future Cs know that we have these extra 2/3 triplets ready.
So store in map of almost complete triplets (ensuring that we add to any previous ones already stored). This is the second part of the loop.

Final case, when X completes one or more previously 2/3 complete triplets. 
Simply check how many (if any incomplete triplets) are "waiting" for this value to become complete. So check the map of 2/3 triplets and accumulate the result.

In any case X can be an A of a future triplet so add it to the map2 so future B's know of this A's existence -> Final part of the loop.*/

