package problems.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class UniqueSubString {
    public static void findMaxSubString(char[] string) { // [a, b, c, a, e, b, a, c, d]
        Map<Character, Integer> charMap = new HashMap<>();
        int windowLength = 0, tempWindowLength = 0;
        int left = 0, right = 0;
        while(right < string.length) {
            if(charMap.containsKey(string[right]) && charMap.get(string[right]) > left) {
                left = charMap.get(string[right]) + 1;
                tempWindowLength = right - left;
            }
            tempWindowLength++;
            charMap.put(string[right], right);
            windowLength = Integer.max(tempWindowLength, windowLength);
            right++;
        }
        System.out.println("Length : " + windowLength);
    }

    public static void main(String[] args) {
        char[] arr = {'a', 'b', 'c', 'a', 'e', 'b', 'a', 'c', 'd'};
        char[] arr1 = {'p', 'r', 'a', 't', 'e', 'e', 'k', 'b', 'h', 'a', 'i', 'y', 'a'};
        findMaxSubString(arr1);
    }
}
