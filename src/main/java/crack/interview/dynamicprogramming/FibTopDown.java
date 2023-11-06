package crack.interview.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class FibTopDown {
//total of first n fibonacci elements
    // 1 2 3 5 8 first 5 numbers
  static Map<Integer, Integer> memoization = new HashMap<>();

  /*
   *  Fib(5)  - > fib(4) + fib(3)
   *              fib(3) + fib(2)  + fib(2) + fib(1)
   *              fib(2) + fib(1) + fib(1) + fib(1)  + fib(1) + fib(1) + fib(1)
   *              fib(1) +fib(1)+ fib(1) + fib(1) + fib(1)  + fib(1) + fib(1) + fib(1)
   *
   */
  public static void main(String[] args) {

    System.out.println("**************** calculateFibTopDown ***************");
    System.out.println(calculateFibTopDown(1));
    System.out.println(calculateFibTopDown(2));
    System.out.println(calculateFibTopDown(3));
    System.out.println(calculateFibTopDown(4));
    System.out.println(calculateFibTopDown(5));
    System.out.println(calculateFibTopDown(6));
    System.out.println(calculateFibTopDown(7));

    System.out.println("**************** calculateFibTopDownMemoization ***************");


    System.out.println(calculateFibTopDownMemoization(1));
    System.out.println(calculateFibTopDownMemoization(2));
    System.out.println(calculateFibTopDownMemoization(3));
    System.out.println(calculateFibTopDownMemoization(4));
    System.out.println(calculateFibTopDownMemoization(5));
    System.out.println(calculateFibTopDownMemoization(6));
    System.out.println(calculateFibTopDownMemoization(21));


    System.out.println("********* calculateFibBottomUp ***********");


    int i = 2;

    int beforePrevious = 1;
    int previous = 1;
    System.out.println(calculateFibBottomUp(1, 1, 1, i));
    System.out.println(calculateFibBottomUp(1, 1, 2, i));
    System.out.println(calculateFibBottomUp(1, 1, 3, i));
    System.out.println(calculateFibBottomUp(1, 1, 4, i));
    System.out.println(calculateFibBottomUp(1, 1, 5, i));
    System.out.println(calculateFibBottomUp(1, 1, 6, i));
    System.out.println(calculateFibBottomUp(1, 1, 7, i));

    System.out.println("********* calculateFibBottomUpCleaner ***********");
    //or better and cleaner
    System.out.println(calculateFibBottomUpCleaner(1));
    System.out.println(calculateFibBottomUpCleaner(2));
    System.out.println(calculateFibBottomUpCleaner(3));
    System.out.println(calculateFibBottomUpCleaner(4));
    System.out.println(calculateFibBottomUpCleaner(5));
    System.out.println(calculateFibBottomUpCleaner(6));
    System.out.println(calculateFibBottomUpCleaner(7));

  }

  private static int calculateFibBottomUpCleaner(int n) {
        /*
     fib(1) =1
     fib(2) = 1
     fib(1) + fib(2) -> fib(3)
     fib(2) + fib(3) -> fib(4)
     fib(3) + fib(4) -> fib(5)
     */

    if (n <= 2) {
      return 1;
    } else {
      int beforePrevious = 1;
      int previous = 1;
      int current = 0;
      for (int i = 2; i < n; i++) {
        current = beforePrevious + previous;
        beforePrevious = previous;
        previous = current;
      }
      return current;
    }
  }

  /**
   * @param n
   * @param previous
   * @return
   */
  private static int calculateFibBottomUp(int beforePrevious, int previous, int n, int i) {
    /*
     fib(1) =1
     fib(2) = 1
     fib(1) + fib(2) -> fib(3)
     fib(2) + fib(3) -> fib(4)
     fib(3) + fib(4) -> fib(5)
     */

    if (n <= 2) {
      return 1;
    } else {
      int current = beforePrevious + previous;
      beforePrevious = previous;
      previous = current;
      i++;
      if (i < n) {

        return calculateFibBottomUp(beforePrevious, previous, n, i);
      } else {
        return current;
      }
    }
  }

  /**
   * Time complexity -> O(2^n) or better O(1.6^n)
   *
   * @param n
   * @return
   */
  private static int calculateFibTopDown(int n) {

    if (n <= 2) {
      return 1;
    } else {
      return calculateFibTopDown(n - 1) + calculateFibTopDown(n - 2);
    }
  }

  /**
   * This method has time complexity O(n) same as bottom up approach
   * Adding memory means it's done using dynamic programming. Faster.
   *
   * @param n
   * @return
   */
  private static int calculateFibTopDownMemoization(int n) {

    if (n <= 2) {
      memoization.put(1, 1);
      memoization.put(2, 1);
      return 1;
    } else {
      int temp = calculateFibTopDownMemoization(n - 1) + calculateFibTopDownMemoization(n - 2);
      memoization.put(n, temp);
      return memoization.get(n - 1) + memoization.get(n - 2);
    }
  }
}
