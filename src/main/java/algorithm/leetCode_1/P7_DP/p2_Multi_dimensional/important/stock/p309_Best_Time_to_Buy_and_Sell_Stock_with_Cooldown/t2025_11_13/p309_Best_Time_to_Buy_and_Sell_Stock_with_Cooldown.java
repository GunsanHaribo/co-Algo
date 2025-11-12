package algorithm.leetCode_1.P7_DP.p2_Multi_dimensional.important.stock.p309_Best_Time_to_Buy_and_Sell_Stock_with_Cooldown.t2025_11_13;

public class p309_Best_Time_to_Buy_and_Sell_Stock_with_Cooldown {

  public static void main(String[] args) {
    p309_Best_Time_to_Buy_and_Sell_Stock_with_Cooldown solver = new p309_Best_Time_to_Buy_and_Sell_Stock_with_Cooldown();

//    int[] prices = {1, 2, 3, 0, 2};
    int[] prices = {1};

    System.out.println(solver.maxProfit(prices));
  }

  public int maxProfit(int[] prices) {
    int n = prices.length;
    if (n == 0) {
      return 0;
    }
    final int NEG = -1_000_000_000;

    // dp[i][0]=hold, dp[i][1] = sold, dp[i][2]=rest
    int[][] dp = new int[n][3];
    dp[0][0] = -prices[0];
    dp[0][1] = NEG;
    dp[0][2] = 0;

    for (int i = 1; i < n; i++) {
      dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] - prices[i]);
      dp[i][1] = dp[i - 1][0] + prices[i];
      dp[i][2] = Math.max(dp[i - 1][1], dp[i - 1][2]);
    }

    return Math.max(dp[n - 1][1], dp[n - 1][2]);
  }

}
