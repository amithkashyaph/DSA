package problems.arrays;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class UnionOfTwoSortedArrays {

    public static void unionOfArrays(int[] arr, int[] arr2) {
        int i = 0;
        int j = 0;
        Stack<Integer> union = new Stack<>();

        while(i < arr.length && j < arr2.length) {
            if(arr[i] < arr2[j]) {
                if(union.isEmpty() || union.peek() != arr[i]) {
                    union.push(arr[i]);
                }
                i++;

            } else if(arr2[j] <= arr[i]){
                if(union.isEmpty() || union.peek() != arr2[j]) {
                    union.push(arr2[j]);
                }
                j++;
            }
        }

        if(i < arr.length) {
            while(i < arr.length) {
                if(union.peek() != arr[i]) {
                    union.push(arr[i]);
                }
                i++;
            }
        }

        if(j < arr2.length) {
            while(j < arr2.length) {
                if(union.peek() != arr2[j]) {
                    union.push(arr2[j]);
                }
                j++;
            }
        }

        for(Integer p : union) {
            System.out.print(p + " ");
        }

    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 3, 4, 5, 7, 10};
        int[] arr2 = {0, 2, 3, 4, 4, 5, 6, 9, 11, 14, 16, 19};

        unionOfArrays(arr, arr2);
    }
}
