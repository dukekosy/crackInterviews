package crack.interview.arrays;

/**
 *
 * @author Menuka
 * The prorame check whether the string is permuation of a parlindrome.
 *
 * assumption: characters represent only alphabet
 */
/*public class Permutation1_4 {

  public static void main(String[] args) {

    System.out.println(isPermutationOfAParlindrom("Tact  !!CAAoa"));
    System.out.println(isPermutationOfAParlindrom("Tact  !!CAAoa"));
    System.out.println(isPermutationOfAParlindrom("damdam"));
    System.out.println(isPermutationOfAParlindrom("dam dramr"));
    System.out.println(isPermutationOfAParlindrom("Tact dfffeeewfd !!CAAoa"));
    System.out.println(isPermutationOfAParlindrom("Tact  !!CAAoa5547"));

  }

  private static boolean isPermutationOfAParlindrom(String tact_coa) {

    int[] arr = new int[26];
    for (int i = 0; i < tact_coa.length(); i++) {
      int index = Character.getNumericValue(tact_coa.charAt(i)) - Character.getNumericValue('a');
      //skip the space

      if (index < 0) { //ignore anything that is not a valid character
        continue;
      }
      arr[index]++;

    }
    int odd = 0;
    for (int i = 0; i < arr.length; i++) {
    // if you have two odd numbers it's not a palindrom
      if (arr[i] % 2 == 1)
        odd++;
      if (odd == 2)
          return false;
    }
    return true;
  }

}*/
public class Permutation1_4 {

    private static boolean isPermutationOfAParlindrom(String string) {
        int odd = 0;
        Integer[] index = new Integer[26];

        //creater array of counters of alphabet in numberical form
        for(int i=0; i<string.length(); i++) {
            Integer num = Character.getNumericValue(string.charAt(i)) - Character.getNumericValue('a');
            if (num<0)
                continue;
            if (index[num] == null)
                index[num] = 0;
            index[num]++;
        }
        //count the number of odd characters of the alphabets counted above
        for(Integer integer: index) {
            if (integer != null && integer % 2 == 1)
                odd++;
            if (odd == 2) //palindrom shouldn't have two odd chars of the alphabet
                return false;
        }
        return true;
    }

    public static void main(String[] args) {

        check("madam", true, 1);
        check("maddam", true, 2);
        check("madram", false, 3);
        check("Tact  !!CAAoa", true, 4);
        check("Tact  !!CAAoa", true, 5);
        check("damdam", true, 6);
        check("dam dramr", true, 7);
        check("Tact dfffeeewfd !!CAAoa", false, 8);
        check("Tact  !!CAAoa5547", true, 9);

    }

    static void check(String string, boolean expected, int test_case_number) {

        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (isPermutationOfAParlindrom("madam"))
            System.out.println(rightTick + " Test #" + test_case_number);
        else
            System.out.println(wrongTick + " Test #" + test_case_number + ": Expected ");


    }
}