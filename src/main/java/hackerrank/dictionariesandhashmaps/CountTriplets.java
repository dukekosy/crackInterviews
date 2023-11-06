package hackerrank.dictionariesandhashmaps;
import java.util.*;


public class CountTriplets {
//take a look at the text file. this is pretty hard and I'd say don't spend too much time on it.
    //https://www.youtube.com/watch?v=eAeuaRJ5RcM

    static long countTriplets(List<Long> arr, long r) {

        Map<Long, Long> secondMap = new HashMap<>();
        Map<Long, Long> thirdMap = new HashMap<>();

        long count = 0;

        for (int i = 0; i < arr.size(); i++) {
            long element = arr.get(i).longValue();

            // If the current element is a valid third element, get current element count
            // increment count with that number will be +2 in case of 2,2 (repeated number)
            // will be +1 in case of non repeated number.
            if (thirdMap.containsKey(element)) {
                count += thirdMap.get(element);
            }

            // If the current element is a valid second element, update thirdMap.
            // with the expected third element, the current count of the current elements
            // which is element count of thirdMap (if next number is repeated number or  0) and
            // element count of secondMap which is the current element.
            if (secondMap.containsKey(element)) {
                thirdMap.put(element * r, thirdMap.getOrDefault(element * r, 0L) + secondMap.get(element));
            }

            // Update secondMap with the next element, the next element count + 1
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