package problems.recursion;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.TreeMap;

public class PermutationOfIntegerArray {

    static List<List<Integer>> ans = new ArrayList<>();
    public static void generatePermutations(int[] arr, int[] visited, List<Integer> set) {
        if(set.size() == arr.length) {
           ans.add(new ArrayList<>(set));
           return;
        }

        for(int i = 0; i < arr.length; i++) {
            if(visited[i] == 0) {
                set.add(arr[i]);
                visited[i] = 1;
                generatePermutations(arr, visited, set);
                visited[i] = 0;
                set.remove(set.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {8, 2, 7, 4};
        int[] visited = new int[arr.length];
        List<Integer> set = new ArrayList<>();

        generatePermutations(arr, visited, set);

        for(List<Integer> list : ans) {
            for(Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

}
