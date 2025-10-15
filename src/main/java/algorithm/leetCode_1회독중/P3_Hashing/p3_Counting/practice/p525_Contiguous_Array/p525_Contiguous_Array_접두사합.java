package algorithm.leetCode_1회독중.P3_Hashing.p3_Counting.practice.p525_Contiguous_Array;

import java.util.HashMap;
import java.util.Map;

public class p525_Contiguous_Array_접두사합 {
    public static void main(String[] args) {
        int[] nums = {0,1,1,1,1,1,0,0,0};
        int results = findMaxLength(nums);
        System.out.println(results);
    }

    public static int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int maxLength = 0;
        int sum = 0;

        for (int right = 0; right < nums.length; right++) {
            sum += (nums[right] == 0) ? -1 : 1;

            if (map.containsKey(sum)) {
                maxLength = Math.max(maxLength, right - map.get(sum));
            } else {
                map.put(sum, right);
            }
        }

        return maxLength;
    }
}
