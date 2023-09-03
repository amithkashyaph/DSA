package problems.priorityqueue;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MergingRopes {
    public static ArrayList<Integer> ropes = new ArrayList<>();
    public static PriorityQueue<Integer> ropesHeap = new PriorityQueue<>();

    public static void calculateRopes() {
        int cost = 0, tempCost = 0;
        while(ropesHeap.size() > 1) {
            int currentMinRopeA = ropesHeap.poll();
            int currentMinRopeB = ropesHeap.poll();
            tempCost = currentMinRopeA + currentMinRopeB;
            cost += tempCost;
            ropesHeap.add(tempCost);
        }
        System.out.println(cost);
    }

    public static void main(String[] args) {
        int[] input = {4, 3, 2, 6};
        for(int i = 0; i < input.length; i++) {
            ropesHeap.add(input[i]);
        }
        calculateRopes();
    }
}
