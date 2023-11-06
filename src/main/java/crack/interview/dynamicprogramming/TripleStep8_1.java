package crack.interview.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class TripleStep8_1 {


  static Map<Integer, Integer> memoization = new HashMap<>();
  /*
   * A child is running up a staircase with n steps and can hop either 1 step, 2 steps or 3 steps at a time.
   *
   * Implement a method to count how many possible ways the child can run up the stairs.
   *
   * nth place can be reach from n-1 , n-2 , n-3
   * n-1th place can be reach from n-1-1 , n-1-2, n-1-3
   */

  public static void main(String[] args) {
   // System.out.println(howManyHops(4));
    System.out.println(howManyHopsMemoization(30));
  }

  private static int howManyHops(int hops) {
    //int totalSteps=0;
    if (hops == 1) {
      return 1;
    }
    if (hops < 1) {
      return 0;
    }

    return howManyHops(hops - 1) + howManyHops(hops - 2) + howManyHops(hops - 3);
  }

  private static int howManyHopsMemoization(int hops) {
    //int totalSteps=0;
    if (hops == 1) {

      return 1;
    }
    if (hops < 1) {
      return 0;
    }
    memoization.put(hops, howManyHopsMemoization(hops - 1) + howManyHopsMemoization(hops - 2) + howManyHopsMemoization(hops - 3));
    return memoization.get(hops);
  }
}
