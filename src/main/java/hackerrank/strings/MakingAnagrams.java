package hackerrank.strings;

/*
https://www.hackerrank.com/challenges/ctci-making-anagrams/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B
%5D=strings

 A student is taking a cryptography class and has found anagrams to be very useful. Two strings are anagrams of each other if the first string's
 letters can be rearranged to form the second string. In other words, both strings must contain the same exact letters in the same exact frequency.
  For example, bacdc and dcbac are anagrams, but bacdc and dcbad are not.

The student decides on an encryption scheme that involves two large strings. The encryption is dependent on the minimum number of character
deletions required to make the two strings anagrams. Determine this number.

Given two strings,  and , that may or may not be of the same length, determine the minimum number of character deletions required to make  and
anagrams. Any characters can be deleted from either of the strings.

Example


Delete  from  and  from  so that the remaining strings are  and  which are anagrams. This takes  character deletions.

Function Description

Complete the makeAnagram function in the editor below.

makeAnagram has the following parameter(s):

string a: a string
string b: another string
Returns

int: the minimum total characters that must be deleted
Input Format

The first line contains a single string, .
The second line contains a single string, .

Constraints

The strings  and  consist of lowercase English alphabetic letters, ascii[a-z].
Sample Input

cde
abc
Sample Output

4
Explanation

Delete the following characters from the strings make them anagrams:

Remove d and e from cde to get c.
Remove a and b from abc to get c.
It takes  deletions to make both strings anagrams.*/

import java.io.IOException;
import java.util.Scanner;

public class MakingAnagrams {

  private static final Scanner scanner = new Scanner(System.in);

  // Complete the makeAnagram function below.
  static int makeAnagram(String a, String b) {
    int[] aArray = returnArray(a);
    int[] bArray = returnArray(b);
    int counter = 0;
    for (int i = 0; i < aArray.length; i++) {
      counter = counter + Math.abs(aArray[i] - bArray[i]);
    }

    return counter;
  }

  static int[] returnArray(String a) {
    int[] array = new int[28];
    for (int i = 0; i < a.length(); i++) {
      System.out.println();
      array[Character.getNumericValue(a.charAt(i)) - Character.getNumericValue('a')]++;
    }
    return array;
  }

  public static void main(String[] args) throws IOException {
    //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    String a = scanner.nextLine();

    String b = scanner.nextLine();

    int res = makeAnagram(a, b);

    /*bufferedWriter.write(String.valueOf(res));
    bufferedWriter.newLine();

    bufferedWriter.close();*/

    scanner.close();
  }

}
