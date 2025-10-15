package algorithm.leetCode_1회독중.P3_Hashing.p5_Bonus_Problem.checking_for_existence.p217_Contains_Duplicate;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class p217_Contains_Duplicate {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};

        System.out.println(extracted(nums));
    }

    private static boolean extracted(int[] nums) {
        Set<Integer> collect = Arrays.stream(nums).boxed().collect(Collectors.toSet());

        return collect.size() != nums.length;
    }

}

