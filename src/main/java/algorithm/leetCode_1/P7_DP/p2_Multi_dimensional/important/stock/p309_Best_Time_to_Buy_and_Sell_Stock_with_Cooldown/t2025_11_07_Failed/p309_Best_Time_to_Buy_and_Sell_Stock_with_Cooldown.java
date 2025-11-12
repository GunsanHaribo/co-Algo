package algorithm.leetCode_1.P7_DP.p2_Multi_dimensional.important.stock.p309_Best_Time_to_Buy_and_Sell_Stock_with_Cooldown.t2025_11_07_Failed;

public class p309_Best_Time_to_Buy_and_Sell_Stock_with_Cooldown {

  public static void main(String[] args) {
    p309_Best_Time_to_Buy_and_Sell_Stock_with_Cooldown solver = new p309_Best_Time_to_Buy_and_Sell_Stock_with_Cooldown();
    int[] prices = {1, 2, 3, 0, 2}; // 3

    System.out.println(solver.maxProfit(prices));
  }

  public int maxProfit(int[] prices) {
    int n = prices.length;
    // 현재 위치, 직전 판매 여부(0이면 yes, 1이면 ㄴㄴ), 현재 가지고 있는지(0이면 yes, 1이면 ㄴㄴ)
    int[][][] dp = new int[n][2][2];

    for (int i = n - 1; i >= 0; i--) {
      for (int holding = 0; holding < 2; holding++) {
        for (int previousSelling = 0; previousSelling < 2; previousSelling++) {
          // 이미 판매한 경우
          if (holding == 0) {
            // 바로 이전에 판매 했을 경우 -> 구매 불가
            if(previousSelling == 1){
              dp[i][previousSelling][holding] = 1;
            }else{
              // 바로 이전에 판매 안했을 경우 -> 구매가능
              dp[i][previousSelling][holding] = 1;
            }
          }

          // 주식을 구매한 경우
          if (holding == 1 && previousSelling == 1) {
            // 판매 가능
            dp[i][previousSelling][holding] = 1;
            // previousSelling ==0 일 경우가 없긴한데 해줘야되나?, 해준다면 뭘로 채줘야되니
          }
        }
      }
    }

    return 0;
  }

}
