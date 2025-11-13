package algorithm.leetCode_1.P7_DP.p2_Multi_dimensional.important.stock.p714_Best_Time_to_Buy_and_Sell_Stock_with_Transaction_Fee.t2025_11_07;

public class p714_Best_Time_to_Buy_and_Sell_Stock_with_Transaction_Fee {

  public static void main(String[] args) {
    p714_Best_Time_to_Buy_and_Sell_Stock_with_Transaction_Fee solver = new p714_Best_Time_to_Buy_and_Sell_Stock_with_Transaction_Fee();
//    int[] prices = {1, 3, 2, 8, 4, 9};
//    int fee = 2;

    int[] prices = {1, 3, 7, 5, 10, 3};
    int fee = 3;

//    int[] prices = {9, 8, 7, 1, 2};
//    int fee = 3; // 0

    System.out.println(solver.maxProfit(prices, fee));
  }

  public int maxProfit(int[] prices, int fee) {
    int n = prices.length;
    int[][] dp = new int[n][2]; // 이익
    // dp[][0] = holding, dp[][1] = not holding

    dp[0][0] = -prices[0];
//    dp[0][1] = -1_000_000_000; // 아 여기서 터지는구나, 이부분 안터지게 조정해야함
    dp[0][1] = 0; // 홀딩을 안한다면 이익이 0아닌까?, 이걸 선택할 수도 있는거잖아, 선택이 안될 이유가 없는데
    for (int i = 1; i < n; i++) {
      dp[i][0] = Math.max(-prices[i] + dp[i - 1][1], dp[i - 1][0]);
      dp[i][1] = Math.max(prices[i] + dp[i - 1][0] - fee, dp[i - 1][1]);
    }

    return dp[n - 1][1];
  }

}
