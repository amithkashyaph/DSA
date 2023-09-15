package problems.arrays;

public class NextPermutationOfArray {

    public static void nextPermutation(int[] arr) {
        int breakPoint = -1;

        // find the dipping point where arr[i] < arr[i + 1]
        for(int i = arr.length - 2; i >= 0; i--) {
            if(arr[i] < arr[i + 1]) {
                breakPoint = i;
                break;
            }
        }

        // find the first max element from the end which is greater than the arr[breakPoint]
        for(int i = arr.length - 1; i >= 0; i--) {
            if(arr[i] > arr[breakPoint]) {
                int temp = arr[i];
                arr[i] = arr[breakPoint];
                arr[breakPoint] = temp;
                break;
            }
        }

        // rearrange the array by sorting it from breakpoint till the end
        int j = arr.length - 1;
        for(int i = breakPoint + 1; i < arr.length; i++) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            j--;
        }

        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 4, 3, 0, 0, 1, 0};
        nextPermutation(arr);
    }
}
