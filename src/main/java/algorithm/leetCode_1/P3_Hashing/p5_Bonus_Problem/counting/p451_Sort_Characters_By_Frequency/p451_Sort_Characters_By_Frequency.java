package algorithm.leetCode_1.P3_Hashing.p5_Bonus_Problem.counting.p451_Sort_Characters_By_Frequency;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class p451_Sort_Characters_By_Frequency {
    public static void main(String[] args) {
        String s = "Aabb";
        System.out.println(frequencySort(s));
    }

    public static String frequencySort(String s) {
        Map<Character, Integer> charMap = new HashMap<>();
        for (Character character : s.toCharArray()) {
            charMap.put(character, charMap.getOrDefault(character, 0) + 1);
        }

        List<Character> sortedChars = charMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .map(Map.Entry::getKey)
                .toList();

        StringBuilder sb = new StringBuilder();
        for (Character character : sortedChars) {
            sb.append(character.toString().repeat(charMap.get(character)));
        }

        return sb.toString();
    }
}
