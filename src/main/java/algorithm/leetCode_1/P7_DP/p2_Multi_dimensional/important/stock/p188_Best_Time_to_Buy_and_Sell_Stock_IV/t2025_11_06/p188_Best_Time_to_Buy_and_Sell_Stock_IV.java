package algorithm.leetCode_1.P7_DP.p2_Multi_dimensional.important.stock.p188_Best_Time_to_Buy_and_Sell_Stock_IV.t2025_11_06;

public class p188_Best_Time_to_Buy_and_Sell_Stock_IV {

  public static void main(String[] args) {
    p188_Best_Time_to_Buy_and_Sell_Stock_IV solver = new p188_Best_Time_to_Buy_and_Sell_Stock_IV();
    int k = 2;
    int[] prices = {2, 4, 1};

    System.out.println(solver.maxProfit(k, prices));
  }

  public int maxProfit(int k, int[] prices) {
    int n = prices.length;
    int[][][] dp = new int[n + 1][2][k + 1];
    for (int i = n - 1; i >= 0; i--) {
      for (int remain = 1; remain <= k; remain++) {
        for (int holding = 0; holding < 2; holding++) {
          int ans = dp[i + 1][holding][remain];
          if (holding == 1) {
            ans = Math.max(ans, prices[i] + dp[i + 1][0][remain - 1]);
          } else {
            ans = Math.max(ans, -prices[i] + dp[i + 1][1][remain]);
          }
          dp[i][holding][remain] = ans;
        }
      }
    }

    return dp[0][0][k];
  }

}
