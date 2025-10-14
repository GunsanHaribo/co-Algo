package algorithm.leetCode_1회독중.P3_Hashing.p4_More_hashing_examples.p3_Longest_Substring_Without_Repeating_Characters;

import java.util.HashSet;
import java.util.Set;

public class p3_Longest_Substring_Without_Repeating_Characters {
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        int left = 0;
        int maxSize = 0;
        Set<Character> tempSavedChar = new HashSet<>();
        char[] charArray = s.toCharArray();
        for (int right = 0; right < charArray.length; right++) {
            while (tempSavedChar.contains(charArray[right])) {
                tempSavedChar.remove(charArray[left]);
                left++;
            }

            tempSavedChar.add(charArray[right]);
            maxSize = Math.max(tempSavedChar.size(), maxSize);
        }

        return maxSize;
    }
}
