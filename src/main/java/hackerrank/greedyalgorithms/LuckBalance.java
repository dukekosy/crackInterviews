package hackerrank.greedyalgorithms;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
import java.util.concurrent.atomic.*;

class Result {

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


        AtomicInteger result = new AtomicInteger();
        List<Integer> importantOnes = new ArrayList<>(contests.size());

        contests.stream().forEach(contest -> {
            if(contest.get(1) == 0)
                result.addAndGet(contest.get(0));
            else {
                importantOnes.add(contest.get(0));
                result.addAndGet(-contest.get(0));
            }
        });


        Collections.sort(importantOnes);
        System.out.println(importantOnes);
        IntStream.range(importantOnes.size()-k, importantOnes.size()).forEach(index -> {
            result.addAndGet(2*importantOnes.get(index));
        });
        return result.intValue();
    }

        public static void main(String[] args) throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

            String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            int n = Integer.parseInt(firstMultipleInput[0]);

            int k = Integer.parseInt(firstMultipleInput[1]);

            List<List<Integer>> contests = new ArrayList<>();

            IntStream.range(0, n).forEach(i -> {
                try {
                    contests.add(
                            Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                  .map(Integer::parseInt)
                                  .collect(toList())
                    );
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            });

            int result = Result.luckBalance(k, contests);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();

            bufferedReader.close();
            bufferedWriter.close();
        }
    }
