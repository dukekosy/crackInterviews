package crack.interview.collections.hashtables;

// Add any extra import statements you may need here

/*

Pair Sums
Given a list of n integers arr[0..(n-1)], determine the number of different pairs of elements within it which sum to k.
If an integer appears in the list multiple times, each copy is considered to be different; that is, two pairs are considered different
 if one pair includes at least one array index which the other doesn't, even if they include the same values.
Signature
int numberOfWays(int[] arr, int k)
Input
n is in the range [1, 100,000].
Each value arr[i] is in the range [1, 1,000,000,000].
k is in the range [1, 1,000,000,000].
Output
Return the number of different pairs of elements which sum to k.
Example 1
n = 5
k = 6
arr = [1, 2, 3, 4, 3]
output = 2
The valid pairs are 2+4 and 3+3.
Example 2
n = 5
k = 6
arr = [1, 5, 3, 3, 3]
output = 4
There's one valid pair 1+5, and three different valid pairs 3+3 (the 3rd and 4th elements, 3rd and 5th elements, and 4th and 5th elements).
 */
class FBPairSums {

    // Add any helper functions you may need here
  /*

1)  4 arr[i]
        4 arr[j]
          + if k pairs++

 2) 4 countPresent[arr[i]]++ [0, 1, 1, 2, 1]
      boolean present k-arr[i] [0, 1, 2t, 3t, 4t, 5t]
    4 present if true and k-i is in arr[i] ==1 pair++ if arr[i] >1 pair += arr[i]
       2t 1 pair++

  */

    int numberOfWays(int[] arr, int k) {
        // Write your code here
        int[] countPresent = new int[100000];
        //k = 6
        for (int i : arr) { //{1, 2, 3, 4, 3}
            countPresent[i]++; //[(0)0, (1)1, (2)1, (3)2, (4)1]
        }
        int pair = 0;
        int pair2 = 0;
        for (int i : arr) {
            if (i != k / 2) {
                //6-4 = 2 and 6-2 = 4
                // pair += number of times it is present
                // so pair = 2/2. a pair will always show up twice
                pair += countPresent[k - i];//[(6-1)5, (6-2)4, (6-3)3, (6-4)2, (6-3)3]
            } else { // this is used for numbers equal to k/2 only
                int w = countPresent[k - i];
                pair2 = (w * (w - 1)) / 2;
            }//3 = 0 // 3 3 = 1  // 3 3 3 = 4 // 3 3 3 3 = 6 // 3 3 3 3 3 = 10 // 3 3 3 3 3 3 = 15
        }//[0, (2+4)1, (3+3)2, (2+4)1, (3+3)2] 6/2  w*(w-1)/2  3* 3-1/2= 3
//2+3)/2 = 2
        return pair / 2 + pair2;

    }


    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom, but they are otherwise not editable!




    void check(int[] array, int k, int expected, int test_case_number) {
        char rightTick = '\u2713';
        char wrongTick = '\u2717';

        if (numberOfWays(array, k) == expected)
            System.out.println(rightTick + " Test #" + test_case_number);
        else
            System.out.println(wrongTick + " Test #" + test_case_number + ": Expected ");
    }

    void printInteger(int n) {
        System.out.print("[" + n + "]");
    }

    public void run() {

        check(new int[]{1, 2, 2, 3, 3, 4, 3}, 6, 5, 1);
        check(new int[]{1, 2, 2, 3, 4, 3}, 6, 3, 2);
        check(new int[]{1, 5, 3, 3, 3}, 6, 4, 3);
        check(new int[]{0, 1, 2, 2, 3, 4, 3}, 6, 3, 4);
        check(new int[]{0, 6, 6, 1, 2, 2, 3, 4, 3}, 6, 5, 5);

    }

    public static void main(String[] args) {
        new FBPairSums().run();
    }
}