package problems.arrays;

public class RemoveDuplicatesFromSortedArray {

    public static void removeDuplicates(int[] arr) {

        int j = 0;
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] != arr[j]) {
                arr[j + 1] = arr[i];
                j++;
            }
        }

        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        int[] arr = { 1, 1, 2, 2, 3, 3, 3, 4, 4, 5};
//        1 2 3 4 5 3 3 2 4 1
        removeDuplicates(arr);
    }
}
