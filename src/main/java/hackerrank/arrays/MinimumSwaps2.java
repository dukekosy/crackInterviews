package hackerrank.arrays;
//https://www.hackerrank.com/challenges/minimum-swaps-2/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays
import java.io.IOException;

public class MinimumSwaps2 {

    // Complete the minimumSwaps function below.
    static int minimumSwaps(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            while (arr[i] != i + 1) {
                //arr[i] and arr[arr[i]-1]
                /*int a = arr[i];
                int b = arr[a - 1];
                arr[i] = b;
                arr[a - 1] = a;*/
                int temp = arr[i];
                arr[i] = arr[arr[i]-1];
                arr[temp-1] = temp;
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(minimumSwaps(new int[]{4, 3, 1, 2}) == 3);
        System.out.println(minimumSwaps(new int[]{2, 3, 4, 1, 5}) == 3);
        System.out.println(minimumSwaps(new int[]{1, 3, 5, 2, 4, 6, 7}) == 3);
    }
}

