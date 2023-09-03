package problems.dynamicprogramming;

public class MinNosToRepresentANoAsSumOfSquares {

    public static int ans = Integer.MAX_VALUE;

    public static int minNosToRepresentANoAsSumOfSquares(int n) {
        if(n == 0 || n == 1) {
            return n;
        }
        for(int i = 1; i * i < n; i++) {
             ans = Math.min(ans, 1 + minNosToRepresentANoAsSumOfSquares(n - (i * i)));
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(minNosToRepresentANoAsSumOfSquares(12));
    }
}
