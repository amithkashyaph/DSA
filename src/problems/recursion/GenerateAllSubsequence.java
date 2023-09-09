package problems.recursion;

import java.util.*;

public class GenerateAllSubsequence {

    /*
    * TC : 2^n * n
    * */
    public static void generateSubsequence(Stack<Integer> nums, int[] arr, int i, int len) {
        if(i >= len) {
            for(Integer n : nums) {
                System.out.print(n + " ");
            }
            if(nums.size() == 0) {
                System.out.print("{}");
            }
            System.out.println();
            return;
        }

        // Take the element into consideration for forming the subsequence
        nums.add(arr[i]);
        generateSubsequence(nums, arr, i + 1, len);

        // Do not take the element into consideration for forming the subsequence
        nums.pop();
        generateSubsequence(nums, arr, i + 1, len);

    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 1, 2};
        Stack<Integer> numStack = new Stack<>();
        generateSubsequence(numStack, arr, 0, arr.length);

    }
}
