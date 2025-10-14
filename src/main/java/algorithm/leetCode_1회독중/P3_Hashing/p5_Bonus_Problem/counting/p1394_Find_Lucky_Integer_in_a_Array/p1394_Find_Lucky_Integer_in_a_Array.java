package algorithm.leetCode_1회독중.P3_Hashing.p5_Bonus_Problem.counting.p1394_Find_Lucky_Integer_in_a_Array;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class p1394_Find_Lucky_Integer_in_a_Array {
    public static void main(String[] args) {
        int[] arr = {2,2,2,3,3};

        System.out.println(findLucky(arr));
    }

    public static int findLucky(int[] arr) {
        Map<Integer, Integer> countingNums = new HashMap<>();
        for (int num : arr) {
            countingNums.put(num, countingNums.getOrDefault(num, 0) + 1);
        }

        return countingNums.entrySet()
                .stream()
                .filter(integerIntegerEntry -> integerIntegerEntry.getValue().equals(integerIntegerEntry.getKey()))
                .map(Map.Entry::getKey)
                .max(Comparator.comparing(Integer::intValue))
                .orElse(-1);
    }
}
