package problems.arrays;

import java.util.HashSet;
import java.util.Set;

public class LongestBand {

    public static int computeLongestBand(int[] arr) {
        int length = arr.length;
        int count = 0;
        Set<Integer> numSet = new HashSet<>();
        for(int i : arr) {
            numSet.add(i);
        }
        for(int i : arr) {
            if(!numSet.contains(i - 1)) {
                while(numSet.contains(i + 1)) {
                    count++;
                    i++;

                }
            }
            count = Integer.max(Integer.MIN_VALUE, count);
        }
        return count;
    }

    public static void main(String[] args) {
        int a[] = {1,9,3,0,18,5,2,4, 10,12,7,6};
        System.out.println(computeLongestBand(a));
    }
}
