package algorithm.leetCode_1회독중.P7_DP.p1_1D_problems.practice.p70_ClimbingStairs.t2025_10_17;

public class p70_ClimbingStairs {

  public static void main(String[] args) {
    p70_ClimbingStairs solver = new p70_ClimbingStairs();
//    int n = 2;
//    int n = 3;
    int n = 1;
    System.out.println(solver.climbStairs(n));
  }


  public int climbStairs(int n) {
    int[] dp = new int[n];
    for (int i = 0; i < n; i++) {
      if (i == 0) {
        dp[i] = 1;
        continue;
      }
      if (i == 1) {
        dp[i] = 2;
        continue;
      }

      dp[i] = dp[i - 1] + dp[i - 2];
    }

    return dp[n - 1];
  }

}
