package hackerrank.warmup;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'diagonalDifference' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY arr as parameter.
     */

    public static int diagonalDifference(List<List<Integer>> arr) {
        // Write your code here
        //
        /*int start = 0;
        int end = arr.size() - 1;
        int sum = 0;
        for(List<Integer> x: arr) {
            sum = sum + x.get(start) - x.get(end);
            start++;
            end--;
        }
        return Math.abs(sum);*/

        AtomicInteger start = new AtomicInteger(0);
        AtomicInteger end = new AtomicInteger(arr.size()-1);
        AtomicInteger sum = new AtomicInteger(0);
        arr.forEach(x-> {
            sum.getAndAdd(x.get(start.get()) - x.get(end.get()) );
            start.getAndIncrement();
            end.getAndDecrement();
            }
        );
    return sum.get();
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, 3).forEach(i ->
                arr.add(Arrays.asList(1,2,3)));

        System.out.println(Result.diagonalDifference(arr));

    }
}
