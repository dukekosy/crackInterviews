package crack.interview.strings;

// Add any extra import statements you may need here


class FBRotationalCipher {

    // Add any helper functions you may need here

    //1) for the string. if its alpha or num increase by n else stay the same. check for alpha using Character. keep hashmap of alpha hashmap of num

    //2) turn the whole string into numeric rep in for loop. add n to all values. convert them back to alpnum. keep char non alpnum char the.

    private String rotationalCipher(String input, int rotationFactor) {
        //rotate numbers
        StringBuilder sb = new StringBuilder();
        int a = (int) 'a'; // is same as Character.getNumericValue(a);
        for (int i = 0; i < input.length(); i++) {
            if (Character.getNumericValue(input.charAt(i)) == -1) {
                sb.append(input.charAt(i));
            } else if (Character.isDigit(input.charAt(i))) {
                sb.append((Character.getNumericValue(input.charAt(i)) + rotationFactor) % 10);
            } else {
                int rotated = ((int) Character.toLowerCase(input.charAt(i)) - a + rotationFactor) % 26;
                sb.append(
                        Character.isUpperCase(input.charAt(i)) ? Character.toUpperCase((char) (rotated + a)) : (char) (rotated + a)
                );
            }
        }
        return sb.toString();
    }


    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom, but they are otherwise not editable!
    private int test_case_number = 1;

    private void check(String expected, String output) {
        boolean result = (expected.equals(output));
        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        } else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            printString(expected);
            System.out.print(" Your output: ");
            printString(output);
            System.out.println();
        }
        test_case_number++;
    }

    private void printString(String str) {
        System.out.print("[\"" + str + "\"]");
    }

    private void run() {
        String input_1 = "All-convoYs-9-be:Alert1.";
        int rotationFactor_1 = 4;
        String expected_1 = "Epp-gsrzsCw-3-fi:Epivx5.";
        String output_1 = rotationalCipher(input_1, rotationFactor_1);
        check(expected_1, output_1);

        String input_2 = "abcdZXYzxy-999.@";
        int rotationFactor_2 = 200;
        String expected_2 = "stuvRPQrpq-999.@";
        String output_2 = rotationalCipher(input_2, rotationFactor_2);
        check(expected_2, output_2);

        // Add your own test cases here
        check("bcde", rotationalCipher("abcd", 1));
        check("!@#$%^&*()_+-={}[]|`~", rotationalCipher("!@#$%^&*()_+-={}[]|`~", 1));
        check("111aaa", rotationalCipher("000zzz", 1));
    }

    public static void main(String[] args) {
        new FBRotationalCipher().run();
    }
}