package crack.interview.notes;

import java.util.Arrays;

class MergeSort {

    private void merge(int[] arr, int l, int m, int r) {
        // Find sizes of two subarrays to be merged (getting wrong)
        int sizeL = m - l + 1;
        int sizeR = r - m;
        // Getting wrong
        int[] L = Arrays.copyOfRange(arr, l, l + sizeL);
        int[] R = Arrays.copyOfRange(arr, m + 1, m+1+sizeR);
/*
or
        int sizeL = m - l;
        int sizeR = r - m;
        // Getting wrong
        int[] L = Arrays.copyOfRange(arr, l+1, l+1 + sizeL);
        int[] R = Arrays.copyOfRange(arr, m+1, m+1 + sizeR);
*/

        int i = 0, j = 0;

        // Initial index of merged subarry array
        //xxx note l not 1
        int k = l;
        while (i < sizeL && j < sizeR) {
            //xxx remember this less than or equal to
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++; //xxx not i
            }
            k++;
        }

        while (i < sizeL) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < sizeR) {
            arr[k] = R[j];
            j++; //xxx not i
            k++;
        }
    }

    private void sort(int[] arr, int l, int r) {
        if (l < r) {
            // Find the middle point
            //xxx note this is the index not the middle of the array size / 2
            int m = (l + r) / 2;

            // Sort first and second halves
            sort(arr, l, m);
            sort(arr, m + 1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }

    /* A utility function to print array of size n */
    private static void printArray(int[] arr) {
        for (int i1 : arr) {
            System.out.print(i1 + " ");
        }
        System.out.println();
    }

    // Driver method
    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};

        System.out.println("Given Array");
        printArray(arr);

        MergeSort ob = new MergeSort();
        ob.sort(arr, 0, arr.length - 1);

        System.out.println("\nSorted array");
        printArray(arr);
    }
}
/* This code is contributed by Rajat Mishra */
