package crack.interview.notes;

public class SubArrays {

    private static int subarraySum(int[] arr) {
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                for (int k = i; k <= j; k++) {
                    result += arr[k];
                }
            }
        }
        return result;
    }

    private static int subarraySum2(int[] arr) {
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                result += sum;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,7};
        System.out.println(subarraySum2(arr));
    }
}
