package hackerrank.dynamicprogramming;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class MaxArraySum {
//https://www.hackerrank.com/challenges/max-array-sum/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dynamic-programming
    private static int max = 0;
    // Complete the maxSubsetSum function below.
    static int maxSubsetSum(int[] arr) {
        int[] x = new int[arr.length];

        //x[0] = arr[0]
        //x[1] = max(arr[1], x[0]);
        //x[2] = max(arr[i] + x[i-2], x[i-1], arr[i]);

        x[0] = arr[0];
        x[1] = Math.max(arr[1], x[0]);

        for(int i=2; i<arr.length; i++) {
            x[i] = Math.max(Math.max(arr[i] + x[i-2], x[i-1]), arr[i]);
        }


        return Math.max(Math.max(arr[arr.length-1] + x[arr.length-1-2], x[arr.length-1-1]), arr[arr.length-1]);
    }


    public static void main(String[] args) throws IOException {

        System.out.println(maxSubsetSum(new int[]{3, 7, 4, 6, 5})==13);
        System.out.println(maxSubsetSum(new int[]{2, 1, 5, 8, 4})==11);
        System.out.println(maxSubsetSum(new int[]{3, 5, -7, 8, 10})==15);

    }
}
