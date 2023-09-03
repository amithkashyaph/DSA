package problems.stacks;

import java.util.Stack;

public class BalancedParanthesis {


    public static boolean checkBalance(String A) {
        StringBuilder b = new StringBuilder();
        Stack<Character> paranthesis = new Stack<>();
        for(int i = 0; i < A.length(); i++) {
            switch (A.charAt(i)) {
                case '(', '{', '[': {
                    paranthesis.push(A.charAt(i));
                    break;
                }
                case ')', '}', ']': {
                    char ch = A.charAt(i);

                    if(paranthesis.size() == 0)  return false;
                    char poppedChar = paranthesis.pop();
                    if(ch == ')' && poppedChar != '(') {
                        return false;
                    }
                    if(ch == '}' && poppedChar != '{') {
                        return false;
                    }
                    if(ch == ']' && poppedChar != '[') {
                        return false;
                    }
                }
            }
        }
        if(paranthesis.size() != 0) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(checkBalance("{([])}"));
        System.out.println(checkBalance("(){"));
        System.out.println(checkBalance("()[]"));

    }
}
