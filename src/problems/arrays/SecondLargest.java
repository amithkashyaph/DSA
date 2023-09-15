package problems.arrays;

public class SecondLargest {

    public static int secondLargest(int[] arr) {
        int largest = arr[0];
        int secondLargest = -1;

        for(int i = 1; i < arr.length; i++) {
            if(arr[i] > largest) {
                secondLargest = largest;
                largest = arr[i];
            } else if(arr[i] < largest && arr[i] > secondLargest) {
                secondLargest = arr[i];
            }
        }
        return secondLargest;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 5, 2, 3, 4, 6, 7, 9};
        System.out.println(secondLargest(arr));
    }
}
