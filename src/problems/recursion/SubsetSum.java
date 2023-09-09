package problems.recursion;

import java.util.Stack;

public class SubsetSum {

    public static void generateSubsetSum(int[] arr, int i, int sum, Stack<Integer> numStack)  {
        if(i == arr.length) {
            System.out.print(sum + " ");
            return;
        }
        sum += arr[i];
        numStack.add(arr[i]);
        generateSubsetSum(arr, i + 1, sum, numStack);


        sum -= arr[i];
        numStack.pop();

        generateSubsetSum(arr, i + 1, sum, numStack);
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 4};
        Stack<Integer> numStack = new Stack<>();

        generateSubsetSum(arr, 0, 0, numStack);
    }
}
