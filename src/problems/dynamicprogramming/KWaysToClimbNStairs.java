package problems.dynamicprogramming;

import java.util.HashMap;

public class KWaysToClimbNStairs {
    private static HashMap<Integer, Integer> memoize = new HashMap<>();
    public static int findKWaysToClimbNStairs(int n) {
        if(memoize.containsKey(n)) {
            return memoize.get(n);
        }
        if(n <= 1) {
            memoize.put(n, 1);
            return 1;
        }
        int ans = findKWaysToClimbNStairs(n - 1) + findKWaysToClimbNStairs(n - 2);
        memoize.put(n, ans);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(findKWaysToClimbNStairs(3));
    }
}
