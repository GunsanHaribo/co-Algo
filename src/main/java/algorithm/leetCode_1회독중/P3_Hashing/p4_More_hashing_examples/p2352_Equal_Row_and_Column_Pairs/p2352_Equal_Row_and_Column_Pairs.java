package algorithm.leetCode_1회독중.P3_Hashing.p4_More_hashing_examples.p2352_Equal_Row_and_Column_Pairs;

import java.util.HashMap;
import java.util.Map;

public class p2352_Equal_Row_and_Column_Pairs {
    public static void main(String[] args) {
//        int[][] dd = {
//                {11, 1},
//                {1, 11}
//        };

        int[][] dd = { {3,1,2,2},{1,4,4,5},{2,4,2,2},{2,4,2,2}};

        System.out.println(equalPairs(dd));
    }

    public static int equalPairs(int[][] grid) {
        Map<String, Integer> sameRowCounter = sameRowCounter(grid);
        Map<String, Integer> sameColumnCounter = sameColumnCounter(grid);

        int count = 0;
        for (Map.Entry<String, Integer> entry : sameRowCounter.entrySet()) {
            Integer sameColumnCount = sameColumnCounter.get(entry.getKey());
            if (sameColumnCount != null) {
                count += entry.getValue() * sameColumnCount;
            }
        }

        return count;
    }

    private static Map<String, Integer> sameColumnCounter(int[][] grid) {
        Map<String, Integer> countMap = new HashMap<>();
        for (int column = 0; column < grid.length; column++) {
            int[] colum = new int[grid.length];
            for (int row = 0; row < grid.length; row++) {
                colum[row] = grid[row][column];
            }

            String key = createKey(colum);
            countMap.put(key, countMap.getOrDefault(key, 0) + 1);
        }

        return countMap;
    }

    private static Map<String, Integer> sameRowCounter(int[][] grid) {
        Map<String, Integer> countMap = new HashMap<>();
        for (int[] row : grid) {
            String key = createKey(row);
            countMap.put(key, countMap.getOrDefault(key, 0) + 1);
        }

        return countMap;
    }

    private static String createKey(int[] array) {
        StringBuilder sb = new StringBuilder();
        for (int element : array) {
            sb.append(element);
            sb.append('-');
        }

        return sb.toString();
    }
}
