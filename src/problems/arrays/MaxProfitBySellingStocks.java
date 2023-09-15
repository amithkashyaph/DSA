package problems.arrays;

public class MaxProfitBySellingStocks {

    public static int calculateMaxProfit(int[] arr) {
        int min = arr[0];
        int cost = 0;
        int profit = 0;

        for(int i = 1; i < arr.length; i++) {
            cost = arr[i] - min;
            profit = Math.max(profit, cost);
            min = Math.min(min, arr[i]);
        }

        return profit;
    }

    public static void main(String[] args) {
        int[] arr= {7, 1, 4, 5, 6, 2, 7, 1, 10};
        System.out.println(calculateMaxProfit(arr));
    }
}
