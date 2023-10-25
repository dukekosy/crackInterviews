package hackerrank.arrays;

import java.io.IOException;
import java.util.Scanner;

public class LowestCommonSequence {

  // Complete the commonChild function below.
  static int commonChild(String s1, String s2) {

    return LCS(s1.toCharArray(), s2.toCharArray(), s1.length(), s2.length());
  }

  static int LCS(char[] s1, char[] s2, int m, int n) {
    int[][] memo = new int[m+1][n+1];
    for(int i = 1; i <= m; i++) {
      for(int j = 1; j <= n; j++) {
        if (i <= 0 || j <= 0)
          memo[i][j] = 0;
        if (s1[i-1] == s2[j-1])
          memo[i][j] = 1 + memo[i-1][j-1];
        else
          memo[i][j] = Math.max( memo[i-1][j], memo[i][j-1]);
      }
    }
    return memo[m][n];
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {

    String s1 = scanner.nextLine();

    String s2 = scanner.nextLine();

    int result = commonChild(s1, s2);


    scanner.close();
  }
}
