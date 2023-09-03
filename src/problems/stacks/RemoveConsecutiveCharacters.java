package problems.stacks;

import java.util.Stack;

public class RemoveConsecutiveCharacters {

    public static String removeConsecutiveChars(String A) {
        Stack<Character> s1 = new Stack<>();
        StringBuilder ans = new StringBuilder();
        for(int i = 0; i < A.length(); i++) {
            if(s1.empty()) {
                s1.push(A.charAt(i));
                ans.append(A.charAt(i));
            } else {
                if(s1.peek() != A.charAt(i)) {
                    s1.push(A.charAt(i));
                    ans.append(A.charAt(i));
                } else {
                    s1.pop();
                    ans.deleteCharAt(ans.length() - 1);
                }
            }
        }


        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(removeConsecutiveChars("abbac"));
    }
}
