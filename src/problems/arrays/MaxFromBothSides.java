package problems.arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class MaxFromBothSides {

    public static int solve(ArrayList<Integer> A, int B) {
        int ans = Integer.MIN_VALUE;
        int n = A.size();
        int tempAns = 0;
        for(int i = 0; i < B; i++) {
            tempAns += A.get(i);
        }

        for(int i = 0; i < B; i++) {
            int noToBeRemoved = A.get(B - i - 1);
            int noToBeAdded = A.get(n - i - 1);
            tempAns =  tempAns - noToBeRemoved + noToBeAdded;
            ans = Math.max(ans, tempAns);
        }

        return ans;
    }

    public static void main(String[] args) {
//        int[] arr = {-533,-666,-500,169,724,478,358,-38,-536,705,-855,281,-173,961,-509,-5,942,-173,436,-609,-396,902,-847,-708,-618,421,-284,718,895,447,726,-229,538,869,912,667,-701,35,894,-297,811,322,-667,673,-336,141,711,-747,-132,547,644,-338,-243,-963,-141,-277,741,529,-222,-684,35};
        int B = 4;
        int[] arr = { 2, 3, -1, 4, 2, 1 };
        ArrayList<Integer> input = new ArrayList<>();
        for(int i = 0; i < arr.length; i++) {
            input.add(arr[i]);
        }

        System.out.println(solve(input, B));
    }
}
