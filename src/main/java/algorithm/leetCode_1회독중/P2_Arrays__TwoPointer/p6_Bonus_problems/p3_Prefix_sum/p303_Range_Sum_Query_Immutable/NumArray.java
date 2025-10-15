package algorithm.leetCode_1회독중.P2_Arrays__TwoPointer.p6_Bonus_problems.p3_Prefix_sum.p303_Range_Sum_Query_Immutable;

public class NumArray {
    int[] prefixSums;

    public NumArray(int[] nums) {
        prefixSums = new int[nums.length];
        prefixSums[0] = nums[0];
        for (int i = 0; i < nums.length-1; i++) {
            prefixSums[i + 1] = prefixSums[i] + nums[i + 1];
        }
    }

    public int sumRange(int left, int right) {
        if (left == 0) {
            return prefixSums[right];
        }

        return prefixSums[right] - prefixSums[left-1];
    }

    public static void main(String[] args) {
        NumArray numArray = new NumArray(new int[]{-2, 0, 3, -5, 2, -1});
        System.out.println(numArray.sumRange(0, 2));
        System.out.println(numArray.sumRange(2, 5));
        System.out.println(numArray.sumRange(0, 5));
    }
}
