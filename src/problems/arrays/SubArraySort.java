package problems.arrays;

import java.util.ArrayList;
import java.util.List;

public class SubArraySort {

    public static boolean outOfOrder(int[] arr, int i) {
        if(i == 0) {
            return arr[0] > arr[1];
        }
        if(i == arr.length - 1) {
            return arr[arr.length - 1] < arr[arr.length - 2];
        }
        return arr[i] > arr[i + 1] || arr[i] < arr[ i - 1];
    }
    public static void sortArray(int[] arr) {
        int smallest = Integer.MAX_VALUE;
        int largest = Integer.MIN_VALUE;
        List<Integer> result = new ArrayList<>();

        for(int i = 0; i < arr.length; i++) {
            int num = arr[i];
            if(outOfOrder(arr, i)) {
                smallest = Integer.min(smallest, num);
                largest = Integer.max(largest, num);
            }
        }

        for(int i = 0; i < arr.length; i++) {
            if(smallest < arr[i]) {
                result.add(i);
                break;
            }
        }
        for(int i = arr.length - 1; i >= 0; i--) {
            if(largest > arr[i]) {
                result.add(i);
                break;
            }
        }
        System.out.println(result);

    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,8,6,7,9,10,11};
        sortArray(arr);
    }

}
