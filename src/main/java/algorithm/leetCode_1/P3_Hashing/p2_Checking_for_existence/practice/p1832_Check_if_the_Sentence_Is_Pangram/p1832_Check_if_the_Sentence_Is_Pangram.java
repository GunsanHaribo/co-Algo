package algorithm.leetCode_1.P3_Hashing.p2_Checking_for_existence.practice.p1832_Check_if_the_Sentence_Is_Pangram;

import java.util.HashSet;
import java.util.Set;

public class p1832_Check_if_the_Sentence_Is_Pangram {
    public static void main(String[] args) {
        String sentence = "leetcode";

        System.out.println(checkIfPangram(sentence));
    }

    public static boolean checkIfPangram(String sentence) {
        Set<Character> chars = new HashSet<>();
        for (char ch : sentence.toCharArray()) {
            chars.add(ch);
        }

        for (char letter = 'a'; letter <= 'z'; letter++) {
            if(!chars.contains(letter)){
                return false;
            }
        }

        return true;
    }
}
