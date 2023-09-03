package problems.arrays;

import java.util.ArrayList;

public class LeadersInArray {

    static ArrayList<Integer> leaders(int arr[], int n){
        // Your code here
        ArrayList<Integer> result = new ArrayList<Integer>();

        if(n == 1) {
            result.add(arr[0]);
            return result;
        }

        int[] preSum = new int[n];
        preSum[n - 1] = arr[n - 1];
        for(int i = n-2; i >= 0; i--) {
            preSum[i] = preSum[i + 1] + arr[i];
        }
        for(int i = 0; i < n - 1; i++) {
            if(arr[i] >= preSum[i + 1]) {
                result.add(arr[i]);
            }
        }
        result.add(arr[n - 1]);
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {
                16,17, 4, 3, 5, 2};
        System.out.println(leaders(arr, 6));
    }
}
