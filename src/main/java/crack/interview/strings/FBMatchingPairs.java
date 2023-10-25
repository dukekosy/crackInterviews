package crack.interview.strings;

// Add any extra import statements you may need here

/*Matching Pairs
Given two strings s and t of length N, find the maximum number of possible matching pairs in strings s and t after swapping exactly two characters within s.
A swap is switching s[i] and s[j], where s[i] and s[j] denotes the character that is present at the ith and jth index of s, respectively. The matching pairs of the two strings are defined as the number of indices for which s[i] and t[i] are equal.
Note: This means you must swap two characters at different indices.
Signature
int matchingPairs(String s, String t)
Input
s and t are strings of length N
N is between 2 and 1,000,000
Output
Return an integer denoting the maximum number of matching pairs
Example 1
s = "abcd"
t = "adcb"
output = 4
Explanation:
Using 0-based indexing, and with i = 1 and j = 3, s[1] and s[3] can be swapped, making it  "adcb".
Therefore, the number of matching pairs of s and t will be 4.
Example 2
s = "mno"
t = "mno"
output = 1
Explanation:
Two indices have to be swapped, regardless of which two it is, only one letter will remain the same. If i = 0 and j=1, s[0] and s[1] are swapped, making s = "nmo", which shares only "o" with t.

        Run

        Java

        Instructions

*/

//for swap i and j, inside for loop, run for checking how many have changed
//for replace characters with numbers, for loop and swap, inside for loop to - numbers, 0
//for swapping i and j,
//for loop and ths is only once, check what is the same in the string and not and mark them in an array of 1, 0
//avoid swapping 1s, swap only 0s. only need to check the ones that are swapped. no loop there.

//another approach. you can count all the common chars first. then you can get only 2 more to equal by swapping.
//looking at only the unmatching values in s and t
//check only values in s[i] in t[j]. then look for second value in s that matches t
//if one count++ else count+2 if not count remains the same

/*
The faster way down later
1) counter matching pairs and put non matching values into two StringBuffers of s and t
2) go through s_SB and mark present in array.
3) go through t_SB and if present in array counter++
4) if two are counted exit.
 */
class FBMatchingPairs {

    // Add any helper functions you may need here
    // array is binary showing matcching pair locations, counter is the number of naturally pairs.
    private int compareCharacters(String s, String t, int[] array, int counter) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (array[i] == 1) {
                continue;
            }
            // coz of the continue we're only looking at non matching pairs now.
            int jCounter = counter;
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(i) == t.charAt(j)) {
                    jCounter++;
                }
                if (s.charAt(j) == t.charAt(i)) {
                    jCounter++;
                }
            }
            if (result < jCounter) {
                result = jCounter;
            }
        }
        return result;
    }

    private int matchingPairs(String s, String t) {
        // Write your code here
        if (s.equals(t)) {
            return s.length() - 2;
        }
        int counter = 0;
        int[] array = new int[s.length()];
        // put a 1 where they match and a 0 where they don't to mark matching pairs
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == t.charAt(i)) {
                array[i] = 1;
                counter++;
            } else {
                array[i] = 0;
            }
        }
        return compareCharacters(s, t, array, counter);
    }

    private int matchingPairsFaster(String s, String t) {
        // Write your code here
        if (s.equals(t)) {
            return s.length() - 2;
        }
        int counter = 0;
        StringBuilder sBuilder = new StringBuilder();
        StringBuilder tBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == t.charAt(i)) {
                counter++; //count only matching characters
            } else {//create strings from the others
                sBuilder.append(s.charAt(i));
                tBuilder.append(t.charAt(i));
            }
        }
        return compareCharactersFaster(sBuilder.toString(), tBuilder.toString(), counter);
    }

    private int compareCharactersFaster(String s, String t, int counter) {
        boolean[] array = new boolean[128];
        int initialCounter = counter;

        for (int i = 0; i < s.length(); i++) {
            // there is an integer value of each char here. to use as an index
            array[s.charAt(i)] = true; //marking those present in s
        }
        for (int i = 0; i < t.length(); i++) {
            if (counter == initialCounter + 2)
                return counter; //if two common chars are counted exit
            //as only one change is going to be made solution can be counter+1 or counter+2
            //we exit early for counter + 2 is found if not we have to go till the end of char in t
            if (array[t.charAt(i)]) {
                counter++;//if a char in t exist in s, count it.
            }
        }
        return counter;
    }

    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom, but they are otherwise not editable!
    private int test_case_number = 1;

    private void check(int expected, int output) {
        boolean result = (expected == output);
        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        } else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            printInteger(expected);
            System.out.print(" Your output: ");
            printInteger(output);
            System.out.println();
        }
        test_case_number++;
    }

    private void printInteger(int n) {
        System.out.print("[" + n + "]");
    }

    private void run() {
        String s_1 = "abcde";
        String t_1 = "adcbe";
        int expected_1 = 5;
        //int output_1 = matchingPairs(s_1, t_1);
        //check(expected_1, output_1);

        String s_2 = "abcd";
        String t_2 = "abcd";
        int expected_2 = 2;
        //int output_2 = matchingPairs(s_2, t_2);
        //check(expected_2, output_2);

        // Add your own test cases here
        String s_3 = "abcd";
        String t_3 = "ef%&";
        int expected_3 = 0;
        //int output_3 = matchingPairs(s_3, t_3);
        //check(expected_3, output_3);


        check(expected_1, matchingPairsFaster(s_1, t_1));
        //check(expected_2, matchingPairsFaster(s_2, t_2));
        //check(expected_3, matchingPairsFaster(s_3, t_3));
        //check(2, matchingPairsFaster("aaaaaa", "abbbbaaaaa"));
    }

    public static void main(String[] args) {
        new FBMatchingPairs().run();
    }
}