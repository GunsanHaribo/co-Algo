package algorithm.leetCode_1.P7_DP.p2_Multi_dimensional.important.stock.p188_Best_Time_to_Buy_and_Sell_Stock_IV.t2025_11_04;

import java.util.ArrayList;
import java.util.List;

public class p188_Best_Time_to_Buy_and_Sell_Stock_IV {

  public static void main(String[] args) {
    p188_Best_Time_to_Buy_and_Sell_Stock_IV solver = new p188_Best_Time_to_Buy_and_Sell_Stock_IV();
    int k = 2;
    int[] prices = {2, 4, 1};

    System.out.println(solver.maxProfit(k, prices));
  }

  // 일단 패
  public int maxProfit(int k, int[] prices) {
    int priceSize = prices.length;
    List<StockRecord> dp = new ArrayList<>();

//    for () {
//
//    }
//    dp[priceSize - 1];
    return 0;
  }

  // 아 근데 earn이 같으면 어떻게 하지?
  // 주식을 가지고 있는걸 적어주는게 좋을 겉 같기도 하고, 아니면, 처음만 해서
  // 아니 그리고 수익이 다 같으면 어떻게 해야하지?, 다음 행보에 나머지 요소들이 영향을 더 미칠 수도 있는데
  // 수익이 같으면, 주식을 가지고 있는게 항상 유리하지는 않다.
  // 그러면 2가지 경우로 진행해야되는데, 아니아니 수익이 같은 것만 다음 연산하자
  // 숫자가 상당히 더러워지긴하는데;;, 어쩔 수 없지 않나?
  private record StockRecord(int earn, int havingStockPrices, boolean isHaving, int buyK,
                             int sellK) {

  }

}
