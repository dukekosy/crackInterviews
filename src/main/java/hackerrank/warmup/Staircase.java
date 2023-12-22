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

class StaircaseResult {

    /*
     * Complete the 'staircase' function below.
     *
     * The function accepts INTEGER n as parameter.
     */

    public static void staircase(int n) {
        // Write your code here
        StringBuilder sb = new StringBuilder();
        StringBuilder sbHash = new StringBuilder();
        IntStream.range(0, n).forEach(x ->
                                              sb.append(" ")
        );
        IntStream.range(0, n).forEach(x ->
                                              sbHash.append("#")
        );
        IntStream.range(1, n+1).forEach(x -> {
                                            System.out.print(sb.substring(0, n-x)
                                                               .concat(sbHash.substring(0, x)) + "\n");
                                        }
        );
    }

}

public class Staircase {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        StaircaseResult.staircase(n);

        bufferedReader.close();
    }
}