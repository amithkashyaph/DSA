package problems.arrays;

public class MoveAllZeroesToEnd {

    public static void moveAllZeroes(int[] arr) {
        int i = 0;
        int j = arr.length - 1;

        while(i < j) {
            if(arr[i] == 0) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j--;
            } else {
                i++;
            }
        }

        for(int k = 0; k < arr.length; k++) {
            System.out.print(arr[k] + " ");
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 0, 2, 3, 2, 0, 0, 4, 5, 1};
        moveAllZeroes(arr);
    }
}
