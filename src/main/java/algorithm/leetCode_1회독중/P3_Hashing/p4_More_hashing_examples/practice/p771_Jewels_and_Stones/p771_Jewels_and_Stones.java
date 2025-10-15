package algorithm.leetCode_1회독중.P3_Hashing.p4_More_hashing_examples.practice.p771_Jewels_and_Stones;

import java.util.Set;
import java.util.stream.Collectors;

public class p771_Jewels_and_Stones {
    public static void main(String[] args) {
        String jewels = "aA";
        String stones = "aAAAbbbb";

        System.out.println(numJewelsInStones(jewels, stones));
    }

    public static int numJewelsInStones(String jewels, String stones) {
        Set<Character> jewelSet = jewels.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toSet());

        return (int) stones.chars()
                .mapToObj(c -> (char) c)
                .filter(jewelSet::contains)
                .count();
    }
}
