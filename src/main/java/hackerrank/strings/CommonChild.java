package hackerrank.strings;
/*
https://www.hackerrank.com/challenges/common-child/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=strings

A string is said to be a child of a another string if it can be formed by deleting 0 or more characters from the other string. Given two strings of equal length, what's the longest string that can be constructed such that it is a child of both?

For example, ABCD and ABDC have two children with maximum length 3, ABC and ABD. They can be formed by eliminating either the D or C from both strings. Note that we will not consider ABCD as a common child because we can't rearrange characters and ABCD  ABDC.

Function Description

Complete the commonChild function in the editor below. It should return the longest string which is a common child of the input strings.

commonChild has the following parameter(s):

s1, s2: two equal length strings
Input Format

There is one line with two space-separated strings,  and .

Constraints

All characters are upper case in the range ascii[A-Z].
Output Format

Print the length of the longest string , such that  is a child of both  and .

Sample Input

HARRY
SALLY
Sample Output

 2
Explanation

The longest string that can be formed by deleting zero or more characters from  and  is , whose length is 2.

Sample Input 1

AA
BB
Sample Output 1

0
Explanation 1

 and  have no characters in common and hence the output is 0.

Sample Input 2

SHINCHAN
NOHARAAA
Sample Output 2

3
Explanation 2

The longest string that can be formed between  and  while maintaining the order is .

Sample Input 3

ABCDEF
FBDAMN
Sample Output 3

2
Explanation 3
 is the longest child of the given strings.
 */

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Scanner;

public class CommonChild {

  // Complete the commonChild function below.
  static int commonChild(String s1, String s2) {

    return LCS(s1.toCharArray(), s2.toCharArray(), s1.length(), s2.length());
  }

  // not the right way to solve this problem using On squared
  /*static int LCS2(char[] s1, char[] s2, int m, int n) {
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
  }*/

  static int LCS(char[] s1, char[] s2, int i, int j) {
    if (i <= 0 || j <= 0)
      return 0;
    if (s1[i-1] == s2[j-1])
      return 1 + LCS(s1, s2, i-1, j-1);
    else
      return Math.max( LCS(s1, s2, i-1, j), LCS(s1, s2, i, j-1));
  }

  public static void main(String[] args) throws IOException {

      System.out.println(commonChild("ABCD", "ABDC")==3);
      System.out.println(commonChild("HARRY", "SALLY")==2);
      System.out.println(commonChild("AA", "BB")==0);
      System.out.println(commonChild("SHINCHAN", "NOHARAAA")==3);
      System.out.println(commonChild("ABCDEF", "FBDAMN")==2);
      System.out.println(commonChild("HARRY", "SALLY")==2);
      System.out.println(commonChild("HARRY", "SALLY")==2);

  }
}
