package problems.recursion;

public class CheckPalindrome {

    public static boolean isPlaindrome(String s, int i, int j) {
        if(i >= j) {
            return true;
        }

        if(s.charAt(i) != s.charAt(j)) {
            return false;
        }

        return isPlaindrome(s, i + 1, j - 1);

    }

    public static void main(String[] args) {
        String s = "aabcddcbaa";
        System.out.println(isPlaindrome(s, 0, s.length() - 1));
    }
}
