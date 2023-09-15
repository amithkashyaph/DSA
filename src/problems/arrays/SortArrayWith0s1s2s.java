package problems.arrays;

public class SortArrayWith0s1s2s {

    public static void sortArray(int[] arr) {
        int left = 0;
        int mid = 0;
        int right = arr.length - 1;

        while(mid <= right) {
            switch (arr[mid]) {
                case 0: {
                    int temp = arr[mid];
                    arr[mid] = arr[left];
                    arr[left] = temp;
                    left++;
                    mid++;
                    break;
                }
                case 1: {
                    mid++;
                    break;
                }
                case 2: {
                    int temp = arr[mid];
                    arr[mid] = arr[right];
                    arr[right] = temp;
                    right--;
                    break;
                }
            }
        }

        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 2, 2, 0, 0, 0, 2, 1, 0};
        sortArray(arr);
    }
}
