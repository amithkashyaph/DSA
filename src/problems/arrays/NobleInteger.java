package problems.arrays;

import java.util.ArrayList;
import java.util.Collections;

public class NobleInteger {

    public static int solve(ArrayList<Integer> A) {
        System.out.println(A);

        Collections.sort(A);

        System.out.println(A);

        int ans = 0;
        int len = A.size();
        int great = len;

        if(A.get(len - 1) == 0) {
            ans++;
        }

        for(int i = len - 2; i >= 0; i--) {
            if(A.get(i + 1) != A.get(i)) {
                great = len - i - 1;
            }

            if(A.get(i) == great) {
                System.out.println(A.get(i));
                ans++;
            }
        }

        return ans == 0 ? -1 : ans;
    }

    public static void main(String[] args) {
        int[] arr = {-2,8,8,6,-2,3,-2,-7,3,3,-2,0,4,-3,-4,-2,-1,-10,-4,-2,7,-1,0,-7,3,-7,7,3,2,-4,-5,2,6,5,-2,7,-1,6,-10,4,-9,-10,-6,-2,-3,0,-2,6,-8,4,7,9,-7,9,-8,-2,-7,-10,-9,-3,8,9,1,5,4,9,2,5,-3,-6,-1,-1,-6};

        ArrayList<Integer> input = new ArrayList<>();
        for(int i = 0; i < arr.length; i++) {
            input.add(arr[i]);
        }

        System.out.println(solve(input));
    }

}
