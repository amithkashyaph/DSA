package problems.stacks;


import java.util.Stack;

public class NearestSmallerElementOnRight {

    public static int largestRectangleArea(int[] A) {
        Stack<Integer> smallerFromLeft = new Stack<>();
        Stack<Integer> smallerFromRight = new Stack<>();
        int[] leftAns = new int[A.length];
        int[] rightAns = new int[A.length];
        int ans = Integer.MIN_VALUE;

        for(int i = 0; i < A.length; i++) {
            while(!smallerFromLeft.isEmpty() && A[i] < A[smallerFromLeft.peek()]) {
                smallerFromLeft.pop();
            }
            if(smallerFromLeft.isEmpty()) {
                leftAns[i] = -1;
            } else {
                leftAns[i] = smallerFromLeft.peek();
            }
            smallerFromLeft.push(i);
        }

        for(int i : leftAns) {
            System.out.print(i + "  ");
        }

        for(int i = A.length - 1; i >= 0; i--) {
            while(!smallerFromRight.isEmpty() && A[i] < A[smallerFromRight.peek()]) {
                smallerFromRight.pop();
            }
            if(smallerFromRight.isEmpty()) {
                rightAns[i] = -1;
            } else {
                rightAns[i] = smallerFromRight.peek();
            }
            smallerFromRight.push(i);
        }
        System.out.println();
        for(int i : rightAns) {
            System.out.print(i + "  ");
        }
        System.out.println();
        for(int i = 0; i < A.length; i++) {
            ans = Math.max(ans, (rightAns[i] - leftAns[i] - 1) * A[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
//        findNearestSmallerElement(new int[]{4, 6, 10, 11, 7, 8, 3, 5, 3});
        System.out.println(largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
    }
}
