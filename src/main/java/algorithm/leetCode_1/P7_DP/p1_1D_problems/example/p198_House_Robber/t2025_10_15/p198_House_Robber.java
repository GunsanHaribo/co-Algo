package algorithm.leetCode_1.P7_DP.p1_1D_problems.example.p198_House_Robber.t2025_10_15;

import java.util.HashMap;
import java.util.Map;

public class p198_House_Robber {

  public static void main(String[] args) {
    p198_House_Robber solver = new p198_House_Robber();
//    int[] nums = new int[]{1, 2, 3, 1};
//    int[] nums = new int[]{2, 7, 9, 3, 1};
//    int[] nums = new int[]{2, 1};
    int[] nums = new int[]{2, 1, 1, 2};

    System.out.println(solver.rob(nums));
  }

  Map<Integer, Integer> dp = new HashMap<>();

  public int rob(int[] nums) {
    for (int i = 0; i < nums.length; i++) {
      if (i == 0 || i == 1) {
        dp.put(i, nums[i]);
      }
      Integer previous = dp.get(i - 1);
      if (previous == null) {
        previous = 0;
      }
      Integer morePrevious = dp.get(i - 2);
      if (morePrevious == null) {
        morePrevious = 0;
      }

      dp.put(i, Math.max(previous, nums[i] + morePrevious));
    }

    return dp.get(nums.length - 1);
  }

}
