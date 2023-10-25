package hackerrank.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class Bribe {

    /*
     * Complete the 'minimumBribes' function below.
     *
     * The function accepts INTEGER_ARRAY q as parameter.
     */

    public static void minimumBribes(List<Integer> q) {
        // Write your code here
        int p1 = 1; //1 ? ?
        int p2 = 2; //2 ? ?
        int p3 = 3; //3 ? ?
        //1234
        //1423 // nothing can go more than 2 steps ahead
        int bribes = 0;
        for(int i = 0; i < q.size(); i++) {
            if(q.get(i) == p1) { //1 2 3
                p1 = p2;
                p2 = p3;
                p3++;//2 3 4
            } else if(q.get(i) == p2) { //2 1 3
                bribes++;   //1 3 4
                p2 = p3;
                p3++;
            }
            else if (q.get(i) == p3) { //3 1 2
                bribes += 2; //1 2 4
                p3++;
            } else {
                System.out.println("Too chaotic");
                return;
            }
        }
        System.out.println(bribes);

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> q = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                        .map(Integer::parseInt)
                                        .collect(toList());

                minimumBribes(q);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
}
