package hackerrank.dictionariesandhashmaps;
import java.util.*;
import java.io.*;

public class CountTriplets {

    static long countTriplets(List<Long> arr, long r) {

        Map<Long, Long> secondMap = new HashMap<>();
        Map<Long, Long> thirdMap = new HashMap<>();

        long count = 0;

        for (int i = 0; i < arr.size(); i++) {
            long element = arr.get(i).longValue();

            // If the current element is a valid third element, increment the count.
            if (thirdMap.containsKey(element)) {
                count += thirdMap.get(element);
            }

            // If the current element is a valid second element, update thirdMap.
            if (secondMap.containsKey(element)) {
                thirdMap.put(element * r, thirdMap.getOrDefault(element * r, 0L) + secondMap.get(element));
            }

            // Update secondMap with the current element.
            secondMap.put(element * r, secondMap.getOrDefault(element * r, 0L) + 1);
        }

        System.out.println(count);
        return count;
    }

    public static void main(String[] args) {
        System.out.println(((int)CountTriplets.countTriplets(Arrays.asList(new Long(1),
                                                                           new Long(4),
                                                                           new Long(16),
                                                                           new Long(64)),
                                                             4)) == 2);
        System.out.println(((int)CountTriplets.countTriplets(Arrays.asList(new Long(1),
                                                                           new Long(2),
                                                                           new Long(2),
                                                                           new Long(4)),
                                                             2)) == 2);
        System.out.println(((int)CountTriplets.countTriplets(Arrays.asList(new Long(1),
                                                                           new Long(3),
                                                                           new Long(9),
                                                                           new Long(9),
                                                                           new Long(27),
                                                                           new Long(81)),
                                                             3)) == 6);
        System.out.println(((int)CountTriplets.countTriplets(Arrays.asList(new Long(1),
                                                                           new Long(5),
                                                                           new Long(5),
                                                                           new Long(25),
                                                                           new Long(125)),
                                                             5)) == 4);
    }
}