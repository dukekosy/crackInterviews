package hackerrank.strings;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
https://www.hackerrank.com/challenges/alternating-characters/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B
%5D=strings

You are given a string containing characters  and  only. Your task is to change it into a string such that there are no matching adjacent
characters. To do this, you are allowed to delete zero or more characters in the string.

Your task is to find the minimum number of required deletions.

Example

Remove an  at positions  and  to make  in  deletions.

Function Description

Complete the alternatingCharacters function in the editor below.

alternatingCharacters has the following parameter(s):

string s: a string
Returns

int: the minimum number of deletions required
Input Format

The first line contains an integer , the number of queries.
The next  lines each contain a string  to analyze.

Constraints

Each string  will consist only of characters  and .
Sample Input

5
AAAA
BBBBB
ABABABAB
BABABA
AAABBB
Sample Output

3
4
0
0
4
Explanation

The characters marked red are the ones that can be deleted so that the string does not have matching adjacent characters.

image
*/
public class AlternateCharacters {

  private static final Scanner scanner = new Scanner(System.in);

  // Complete the alternatingCharacters function below.
  static int alternatingCharacters(String s) {
      // simpler way to do this
      char currentChar = ' ';
      int counter = 0;

      for (int i = 0; i < s.length(); i++) {
          if (i == 0) {
              currentChar = s.charAt(0);
              continue;
          }

          if (currentChar == s.charAt(i)) {
              counter++;
          } else {
              currentChar = s.charAt(i);
          }
      }
      return counter;
  }
  /*static int alternatingCharacters(String s) {
    int[] array = new int[s.length() + 1];
    char currentChar = 'Z';
    int counter = 0;
    for(int i: array) {
      //String::charAt;
    }
    for (int i = 0; i < s.length(); i++) {
      if (currentChar == s.charAt(i)) {
        array[counter]++;
      } else {
        currentChar = s.charAt(i);
        counter++;
        array[counter] = 1;
      }
    }
    int add = 0;
    for (int j : array) {
      add += j;
    }
    return add - counter;
  }*/

  public static void main(String[] args) {
    //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
    List<String> lines = new ArrayList<String>();
    lines.add("AAAA");
    lines.add("BBBBB");
    lines.add("ABABABAB");
    lines.add("BABABA");
    lines.add("AAABBB)");

    for (String s: lines) {

        System.out.println(alternatingCharacters(s));

    }

    /* bufferedWriter.close();
     */
    scanner.close();
  }

}
