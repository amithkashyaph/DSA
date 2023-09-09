package problems.recursion;

import java.util.Stack;

public class SubsequenceWithSumK {

    public static void printAllSubsequenceWithSumK(int[] arr, int i, int sum, int tempSum, int len, Stack<Integer> numStack) {
        if(i == len) {
            if(tempSum == sum) {
                for(Integer num : numStack) {
                    System.out.print(num + " ");
                }
                System.out.println();
            }
            return;
        }

        numStack.add(arr[i]);
        tempSum += arr[i];
        printAllSubsequenceWithSumK(arr, i + 1, sum, tempSum, len, numStack);

        numStack.pop();
        tempSum -= arr[i];
        printAllSubsequenceWithSumK(arr, i + 1, sum, tempSum, len, numStack);
    }

    public static boolean printOneSubsequenceWithSumK(int[] arr, int i, int sum, int tempSum, int len, Stack<Integer> numStack) {
        if(i == len) {
            if(tempSum == sum) {
                for(Integer num : numStack) {
                    System.out.print(num + " ");
                }
                System.out.println();
                return true;
            }
            return false;
        }

        numStack.add(arr[i]);
        tempSum += arr[i];
        if(printOneSubsequenceWithSumK(arr, i + 1, sum, tempSum, len, numStack)) {
            return true;
        }

        numStack.pop();
        tempSum -= arr[i];
        if(printOneSubsequenceWithSumK(arr, i + 1, sum, tempSum, len, numStack)) {
            return true;
        }
        return false;
    }


    public static int countSubsequencesWithSumK(int[] arr, int i, int sum, int tempSum, int len) {
        if(i == len){
            if(tempSum == sum) {
                return 1;
            }
            return 0;
        }

        tempSum += arr[i];
        int l = countSubsequencesWithSumK(arr, i + 1, sum, tempSum, len);


        tempSum -= arr[i];
        int r = countSubsequencesWithSumK(arr, i + 1, sum, tempSum, len);
        return l + r;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 1};
        int sum = 2;
        Stack<Integer> numStack = new Stack<>();

        printOneSubsequenceWithSumK(arr, 0, 2, 0, arr.length, numStack);
        System.out.println("All subsequences : ");
        numStack = new Stack<>();
        printAllSubsequenceWithSumK(arr, 0, 2, 0, arr.length, numStack);
        System.out.println("All subsequences : ");
        System.out.println(countSubsequencesWithSumK(arr, 0, 2, 0, arr.length));
    }
}
