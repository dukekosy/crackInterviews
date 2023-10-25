package hackerrank.challenges;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class JumpingClouds {



    /*
     * Complete the 'jumpingOnClouds' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY c as parameter.
     */

/*
if 0
    keepgin going till next is 1 hop
    keep going till limit = 0  hop limit++
    limit  = 2 reset to 0 and set limit 0
if 1
*/

    public static int jumpingOnClouds(List<Integer> c) {
        // Write your code here
        int limit = 0;
        int hops = 0;
        for (int i = 0; i < c.size() - 1; i++) {
            if (c.get(i) == 0) { // only zero is handled, 1 is skipped
                if (c.get(i + 1) == 1) { // if next is 1 we hop and reset limit
                    limit = 0;
                    hops++;
                } else if (limit == 0) { // if limit is 0 we hop and limit++
                    hops++;
                    limit++;
                } else if (limit == 2) { // if it's 2 we hop but set limit to 1 instead of 0 or it will hop again if the next one is a 0
                    limit = 1;
                    hops++;
                } else {
                    limit++;
                }
            }
        }

        return hops;
    }

    public static void main(String[] args) throws IOException {

/*
            if ((i == 0 && c.get(i) == 0)) {
                hops++;
                continue;
            }
        if (c.get(i) == 0) {
            if (limit == 2 || c.get(i + 1) == 1) {
                hops++;
                limit = 0;
                continue;
            }
            if(limit == 2)
                hops++;
            limit++;
        }*/
        System.out.println(JumpingClouds.jumpingOnClouds(
                Arrays.asList(0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0,
                              0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 1, 0, 0))/* == 28*/);

        System.out.println(JumpingClouds.jumpingOnClouds(Arrays.asList(0, 0, 0, 0, 1, 0))/* == 3*/);
        System.out.println(JumpingClouds.jumpingOnClouds(Arrays.asList(0, 0, 1, 0, 0, 1, 0))/* == 4*/);

    }

}

