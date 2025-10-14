package algorithm.leetCode_1회독중.P3_Hashing.p4_More_hashing_examples.p383_Ransom_Note;

import java.util.HashMap;
import java.util.Map;

public class p383_Ransom_Note {
    public static void main(String[] args) {
        String ransomNote = "aa";
        String magazine = "ab";

        System.out.println(canConstruct(ransomNote, magazine));
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> ranCount = getCharacterIntegerMap(ransomNote);
        Map<Character, Integer> maCount = getCharacterIntegerMap(magazine);

        return isCover(ranCount, maCount);
    }

    private static boolean isCover(Map<Character, Integer> ranCount, Map<Character, Integer> maCount) {
        for (Map.Entry<Character, Integer> entry : ranCount.entrySet()) {
            Integer maValue = maCount.get(entry.getKey());
            if (maValue == null) {
                return false;
            }
            if (maValue < entry.getValue()) {
                return false;
            }
        }
        return true;
    }

    private static Map<Character, Integer> getCharacterIntegerMap(String magazine) {
        char[] charArray1 = magazine.toCharArray();
        Map<Character, Integer> maCount = new HashMap<>();
        for (char c1 : charArray1) {
            Integer orDefault = maCount.getOrDefault(c1, 0);
            maCount.put(c1, orDefault + 1);
        }
        return maCount;
    }
}
