package algorithm.leetCode_1.P3_Hashing.p3_Counting.practice.p2225_Find_Players_With_Zero_or_Lossess;

import java.util.*;

public class p2225_Find_Players_With_Zero_or_Lossess {
    public static void main(String[] args) {
//        int[][] matches = {{1,3},{2,3},{3,6},{5,6},{5,7},{4,5},{4,8},{4,9},{10,4},{10,9}};
        int[][] matches = {{2,3},{1,3},{5,4},{6,4}};

        List<List<Integer>> winners = findWinners(matches);
        System.out.println(winners);
    }

    public static List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> looseCounts = new HashMap<>();

        for (int[] match : matches) {
            looseCounts.put(match[0], looseCounts.getOrDefault(match[0], 0));
            looseCounts.put(match[1], looseCounts.getOrDefault(match[1], 0) + 1);
        }

        List<Integer> zero = looseCounts.entrySet()
                .stream()
                .filter(count -> count.getValue() == 0)
                .map(Map.Entry::getKey)
                .sorted()
                .toList();

        List<Integer> one = looseCounts.entrySet()
                .stream()
                .filter(count -> count.getValue() == 1)
                .map(Map.Entry::getKey)
                .sorted()
                .toList();

        return List.of(zero, one);
    }
}
