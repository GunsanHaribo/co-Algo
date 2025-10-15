package algorithm.leetCode_1회독중.P2_Arrays__TwoPointer.p6_Bonus_problems.p1_Two_pointers.p557_Reverse_Word_in_a_String3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class p557_Reverse_Word_in_a_String3 {
    public static void main(String[] args) {
        String input = "Let's take LeetCode contest";
        String output = reverseWords(input);
        System.out.println(output);
    }

    public static String reverseWords(String s) {
        List<String> chunks = Arrays.stream(s.split(" "))
                .toList();

        List<String> result = new ArrayList<>();
        for (String chunk : chunks) {
            int left = 0;
            int right = chunk.length() - 1;
            char[] charArray = chunk.toCharArray();
            while (left < right) {
                char temp = charArray[left];
                charArray[left] = charArray[right];
                charArray[right] = temp;
                left++;
                right--;
            }

            result.add(new String(charArray));
        }

        return String.join(" ", result);
    }
}
