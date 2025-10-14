package algorithm.leetCode_1회독중.P2_Arrays__TwoPointer.p3_Sliding_window.p463_Maximum_Average_Subarray1;

import java.util.Arrays;

public class Maximum_Average_Subarray1_643 {

  public static void main(String[] args) {
    int[] nums = {1, 12, -5, -6, 50, 3};
    int k = 4;

    System.out.println(findMaxAverage(nums, k));
  }

  public static double findMaxAverage(int[] nums, int k) {
    int left = 0;
    int sum = Arrays.stream(nums, left, k)
        .sum();
    double max = (double) sum / k;

    for (int right = k; right < nums.length; right++) {
      sum -= nums[left++];
      sum += nums[right];
      max = Math.max(max, (double) sum / k);
    }

    return max;
  }
}
