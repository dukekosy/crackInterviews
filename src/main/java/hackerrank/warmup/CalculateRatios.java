package hackerrank.warmup;

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
import java.util.concurrent.atomic.AtomicInteger;

class CalculateRatiosResult {

    /*
     * Complete the 'plusMinus' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void plusMinus(List<Integer> arr) {
        // Write your code here
         List<Integer> counts = new ArrayList<Integer>();
         counts.add(0);
         counts.add(0);
         counts.add(0);
        arr.stream().forEach(x -> {
            if(x > 0)
                counts.add(0, counts.get(0) + 1);
            else if(x < 0)
                counts.add(1, counts.get(1) + 1);
            else
                counts.add(2, counts.get(2) + 1);
        });
        System.out.println(counts);
        System.out.format("%.6f\n",(double)counts.get(0)/arr.size());
        System.out.format("%.6f\n",(double)counts.get(1)/arr.size());
        System.out.format("%.6f\n",(double)counts.get(1)/arr.size());
    }

    public static void plusMinusAtomic(List<Integer> arr) {
        // Write your code here
        AtomicInteger minusOne = new AtomicInteger(0);
        AtomicInteger zero = new AtomicInteger(0);
        AtomicInteger plusOne = new AtomicInteger(0);

        arr.stream().forEach(x -> {
            if(x > 0)
                minusOne.getAndIncrement();
            else if(x < 0)
                zero.getAndIncrement();
            else
                plusOne.incrementAndGet();
        });

        System.out.format("%.6f\n",(double)minusOne.get()/arr.size());
        System.out.format("%.6f\n",(double)zero.get()/arr.size());
        System.out.format("%.6f\n",(double)plusOne.get()/arr.size());
    }
}
public class CalculateRatios {
    public static void main(String[] args) throws IOException {
        List<Integer> arr = Arrays.asList(-1, -1, 0, 1, 1);
        CalculateRatiosResult.plusMinusAtomic(arr);
    }
}
