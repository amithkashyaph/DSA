package problems.priorityqueue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class RunningMedian {
    public static double[] inputStream = {10, 5, 2, 3, 0, 12, 18, 20, 22};
    public static PriorityQueue<Double> leftMaxHeap = new PriorityQueue<>(Collections.reverseOrder());
    public static PriorityQueue<Double> rightMinHeap = new PriorityQueue<>();

    public static void computeRunningMedian() {
        ArrayList<Double> medianArray = new ArrayList<>();
        double currentMedian = Integer.MAX_VALUE;
        for(int i = 0; i < inputStream.length; i++) {
            if(inputStream[i] <= currentMedian) {
                leftMaxHeap.add(inputStream[i]);
            } else {
                rightMinHeap.add(inputStream[i]);
            }
            int leftMaxHeapSize = leftMaxHeap.size();
            int rightMinHeapSize = rightMinHeap.size();
            if(leftMaxHeapSize == rightMinHeapSize) {
                currentMedian = (leftMaxHeap.peek() + rightMinHeap.peek()) / 2;
            } else if(leftMaxHeapSize == rightMinHeapSize + 1) {
                currentMedian = leftMaxHeap.peek();
            } else if (rightMinHeapSize == leftMaxHeapSize + 1) {
                currentMedian = rightMinHeap.peek();
            } else {
                if(leftMaxHeapSize > rightMinHeapSize) {
                    rightMinHeap.add(leftMaxHeap.poll());
                } else {
                    leftMaxHeap.add(rightMinHeap.poll());
                }
                currentMedian = (leftMaxHeap.peek() + rightMinHeap.peek()) / 2;
            }
            medianArray.add(currentMedian);
        }

        System.out.println(medianArray);
    }

    public static void main(String[] args) {
        computeRunningMedian();
    }
}
