package crack.interview.arrays;

import java.util.Arrays;
// Add any extra import statements you may need here


class FBReverseToMakeEqual {

    // Add any helper functions you may need here
    //brute force is to keep reversing A and compare with B
    //A has the same Element as B, reversing multiple times would eventually equal them.

    //take the elements of A and count them in an array, take the element of B and removed them from the array.
    // total of the array = 0

    //order both arrays numerically. compare them

    //(scratch this one) totally everything in the array A and B will tell you if they have the same value.

    private boolean areTheyEqual(int[] array_a, int[] array_b) {
        // Write your code here
        Arrays.sort(array_a);
        Arrays.sort(array_b);
        return Arrays.equals(array_a, array_b);
    }


    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom, but they are otherwise not editable!
    private int test_case_number = 1;

    private void check(boolean expected, boolean output) {
        boolean result = (expected == output);
        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        } else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            System.out.print(expected);
            System.out.print(" Your output: ");
            System.out.print(output);
            System.out.println();
        }
        test_case_number++;
    }

    private void run() {
        int[] array_a_1 = {1, 2, 3, 4};
        int[] array_b_1 = {1, 4, 3, 2};
        boolean output_1 = areTheyEqual(array_a_1, array_b_1);
        check(true, output_1);

        int[] array_a_2 = {1, 2, 3, 4};
        int[] array_b_2 = {1, 4, 3, 3};
        boolean output_2 = areTheyEqual(array_a_2, array_b_2);
        check(false, output_2);
        // Add your own test cases here
        int[] array_a_3 = {1, 2, 3, 1000000000};
        int[] array_b_3 = {1, 2, 1000000000, 3};
        boolean output_3 = areTheyEqual(array_a_3, array_b_3);
        check(true, output_3);

        int[] array_a_4 = {1, 0, 3, 4};
        int[] array_b_4 = {1, 4, 0, 3};
        boolean output_4 = areTheyEqual(array_a_4, array_b_4);
        check(true, output_4);

        int[] array_a_5 = {1, 0, 3, 4, 1, 0, 3, 4, 1, 0, 3, 4, 1, 0, 3, 4, 1, 0, 3, 4, 1, 0, 3, 4, 1, 0, 3, 4, 1, 0, 3, 4, 1, 0, 3, 4, 1, 0, 3, 4, 1, 0, 3, 4, 1, 0, 3, 4, 1, 0, 3, 4, 1, 0, 3, 4, 1, 0, 3, 4, 1, 0, 3, 4, 1, 0, 3, 4, 1, 0, 3, 4, 1, 0, 3, 4, 1, 0, 3, 4, 1, 0, 3, 4,};
        int[] array_b_5 = {1, 4, 0, 3, 1, 4, 0, 3, 1, 4, 0, 3, 1, 4, 0, 3, 1, 4, 0, 3, 1, 4, 0, 3, 1, 4, 0, 3, 1, 4, 0, 3, 1, 4, 0, 3, 1, 4, 0, 3, 1, 4, 0, 3, 1, 4, 0, 3, 1, 4, 0, 3, 1, 4, 0, 3, 1, 4, 0, 3, 1, 4, 0, 3, 1, 4, 0, 3, 1, 4, 0, 3, 1, 4, 0, 3, 1, 4, 0, 3, 1, 4, 0, 3,};
        boolean output_5 = areTheyEqual(array_a_5, array_b_5);
        check(true, output_5);

    }

    public static void main(String[] args) {
        new FBReverseToMakeEqual().run();
    }
}