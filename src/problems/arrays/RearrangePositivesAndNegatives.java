package problems.arrays;

public class RearrangePositivesAndNegatives {

    public static void rearrangeArray(int[] arr) {
        int positivePos = 0;
        int negativePos = 0;
        int[] ans = new int[arr.length];

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] > 0) {
                ans[2*positivePos] = arr[i];
                positivePos++;
            } else {
                ans[2 * negativePos + 1] = arr[i];
                negativePos++;
            }
        }

        for(int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, -2, -5, 2, -4};
        rearrangeArray(arr);
    }
}
