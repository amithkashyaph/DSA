package problems.arrays;

import java.util.ArrayList;
import java.util.List;

public class IntersectionOfTwoSortedArrays {

    public static void intersectionOfArrays(int[] arr, int[] arr2) {
        int i = 0;
        int j = 0;
        List<Integer> intersection = new ArrayList<>();

        while(i < arr.length && j < arr2.length) {
            if(arr[i] < arr2[j]) {
                i++;
            } else if(arr[i] > arr2[j]) {
                j++;
            } else {
                intersection.add(arr[i]);
                i++;
                j++;
            }
        }

        for(Integer k : intersection) {
            System.out.print(k + " ");
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 3, 3, 4, 5, 6, 6};
        int[] arr2 = {1, 2, 2, 3, 3, 5};

        intersectionOfArrays(arr, arr2);
    }
}
