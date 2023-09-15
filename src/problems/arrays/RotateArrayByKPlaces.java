package problems.arrays;

import java.util.ArrayList;
import java.util.List;

public class RotateArrayByKPlaces {

    public static void rotateArrayBruteApproach(int[] arr, int k) {
        List<Integer> tempList = new ArrayList<>();
        for(int i = 0; i < k; i++) {
            tempList.add(arr[i]);
        }
        for(int i = k; i < arr.length; i++) {
            arr[i - k] = arr[i];
        }
        for(int i = arr.length - k; i < arr.length; i++) {
            arr[i] = tempList.get(i - (arr.length - k));
        }

        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void rotateArrayOptimalApproach(int[] arr, int k) {
        reverseArray(arr, 0, k);
        reverseArray(arr, k, arr.length);
        reverseArray(arr, 0, arr.length);
        System.out.println();
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void reverseArray(int[] arr, int i, int j) {
        int temp;
        j--;
        while(i < j) {
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        rotateArrayBruteApproach(arr, 5);
        int[] arr2 = {1, 2, 3, 4, 5, 6, 7, 8};
        rotateArrayOptimalApproach(arr2, 5);
    }
}
