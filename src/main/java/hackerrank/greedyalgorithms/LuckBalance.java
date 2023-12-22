package hackerrank.greedyalgorithms;


import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
import java.util.concurrent.atomic.*;

class LuckBalance {

    /*
     * Complete the 'luckBalance' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. 2D_INTEGER_ARRAY contests
     */
    public static int luckBalance(int k, List<List<Integer>> contests) {
        // Write your code here
        // she want to lose all 0 challenges to increase her luck balance
        // she wants to lose ###two of the least L[i] 1 challenges to increase her luck balance for those two
        // you have to -minus all the rest of the 1 challenges to decrease her balance

        // add all 0s
        // add the largest k 1s
        // minus rest of the lowest 1s

        //4
        // if 0 add

        //solution 1 if 1 (insert into a different list)
        //solution 2 if 1 (how to store so that the lowest value is at the end)

        //s2
        //sort 2nd list
        //add till k and - after

        //s3
        //4 if 0 add
        //else - all

        //4 0 to k
        //add twice the value

        /*
        final solution
        4 total 0s and make a list of ones

        reverse order them

        if there are 1s and if k is not 0 ??
        4 add 1s to k
        4 minus 1s to end of list

         */
        if(contests.size()==0)
            return 0;

        AtomicInteger result = new AtomicInteger();
        List<Integer> importantOnes = new ArrayList<>(contests.size());

        contests.forEach(contest -> {
            if(contest.get(1) == 0)
                result.addAndGet(contest.get(0));
            else {
                importantOnes.add(contest.get(0));
                //result.addAndGet(-contest.get(0));
            }
        });
        if(k > importantOnes.size())
            k = importantOnes.size();
        if(importantOnes.size()!=0 || k == 0) {  // don't think k == 0 is necessary here.
            Collections.sort(importantOnes, Collections.reverseOrder());

            IntStream.range(0, k).forEach(index -> {
                result.addAndGet(importantOnes.get(index));
            });
            IntStream.range(k, importantOnes.size()).forEach(index -> {
                result.addAndGet(-importantOnes.get(index));
            });
        }
        return result.intValue();
    }

        public static void main(String[] args) throws IOException {

            List<List<Integer>> contests = new ArrayList<>();
            contests.add(Stream.of(5, 0).collect(toList()));
            contests.add(Stream.of(2, 0).collect(Collectors.toList()));
            contests.add(Stream.of(1, 0).collect(Collectors.toCollection(ArrayList::new)));
            contests.add(Stream.of(8, 0).collect(toList()));
            contests.add(Stream.of(10, 0).collect(toList()));
            contests.add(Stream.of(5, 0).collect(toList()));

            System.out.println(LuckBalance.luckBalance(6, contests)==31);
            System.out.println(LuckBalance.luckBalance(3, contests)==31);
            System.out.println(LuckBalance.luckBalance(0, contests)==31);

            contests = new ArrayList<>();
            contests.add(Stream.of(5, 1).collect(toList()));
            contests.add(Stream.of(2, 1).collect(Collectors.toList()));
            contests.add(Stream.of(1, 1).collect(Collectors.toCollection(ArrayList::new)));
            contests.add(Stream.of(8, 1).collect(toList()));
            contests.add(Stream.of(10, 0).collect(toList()));
            contests.add(Stream.of(5, 0).collect(toList()));

            System.out.println(LuckBalance.luckBalance(3, contests)==29);
            System.out.println(LuckBalance.luckBalance(0, contests)==-1);
        }
    }
