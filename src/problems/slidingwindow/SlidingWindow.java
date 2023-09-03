package problems.slidingwindow;

public class SlidingWindow {

    public static void housing(int[] sites, int target) {
        int left = 0, right = 0;
        int currentSum = 0;
        while(right < sites.length) {
            currentSum += sites[right];
             while(left < right && currentSum > target) { // [1, 3, 2, 1, 4, 1, 3, 2, 1, 1]
                 currentSum -= sites[left];
                 left++;
             }
             if(currentSum == target) {
                 System.out.println(left + "  " + right);
             }
             right++;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 1, 4, 1, 3, 2, 1, 1};
        housing(arr, 8);
    }
}
