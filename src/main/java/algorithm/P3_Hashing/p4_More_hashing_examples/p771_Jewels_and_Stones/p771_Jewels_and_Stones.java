package algorithm.P3_Hashing.p4_More_hashing_examples.p771_Jewels_and_Stones;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class p771_Jewels_and_Stones {
    public static void main(String[] args) {
        String jewels = "aA";
        String stones = "aAAAbbbb";

        System.out.println(numJewelsInStones(jewels, stones));
    }

    public static int numJewelsInStones(String jewels, String stones) {
        char[] totalStones = stones.toCharArray();
        Map<Character, Integer> stoneCount = new HashMap<>();
        for (char stone : totalStones) {
            stoneCount.put(stone, stoneCount.getOrDefault(stone, 0) + 1);
        }

        Set<Character> jewelSet = jewels.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toSet());
        return stoneCount.entrySet()
                .stream()
                .filter(stone -> jewelSet.contains(stone.getKey()))
                .mapToInt(Map.Entry::getValue)
                .sum();
    }
}
