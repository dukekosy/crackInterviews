package hackerrank.arrays;

import java.io.IOException;
import java.util.Scanner;

public class ArrayManipulation {

  private static final Scanner scanner = new Scanner(System.in);
/*
This is the newer array manipulation question. I can't find the older one

Starting with a 1-indexed array of zeros and a list of operations,
for each operation add a value to each the array element between two given indices,
 inclusive. Once all operations have been performed, return the maximum value in the array.

Example
n = 10
queries = [[1 5 3]],
    [4 8 7],
    [6 9 1]]
Queries are interpreted as follows:

    a b k
    1 5 3
    4 8 7
    6 9 1
Add the values of  between the indices  and  inclusive:

index->	 1 2 3  4  5 6 7 8 9 10
	[0,0,0, 0, 0,0,0,0,0, 0]
	[3,3,3, 3, 3,0,0,0,0, 0]
	[3,3,3,10,10,7,7,7,0, 0]
	[3,3,3,10,10,8,8,8,1, 0]


 */
  // Complete the arrayManipulation function below.
  static long arrayManipulation(int n, int[][] queries) {

    long outputArray[] = new long[n + 2];
    for (int i = 0; i < queries.length; i++) {
      int a = queries[i][0];
      int b = queries[i][1];
      int k = queries[i][2];
      outputArray[a] += k;
      outputArray[b + 1] -= k;
    }
    long max = getMax(outputArray);
    return max;
  }

  private static long getMax(long[] inputArray) {
    long max = Long.MIN_VALUE;
    long sum = 0;
    for (int i = 0; i < inputArray.length; i++) {
      sum += inputArray[i];
      max = Math.max(max, sum);
    }
    return max;
  }

  public static void main(String[] args) throws IOException {
    //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    String[] nm = scanner.nextLine().split(" ");

    int n = Integer.parseInt(nm[0]);

    int m = Integer.parseInt(nm[1]);

    int[][] queries = new int[m][3];

    for (int i = 0; i < m; i++) {
      String[] queriesRowItems = scanner.nextLine().split(" ");
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      for (int j = 0; j < 3; j++) {
        int queriesItem = Integer.parseInt(queriesRowItems[j]);
        queries[i][j] = queriesItem;
      }
    }

    long result = arrayManipulation(n, queries);

      /*bufferedWriter.write(String.valueOf(result));
      bufferedWriter.newLine();

      bufferedWriter.close();
*/
    scanner.close();
  }

}
