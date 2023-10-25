package hackerrank.sorting;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/*https://www.hackerrank.com/challenges/ctci-merge-sort/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D
=sorting*/

//note make sure you use a long to track the swaps or you run out of integer size.

public class MergeSortCountingInversions {

  private static final Scanner scanner = new Scanner(System.in);

  // Complete the countInversions function below.
  static long countInversions(int[] arr) {
    return mergeSortAndCount(arr, 0, arr.length - 1);
  }

  // Function to count the number of inversions
  // during the merge process
  private static long mergeAndCount(int[] arr, int l, int m, int r) {

    // Left subarray
    int[] left = Arrays.copyOfRange(arr, l, m + 1);

    // Right subarray
    int[] right = Arrays.copyOfRange(arr, m + 1, r + 1);

    int i = 0, j = 0, k = l;
    long swaps = 0;

    while (i < left.length && j < right.length) {
      if (left[i] <= right[j]) { arr[k++] = left[i++]; } else {
        arr[k++] = right[j++];
        swaps += (m + 1) - (l + i);
      }
    }

    while (i < left.length) {
      arr[k] = left[i];
      i++;
      k++;
    }

    while (j < right.length) {
      arr[k] = right[j];
      j++; //xxx not i
      k++;
    }
    return swaps;
  }

  // Merge sort function
  private static long mergeSortAndCount(int[] arr, int l, int r) {

    // Keeps track of the inversion count at a
    // particular node of the recursion tree
    long count = 0;

    if (l < r) {
      int m = (l + r) / 2;

      // Total inversion count = left subarray count
      // + right subarray count + merge count

      // Left subarray count
      count += mergeSortAndCount(arr, l, m);

      // Right subarray count
      count += mergeSortAndCount(arr, m + 1, r);

      // Merge count
      count += mergeAndCount(arr, l, m, r);
    }

    return count;
  }

  public static void main(String[] args) throws IOException {
    //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int t = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int tItr = 0; tItr < t; tItr++) {
      int n = scanner.nextInt();
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      int[] arr = new int[n];

      String[] arrItems = scanner.nextLine().split(" ");
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      for (int i = 0; i < n; i++) {
        int arrItem = Integer.parseInt(arrItems[i]);
        arr[i] = arrItem;
      }

      long result = countInversions(arr);
      System.out.println("");
      /*bufferedWriter.write(String.valueOf(result));
      bufferedWriter.newLine();*/
    }

    //bufferedWriter.close();

    scanner.close();
  }

}
