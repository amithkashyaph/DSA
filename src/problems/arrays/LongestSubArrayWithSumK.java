package problems.arrays;

import java.util.HashMap;

public class LongestSubArrayWithSumK {

    public static int findLongestSubArrayWithZeroesAndPositives(int[] arr, int k) {
        int sum = 0;
        int i = 0;
        int j = 0;
        int maxLen = 0;

        while(j < arr.length) {
            sum += arr[j];
            while(sum > k && i <= j) {
                sum -= arr[i];
                i++;
            }
            if(sum == k) {
                maxLen = Math.max(maxLen, j - i + 1);
            }
            j++;
        }
        return maxLen;
    }


    public static int findLongestSubArray(int[] arr, int k) {
        int sum = 0;
        int j = 0;
        int maxLen = 0;
        HashMap<Integer, Integer> prefixSum = new HashMap<>();

        while(j < arr.length) {
            sum += arr[j];

            if(sum == k) {
                maxLen = Math.max(maxLen, j + 1);
            }
            int rem = sum - k;
            if(prefixSum.containsKey(rem)) {
                maxLen = Math.max(maxLen, j - prefixSum.get(rem));
            } else {
                if(!prefixSum.containsKey(sum))
                prefixSum.put(sum, j);
            }
            j++;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3,1, 1, 1, 1, 1, 1,0, 0, 1, 1, -2, 3 ,-3, 0, 0};
        int[] arr2 = {2, 0, 0, 3};
        System.out.println(findLongestSubArray(arr, 6));
    }
}
