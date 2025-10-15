package algorithm.leetCode_1회독중.P7_DP.p1_d1.example.p300_Longest_Increasing_Subsequence.t2025_10_15;

import java.util.Arrays;

public class p300_Longest_Increasing_Subsequence {

  public static void main(String[] args) {
    p300_Longest_Increasing_Subsequence solver = new p300_Longest_Increasing_Subsequence();
    int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};

    System.out.println(solver.lengthOfLIS(nums));
  }


  public int lengthOfLIS(int[] nums) {
    int n = nums.length;
    int[] dp = new int[n];
    Arrays.fill(dp, 1);

    int answer = 1;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < i; j++) {
        if (nums[i] > nums[j]) {
          dp[i] = Math.max(dp[i], dp[j] + 1); // 이전 것들하고 비교
          answer = Math.max(dp[i], answer);
        }
      }
    }

    return answer;
  }

}
