package algorithm.leetCode_1회독중.P2_Arrays__TwoPointer.p6_Bonus_problems.p3_Prefix_sum.p724_Find_Pivot_Index;

public class p724_Find_Pivot_Index {
    public static void main(String[] args) {
        int[] nums = {-1, -1, -1, -1, 0, 1};
        System.out.println(pivotIndex(nums));
    }

    public static int pivotIndex(int[] nums) {
        int[] prefixSums = new int[nums.length];
        prefixSums[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefixSums[i] = prefixSums[i - 1] + nums[i];
        }

        int min = Integer.MAX_VALUE;
        for (int center = 0; center < nums.length; center++) {
            int left = center - 1;
            int leftSum = 0;
            if (center > 0) {
                leftSum = prefixSums[left];
            }

            int rightSum = prefixSums[nums.length - 1] - prefixSums[center];
            if (center == nums.length - 1) {
                rightSum = 0;
            }

            if (leftSum == rightSum) {
                min = Math.min(center, min);
            }
        }

        if (min == Integer.MAX_VALUE) {
            return -1;
        }

        return min;
    }
}
