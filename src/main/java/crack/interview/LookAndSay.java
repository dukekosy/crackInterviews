package crack.interview;

public class LookAndSay {

  public static void main(String[] args) {

    System.out.println(lookAndSay(1));
    System.out.println(lookAndSay(2));
    System.out.println(lookAndSay(3));
    System.out.println(lookAndSay(4));
    System.out.println(lookAndSay(5));
    System.out.println(lookAndSay(6));
    System.out.println(lookAndSay(7));
    System.out.println(lookAndSay(8));
    /*
    1
    11
    21
    1211
    111221
    312211
    13112221
    1113213211
    */
  }

  private static String lookAndSay(int n) {
    return constructNewNumberRecursivly("1", n, 0);
  }

  private static String constructNewNumberRecursivly(String val, int n, int i) {
    i++;
    int repeat = 1;
    String newString = null;
    if (i < n) {
      for (int j = 0; j < val.length(); j++) {

        while (j + 1 < val.length() && val.charAt(j) == val.charAt(j + 1)) {
          repeat++;
          j++;
        }
        if (newString == null) {
          newString = String.valueOf(repeat) + val.charAt(j);
        } else {
          newString += String.valueOf(repeat) + val.charAt(j);
        }
        repeat = 1;
      }
      return constructNewNumberRecursivly(newString, n, i);
    } else {
      return val;
    }
  }
}
