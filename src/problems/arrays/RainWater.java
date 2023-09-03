package problems.arrays;

public class RainWater {
    public static int computeMaxWaterStored(int[] heights) {
        int[] leftMaxHeight = new int[heights.length];
        int[] rightMaxHeight = new int[heights.length];
        int n = heights.length;
        int capacity = 0;
        leftMaxHeight[0] = heights[0];
        rightMaxHeight[n - 1] = heights[n - 1];
        for(int i = 1; i < n; i++) {
            leftMaxHeight[i] = Integer.max(leftMaxHeight[i - 1], heights[i]);
            rightMaxHeight[n - i - 1] = Integer.max(heights[n - i - 1], rightMaxHeight[n - i]);
        }
        for(int i = 0; i < n; i++) {
            capacity += Integer.min(leftMaxHeight[i], rightMaxHeight[i]) - heights[i];
        }
        return capacity;
    }

    public static void main(String[] args) {
        int arr[] = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(computeMaxWaterStored(arr));
    }
}
