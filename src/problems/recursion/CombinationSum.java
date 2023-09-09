package problems.recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    static List<List<Integer>> ans = new ArrayList<>();

    public static void getAllCombinationForGivenSum(int[] arr, int i, int sum, int len, List<Integer> numList) {
        if(i == len) {
            if(sum == 0) {
                ans.add(new ArrayList<>(numList));
            }
            return;
        }

        if(arr[i] <= sum) {
            numList.add(arr[i]);

            getAllCombinationForGivenSum(arr, i, sum - arr[i], arr.length, numList);
            numList.remove(numList.size() - 1);
        }

        getAllCombinationForGivenSum(arr, i + 1, sum, len, numList);
    }

    public static void main(String[] args) {
        List<Integer> numList = new ArrayList<>();
        int[] arr = {2, 3, 1, 7, 6, 5};
        int sum = 7;


        getAllCombinationForGivenSum(arr, 0, 7, arr.length, numList);

        for(List<Integer> l : ans) {
            for(Integer i : l) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
