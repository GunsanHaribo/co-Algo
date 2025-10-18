package algorithm.leetCode_1.P3_Hashing.p5_Bonus_Problem.counting.p1748_Sum_of_Unique_Elements;

import java.util.HashMap;
import java.util.Map;

public class p1748_Sum_of_Unique_Elements {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};

        System.out.println(sumOfUnique(nums));
    }

    public static int sumOfUnique(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();

        for (int n : nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }

        return count.entrySet()
                .stream()
                .filter(integerIntegerEntry -> integerIntegerEntry.getValue() == 1)
                .map(Map.Entry::getKey)
                .mapToInt(Integer::intValue)
                .sum();
    }
}
