package hackerrank.strings;
/*
https://www.hackerrank.com/challenges/special-palindrome-again/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs
%5B%5D=strings

A string is said to be a special string if either of two conditions is met:

All of the characters are the same, e.g. aaa.
All characters except the middle one are the same, e.g. aadaa.
A special substring is any substring of a string which meets one of those criteria. Given a string, determine how many special substrings can be
formed from it.

For example, given the string , we have the following special substrings: .

Function Description

Complete the substrCount function in the editor below. It should return an integer representing the number of special substrings that can be formed
 from the given string.

substrCount has the following parameter(s):

n: an integer, the length of string s
s: a string
Input Format

The first line contains an integer, , the length of .
The second line contains the string .

Constraints


Each character of the string is a lowercase alphabet, .

Output Format

Print a single line containing the count of total special substrings.

Sample Input 0

5
asasd
Sample Output 0

7
Explanation 0

The special palindromic substrings of  are

Sample Input 1

7
abcbaba
Sample Output 1

10
Explanation 1

The special palindromic substrings of  are

Sample Input 2

4
aaaa
Sample Output 2

10
Explanation 2

The special palindromic substrings of  are

Welcome to the dark side!
*/

import java.io.IOException;
import java.util.Scanner;

public class SpecialStringAgain {

  private static final Scanner scanner = new Scanner(System.in);

  // Complete the substrCount function below.
  static long substrCount(int n, String s) {
    long ans = s.length();
    for(int i = 0; i<s.length(); i++) {
      int repeat = 0;
      while(i+1<s.length() && s.charAt(i)==s.charAt(i+1))
      {
        repeat++;
        i++;
      }
      ans+=(repeat* (repeat+1))/2;

      int pointer=1;
      while(i-pointer>=0 && i+pointer<s.length() && s.charAt(i+pointer) == s.charAt(i-1) && s.charAt(i-pointer)==s.charAt(i-1)) {
        ans++;
        pointer++;
      }
    }
    return ans;

  }


  public static void main(String[] args) throws IOException {
    //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int n = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    String s = scanner.nextLine();

    long result = substrCount(n, s);

   /* bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedWriter.close();*/

    scanner.close();
  }

}
