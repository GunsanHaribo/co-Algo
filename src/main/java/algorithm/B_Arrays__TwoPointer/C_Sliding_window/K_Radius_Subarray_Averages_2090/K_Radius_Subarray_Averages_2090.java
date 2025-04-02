package algorithm.B_Arrays__TwoPointer.C_Sliding_window.K_Radius_Subarray_Averages_2090;

import java.util.Arrays;

public class K_Radius_Subarray_Averages_2090 {

  public static void main(String[] args) {
    int[] nums = {7, 4, 3, 9, 1, 8, 5, 2, 6};
    int k = 3;
    System.out.println(Arrays.toString(getAverages(nums, k)));
  }

  public static int[] getAverages(int[] nums, int k) {
    int n = nums.length;
    int[] results = new int[n];
    Arrays.fill(results, -1);

    int windowSize = 2 * k + 1;
    if (n < windowSize) return results;

    int sum = 0;
    for (int i = 0; i < windowSize; i++) {
      sum += nums[i];
    }

    for (int index = k; index < n - k; index++) {
      results[index] = (int) (sum / windowSize);
      if (index + k + 1 < n) {
        sum += nums[index + k + 1] - nums[index - k];
      }
    }

    return results;
  }
}
