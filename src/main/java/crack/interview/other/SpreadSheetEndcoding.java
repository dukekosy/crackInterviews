package crack.interview.other;

/**
 * Encode spreadsheet letters to numbers
 * <p>
 * assumption: this is a one time process, no need of any caching of data
 * </p>
 */
public class SpreadSheetEndcoding {

  public static void main(String[] args) {
    System.out.println(encodeSpreadSheetLetters("A"));
    System.out.println(encodeSpreadSheetLetters("ABZ"));
    System.out.println(encodeSpreadSheetLetters("AA"));
    System.out.println(encodeSpreadSheetLetters("BAZ"));

  }

  private static int encodeSpreadSheetLetters(String column) {
    int total = 0;
    int n = column.length();
    int numericValueOfA = Character.getNumericValue('A');
    for (int i = 0; i < n; i++) {
    //the assumption here is that this is a one-time calculation
      total += Math.pow(26, n - i - 1) * (Character.getNumericValue(column.charAt(i)) - numericValueOfA + 1);
    }
    return total;
  }
}
