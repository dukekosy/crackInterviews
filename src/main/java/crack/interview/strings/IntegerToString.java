package crack.interview.strings;

import java.util.*;

/* turning an integer to a string without using existing conversion methods
 * https://www.youtube.com/watch?v=b0vKXjPJwkg&list=PL5tcWHG-UPH03aqnBTkBuH5qIbhshbg_K&index=9&t=0s*/
public class IntegerToString {

    public static void main(String[] args) {
        int[] array = {123, 3, 2, 1, 8909, 0, -1, -2, -3, 234, 435, -345};

        for (int i : array) {
            System.out.println(new MyString().myToString(i));
        }
    }
}

class MyString {

    private final Map<Integer, String> map = new HashMap<>(10);

    MyString() {
        map.put(1, "1");
        map.put(2, "2");
        map.put(3, "3");
        map.put(4, "4");
        map.put(5, "5");
        map.put(6, "6");
        map.put(7, "7");
        map.put(8, "8");
        map.put(9, "9");
        map.put(0, "0");
    }

    String myToString(int i) {
        if (i == 0) {
            return map.get(0);
        }

        StringBuilder sb = new StringBuilder();
        int remainder;
        List<String> list = new ArrayList<>();
        boolean negative = false;

        if (i < 0) {
            negative = true;
            i = -i;
        }

        while (i > 0) {
            remainder = i % 10;
            list.add(map.get(remainder));
            i = i / 10;
        }

        Collections.reverse(list);
        if (negative) {
            sb.append("-");
        }
        list.forEach(sb::append);

        return sb.toString();
    }

}
