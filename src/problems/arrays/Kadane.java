package problems.arrays;

import java.util.List;

public class Kadane {

    public static int maxSubArray(final List<Integer> A) {
        int maxSoFar = Integer.MIN_VALUE;
        int maxTillHere = 0;

        if(A.size() == 1) {
            return A.get(0);
        }

        for(int i = 0; i < A.size(); i++) {
            maxTillHere += A.get(i);

            if(maxTillHere < 0 && A.get(i) < 0) {
                maxTillHere = Math.max(maxTillHere, A.get(i));
            } else if(maxTillHere <= 0 && A.get(i) >= 0) {
                maxTillHere = A.get(i);
            }

            if(maxTillHere > maxSoFar) {
                maxSoFar = maxTillHere;
            }
        }
        return maxSoFar;
    }

    public static void main(String[] args) {
        List<Integer> arr = List.of(-2, 1, -3, 4, -1, 2, 1, -5, 4);
        System.out.println(maxSubArray(arr));
    }
}
