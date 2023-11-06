package interviews;

import java.util.Arrays;

public class StringCompare {

    public static boolean compareStrings(String s1, String s2) {
        return s1.compareTo(s2) >=0 ? false : true;
    }

    public static void main(String[] args) {
        System.out.println(StringCompare.compareStrings("TODAY", "TOMORROW"));
    }
}
