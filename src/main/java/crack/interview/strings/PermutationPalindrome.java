package crack.interview.strings;

/*


 * @author Kosala
 * The program check whethers the string is permuation of a parlindrome.
 *
 * assumption: characters represent only alphabet

Madam
Damam
Lol
look
kosala

4 swap until ex if it's a Palin. All swap possibleite rare checked. 

Two pairs of each char even length mod 2 = 0
Odd two pairs mod 2 = 0 and 1 can be mod 2 = 1
[] counter++ 
[] --counter
Add lot. If result is -1 for odd l or 0 for even length palindrome

check if I have two odd numbers
4 s [] counter++
4 [] if (count == 1) (old true) if count == 1 twice return false else true
*/
public class PermutationPalindrome {

    private static boolean isPermutationOfAParlindrom(String s) {
        char[] sc = s.toCharArray();
        int[] alphabet = getCounts(sc);

        int oneCounted = 0;
        for (int count : alphabet) {
            if (count % 2 == 1)
                oneCounted++;
            if (oneCounted > 1)
                return false;
        }
        return true;
    }

    private static int[] getCounts(char[] sc) {
        int[] alphabet = new int[26];
        int a = Character.getNumericValue('a');
        for (char c : sc) {
            int thisChar = Character.getNumericValue(c) - a;
            if (thisChar < 0)
                continue;
            alphabet[thisChar]++;
        }
        return alphabet;
    }

    public static void main(String[] args) {

        System.out.println(isPermutationOfAParlindrom("Tact  !!CAAoaa"));
        System.out.println(isPermutationOfAParlindrom("Tact  !!CAAoa"));
        System.out.println(isPermutationOfAParlindrom("dam dam"));
        System.out.println(isPermutationOfAParlindrom("dam dramr"));
        System.out.println(isPermutationOfAParlindrom("Tact dfffeeewfd !!CAAoa"));

        System.out.println(isPermutationOfAParlindrom("maamd"));
        System.out.println(isPermutationOfAParlindrom("llo"));
        System.out.println(isPermutationOfAParlindrom("ooll"));
        System.out.println(isPermutationOfAParlindrom("oollsdr"));


    }

}
