package algorithm.B_Arrays__TwoPointer.D_Prefix_sum.K_RadisusSubarrayAverages;

import java.util.Arrays;

public class K_RadisusSubarrayAverages {

  public static void main(String[] args) {
    int[] nums = {7, 4, 3, 9, 1, 8, 5, 2, 6};
    int k = 3;
    System.out.println(Arrays.toString(getAverages(nums, k)));
  }

  public static int[] getAverages(int[] nums, int k) {
    int[] results = new int[nums.length];
    Arrays.fill(results, -1);

    long[] prefixSums = new long[nums.length];
    prefixSums[0] = nums[0];
    for (int i = 1; i < prefixSums.length; i++) {
      prefixSums[i] = nums[i] + prefixSums[i - 1];
    }

    for (int index = k; index < nums.length - k; index++) {
      long sub;
      if ((index - k - 1) < 0) {
        sub = 0;
      } else {
        sub = prefixSums[index - k - 1];
      }

      results[index] = Math.round((prefixSums[index + k] - sub)/ (2*k+1));
    }

    return results;
  }
}
