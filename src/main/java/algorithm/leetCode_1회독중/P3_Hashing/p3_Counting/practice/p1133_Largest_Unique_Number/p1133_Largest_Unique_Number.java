package algorithm.leetCode_1회독중.P3_Hashing.p3_Counting.practice.p1133_Largest_Unique_Number;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class p1133_Largest_Unique_Number {
    public static void main(String[] args) {
        int[] nums = {9,9,8,8};
        int result = largestUniqueNumber(nums);
        System.out.println(result);



        int[] nums2 = {5,7,3,9,4,9,8,3,1};
        int result2 = largestUniqueNumber(nums2);
        System.out.println(result2);
    }

    public static int largestUniqueNumber(int[] nums) {
        Map<Integer, Integer> results = new HashMap<>();

        for (int num : nums) {
            results.put(num, results.getOrDefault(num, 0) + 1);
        }

        return results.entrySet()
                .stream()
                .filter(entry ->entry.getValue() ==1)
                .max(Comparator.comparing(Map.Entry::getKey))
                .map(Map.Entry::getKey)
                .orElse(-1);
    }
}
