package algorithm.P2_Arrays__TwoPointer.p6_Bonus_problems.Two_pointers.p283_Move_Zeroes;

import java.util.Arrays;

public class p283_Move_Zeroes {
    public static void main(String[] args) {
        int[] nums = {0};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void moveZeroes(int[] nums) {
        int start = 0;
        int end = 0;
        while (end < nums.length) {
            if (nums[end] != 0) {
                nums[start] = nums[end];
                nums[end] = 0;
                start++;
            }
            end++;
        }
    }
}
