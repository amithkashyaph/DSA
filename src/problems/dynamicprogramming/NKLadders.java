package problems.dynamicprogramming;

public class NKLadders {
    public static int NKLaddersOptimalSol(int n, int k) {
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;
        for(int i = 2; i <= k; i++) {
            dp[i] = 2 * dp[i - 1];
        }

        for(int i = k + 1; i <= n; i++) {
            dp[i] = 2*dp[i - 1] - dp[i - k - 1];
        }
        return dp[n];
    }

    public static int NKLaddersBUSol(int n, int k) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for(int i = 1; i <= n; i++) {
            for(int jump = 1; jump <= k; jump++) {
                if(i - jump >= 0) {
                    dp[i] += dp[i - jump];
                }

            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(NKLaddersOptimalSol(4, 3));
        System.out.println(NKLaddersBUSol(4, 3));
    }
}
