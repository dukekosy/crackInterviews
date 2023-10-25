package hackerrank.arrays;
/*
https://www.hackerrank.com/challenges/ctci-array-left-rotation/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs
%5B%5D=arrays

A left rotation operation on an array shifts each of the array's elements  unit to the left. For example, if  left rotations are performed on array
 , then the array would become . Note that the lowest index item moves to the highest index in a rotation. This is called a circular array.

Given an array  of  integers and a number, , perform  left rotations on the array. Return the updated array to be printed as a single line of
space-separated integers.

Function Description

Complete the function rotLeft in the editor below.

rotLeft has the following parameter(s):

int a[n]: the array to rotate
int d: the number of rotations
Returns

int a'[n]: the rotated array
Input Format

The first line contains two space-separated integers  and , the size of  and the number of left rotations.
The second line contains  space-separated integers, each an .

Constraints

Sample Input

5 4
1 2 3 4 5
Sample Output

5 1 2 3 4
Explanation

When we perform  left rotations, the array undergoes the following sequence of changes:
*/

import java.io.IOException;
import java.util.Scanner;

public class LeftRotation {

  private static final Scanner scanner = new Scanner(System.in);

  // Complete the rotLeft function below.
  static int[] rotLeft(int[] a, int d) {
    if (a.length == d) { return a; }
    int[] b = new int[a.length];
    b[0] = a[d]; // what's in the dth element ends in the front
    int counter = 0;
    for (int i = d + 1; i < a.length; i++) {
      b[i - d] = a[i];
      counter++;
    }
    for (int j = 0; j < d; j++) {
      b[++counter] = a[j];
    }

    return b;
  }

  public static void main(String[] args) throws IOException {
    //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    String[] nd = scanner.nextLine().split(" ");

    int n = Integer.parseInt(nd[0]);

    int d = Integer.parseInt(nd[1]);

    int[] a = new int[n];

    String[] aItems = scanner.nextLine().split(" ");
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int i = 0; i < n; i++) {
      int aItem = Integer.parseInt(aItems[i]);
      a[i] = aItem;
    }

    int[] result = rotLeft(a, d);

   /* for (int i = 0; i < result.length; i++) {
      bufferedWriter.write(String.valueOf(result[i]));

      if (i != result.length - 1) {
        bufferedWriter.write(" ");
      }
    }

    bufferedWriter.newLine();

    bufferedWriter.close();*/

    scanner.close();
  }

}
