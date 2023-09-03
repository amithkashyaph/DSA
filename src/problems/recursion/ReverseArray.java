package problems.recursion;

public class ReverseArray {

    public static void reverseArray(int[] arr, int i, int j) {
        if(i >= j) {
            return;
        }
        swap(arr, i, j);
        reverseArray(arr, i + 1, j - 1);
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6};

        reverseArray(arr, 0, arr.length - 1);

        for(int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
