package algorithm.leetCode_1.P3_Hashing.p5_Bonus_Problem.counting.p3005_Count_Elements_With_Maximum_Frequency;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class p3005_Count_Elements_With_Maximum_Frequency {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        System.out.println(maxFrequencyElements(nums));
    }

    public static int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        Integer max = count.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getValue)
                .get();

        List<Map.Entry<Integer, Integer>> maxEntries = count.entrySet()
                .stream()
                .filter(integerIntegerEntry1 -> integerIntegerEntry1.getValue().equals(max))
                .toList();

        return maxEntries.size() * max;
    }
}
