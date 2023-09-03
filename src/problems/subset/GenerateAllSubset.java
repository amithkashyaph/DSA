package problems.subset;

import java.util.ArrayList;
import java.util.List;

public class GenerateAllSubset {
    public static List<List<Integer>> res = new ArrayList<>();
    public static void generateAllPossibleSubset(int[] arr, int n) {
        if(n == -1) {
            return;
        }
        List<Integer> subset = new ArrayList<>();
        int count = 0;
        int nTemp = n;
        while(nTemp != 0) {
            boolean bitSet = (nTemp & 1) == 1 ? true : false;
            if(bitSet) {
                subset.add(arr[count]);
            }
            count++;
            nTemp = nTemp >> 1;
        }
        res.add(subset);
        generateAllPossibleSubset(arr, n - 1);
    }

    public static void main(String[] args) {
        int[] arr = {-3, 6, 4};
        int n = (int) Math.pow(2, arr.length);
        generateAllPossibleSubset(arr, n - 1);
        for(List<Integer> l : res) {
            System.out.println(l);
        }
    }
}
