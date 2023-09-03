package problems.slidingwindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class SmallestDistictWindow {


        public static int findSubString(String str) {
            // Your code goes here
            HashMap<Character, Integer> freqMap = new HashMap<>();
            HashSet<Character> uniqueCharSet = new HashSet<>();
            int head = 0;
            int tail = 0;
            int uniqCharCount = 0;
            int ans = str.length();
            for(int i = 0; i < str.length(); i++) {
                uniqueCharSet.add(str.charAt(i));
            }
            while(head < str.length()) {
                if(!freqMap.containsKey(str.charAt(head)) || (freqMap.get(str.charAt(head)) == 0)) {
                    freqMap.put(str.charAt(head), 1);
                    uniqCharCount++;
                } else {
                    int tempFreq = freqMap.get(str.charAt(head));
                    freqMap.put(str.charAt(head), ++tempFreq);
                }
                while(uniqCharCount == uniqueCharSet.size()) {
                    ans = Integer.min(ans, head- tail + 1);
                    char temp = str.charAt(tail);
                    int tempFreq = freqMap.get(temp);
                    freqMap.put(temp, --tempFreq);
                    int charCount = freqMap.get(temp);
                    tail++;
                    if(charCount == 0) {
                        uniqCharCount--;
                        break;
                    }
                }

                head++;
            }
            return ans;
        }

        public static void main(String[] args) {
            System.out.println(findSubString("aaab"));
        }

}
