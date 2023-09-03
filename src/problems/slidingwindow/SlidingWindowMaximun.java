package problems.slidingwindow;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class SlidingWindowMaximun {

    public static ArrayList<Integer> sumInWindow(int[] arr, int k) {
        int[] currentWindow = new int[k];
        ArrayList<Integer> result = new ArrayList<>();
        int currentSum = 0;
        int tail = 0;

        for(int i = 0; i < k; i++) {
            currentWindow[i] = arr[i];
            currentSum+= currentWindow[i];
        }
        result.add(currentSum);
        for(int head = k; head < arr.length; head++) {
            currentSum += arr[head];
            currentSum -= arr[tail];
            result.add(currentSum);
            tail++;
        }
        return result;
    }

    public static ArrayList<Integer> maxInWindow(int[] arr, int k) {
        Deque<Integer> currentWindow = new ArrayDeque<>();
        ArrayList<Integer> result = new ArrayList<>();
        int tail = 0;
        int currentMax = Integer.MIN_VALUE;

        for(int i = 0; i < k; i++) {
            if(currentWindow.peekLast() < arr[i]) {
                currentWindow.removeLast();
            }
            currentWindow.add(arr[i]);
            currentMax = Integer.max(arr[i], currentMax);
        }
        result.add(currentMax);
        for(int head = k; head < arr.length; head++) {
            if(arr[head] > currentWindow.peekLast()) {
                currentMax = arr[head];
                currentWindow.removeLast();
                result.add(currentMax);
            }
            currentWindow.add(arr[head]);
            tail++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1, 4, 5, 2, 3, 6};
        System.out.println(maxInWindow(arr, 3));
    }
}
