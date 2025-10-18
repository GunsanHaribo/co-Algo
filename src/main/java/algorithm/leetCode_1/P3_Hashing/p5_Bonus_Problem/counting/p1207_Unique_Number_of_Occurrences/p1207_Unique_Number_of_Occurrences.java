package algorithm.leetCode_1.P3_Hashing.p5_Bonus_Problem.counting.p1207_Unique_Number_of_Occurrences;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class p1207_Unique_Number_of_Occurrences {
    public static void main(String[] args) {
        int[] arr = {1,2};

        System.out.println(uniqueOccurrences(arr));
    }

    public static boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : arr) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        Set<Integer> valueSet = new HashSet<>(count.values());

        return valueSet.size() == count.size();
    }
}
