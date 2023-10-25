package crack.interview.arrays;

import java.util.ArrayList;
import java.util.List;

public class StringComparison1_6 {
/*
implement a methos to perform basi string compression using the counts of repeated characters.
For example, the string aabcccccaaa would become a2b1c5a3. If the compressed string is not smaller
than the original string, return the original string. Assume string has only upper and lowercase
letters.
 */
  public static void main(String[] args) {
    System.out.println("----------------------------------------------------");
    System.out.println(stringCompress("aabbccccccddef"));
    System.out.println(stringCompress("a"));
    System.out.println(stringCompress("aa"));
    System.out.println(stringCompress("abc"));

    System.out.println("----------------------------------------------------");

    List<String> strings = new ArrayList<String>(5);
    strings.add("aaabbbcc");
    strings.add("aaaaa");
    strings.add("aabbccccccddef");
    strings.add("a");
    strings.add("aa");
    strings.add("abc");

    for (String string : strings) {
      System.out.println(new Zip(string).compress());
    }
  }

  /**
   * @param word
   * @return
   * @author menuka
   */
  private static String stringCompress(String word) {

    int temp = 1;
    StringBuilder compressed = new StringBuilder();
    for (int i = 0; i < word.length(); i++) {
      char ch = word.charAt(i);
      while (i < word.length() - 1 && ch == word.charAt(i + 1)) {
        i++;
        temp++;
      }
      compressed.append(ch);
      compressed.append(temp);
      temp = 1;
    }
    return (compressed.length()) > word.length() ? word : compressed.toString();
  }


}

/**
 * @author kosala
 */
final class Zip {
  private final String s;

  Zip(String s) {
    this.s = s;
  }

  public final String compress() {
    char charAt = s.charAt(0);
    int counter = 1;
    StringBuffer sb = new StringBuffer(String.valueOf(charAt));
    for (int i = 1; i < s.length(); i++) {
      if (charAt == s.charAt(i))
        counter++; //note you don't append the counter if the next char is diff
      //so abc would turn up as abc
      else {
        if (counter > 1)
          sb.append(counter);
        counter = 1;
        charAt = s.charAt(i);
        sb.append(charAt);
      }
    }
    if (counter > 1)
      sb.append(counter);
    return sb.toString();
  }
}
