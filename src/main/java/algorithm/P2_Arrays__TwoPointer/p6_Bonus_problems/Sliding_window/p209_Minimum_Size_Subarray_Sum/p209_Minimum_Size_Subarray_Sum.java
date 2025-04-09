package algorithm.P2_Arrays__TwoPointer.p6_Bonus_problems.Sliding_window.p209_Minimum_Size_Subarray_Sum;

public class p209_Minimum_Size_Subarray_Sum {
    public static void main(String[] args) {
        int target = 7;
        int[] nums = {2, 3, 1, 2, 4, 3};
        int result = minSubArrayLen(target, nums);
        System.out.println(result);
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int sum = 0;
        int minSize = Integer.MAX_VALUE;

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];

            while (sum >= target) {
                minSize = Math.min(minSize, right - left + 1);
                sum -= nums[left];
                left++;
            }
        }

        if(minSize ==Integer.MAX_VALUE){
            return  0;
        }

        return minSize;
    }
}
