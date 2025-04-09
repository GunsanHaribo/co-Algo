package algorithm.P2_Arrays__TwoPointer.p6_Bonus_problems.Two_pointers.p283_Move_Zeroes;

import java.util.Arrays;

public class p283_Move_Zeroes {
    public static void main(String[] args) {
        int[] nums = {1, 2};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void moveZeroes(int[] nums) {
        int start = 0;
        for (int end = 0; end < nums.length; end++) {
            if (nums[end] != 0) {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;

                start++;
            }
        }
    }
}
