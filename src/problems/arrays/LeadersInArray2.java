package problems.arrays;

import java.util.Stack;

public class LeadersInArray2 {

    public static void findLeaders(int[] arr) {
        Stack<Integer> leaderStack = new Stack<>();
        leaderStack.push(arr[arr.length - 1]);

        for(int i = arr.length - 2; i >= 0; i--) {
            if(arr[i] > leaderStack.peek()) {
                leaderStack.push(arr[i]);
            }
        }

        for(Integer i: leaderStack) {
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        int[] arr = {10, 22, 12, 13, 0, 6, 7, 2};
        findLeaders(arr);
    }
}
