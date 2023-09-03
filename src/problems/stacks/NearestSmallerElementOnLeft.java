package problems.stacks;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NearestSmallerElementOnLeft {

    public static void findNearestSmallerElement(int[] arr) {
        List<Integer> ans = new ArrayList<>();
        Stack<Integer> s = new Stack<>();
        for(int i = 0; i < arr.length; i++) {
            if(s.isEmpty() && i == 0) {
                ans.add(-1);
            } else {
                if(arr[i] > s.peek()) {
                    ans.add(s.peek());
                } else if(arr[i] < s.peek()) {
                    while(!s.isEmpty() && arr[i] <= s.peek()) {
                        s.pop();
                    }
                    if(!s.isEmpty()) {
                        ans.add(s.peek());
                    } else {
                        ans.add(-1);
                    }
                }
            }
            s.push(arr[i]);
        }

        for(int i : ans) {
            System.out.print(i + "  ");
        }
    }

    public static void main(String[] args) {
        findNearestSmallerElement(new int[]{4, 6, 10, 11, 7, 8, 3, 5, 3});
    }
}
