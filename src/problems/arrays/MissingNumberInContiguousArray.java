package problems.arrays;

public class MissingNumberInContiguousArray {

    public static int findMissingNumber(int[] arr) {
        int xor1 = 0;
        int xor2 = 0;
        for(int i = 1; i <= arr.length + 1; i++) {
            xor1 ^= i;
        }

        for(int i = 0; i < arr.length; i++) {
            xor2 ^= arr[i];
        }

        return xor1 ^ xor2;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5, 6};
        System.out.println(findMissingNumber(arr));
    }
}
