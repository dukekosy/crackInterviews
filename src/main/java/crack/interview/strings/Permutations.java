package crack.interview.strings;

/* check if one string is a permutation of another
 * https://www.youtube.com/watch?v=UDmz62Lt204&list=PL5tcWHG-UPH03aqnBTkBuH5qIbhshbg_K&index=7&t=0s
 * Assumption. string is only alphabetic chars
 * */

public class Permutations {

    public static void main(String[] args) {

        System.out.println(isPermutation("dog", "god"));
        System.out.println(isPermutation("abc", "abc"));
        System.out.println(isPermutation("lol", "oll"));
        System.out.println(isPermutation("aaa", "aaa"));
        System.out.println(isPermutation("aaa", "bbb"));
        System.out.println(isPermutation("bat", "sat"));
        System.out.println(isPermutation("dog", "gods"));
        System.out.println(isPermutation("dog", "go"));
        System.out.println(isPermutation("abc", "bbb"));

    }

    private static boolean isPermutation(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }
        int aNumericValue = Character.getNumericValue('a');
        char[] arrayA = a.toCharArray();
        char[] arrayB = b.toCharArray();
        int[] alphabet = new int[26];
        // count char into an array for 1st String
        for (char value : arrayA) {
            alphabet[Character.getNumericValue(value) - aNumericValue]++;
        }
        // remove from array for 2nd String if not zero
        for (char value : arrayB) {
            int c = Character.getNumericValue(value) - aNumericValue;
            //if (alphabet[c] != 0) {
                alphabet[c]--;
            //}
        }

        int counter = 0;
        for (int value : alphabet) {
            counter += value;
        }

        return counter == 0;

    }

}
