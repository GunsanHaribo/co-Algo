package algorithm.leetCode_1회독중.P7_DP.multi.practice.p714_Best_Time_to_Buy_and_Sell_Stock_with_Transaction_Fee;

public class p714_Best_Time_to_Buy_and_Sell_Stock_with_Transaction_Fee_실패 {

  public static void main(String[] args) {
    p714_Best_Time_to_Buy_and_Sell_Stock_with_Transaction_Fee_실패 solver = new p714_Best_Time_to_Buy_and_Sell_Stock_with_Transaction_Fee_실패();

    int[] prices = {1,5,9};
    int fee = 2;  // 결과값은 6을 기대합니다.

//    int[] prices = {1,3,7,5,10,3};
//    int fee = 3;

    solver.maxProfit(prices, fee);
    System.out.println(maxProfit);
  }

  static int maxProfit = Integer.MIN_VALUE;

  public int maxProfit(int[] prices, int fee) {
    // 메모 설정
    int[] memoMaxPreviousProfit = new int[prices.length];

    memoMaxPreviousProfit[0] = prices[0];
    return dp(prices, fee, 1, memoMaxPreviousProfit);
  }

  // 문제는 이걸 어떻게 넘겨주지?
  // 최대를 넘겨줬으면 좋겠는데?
  // 그래서 최댓값을
  public int dp(
      int[] prices,
      int fee,
      int index,
      int[] memoMaxPreviousProfit
  ) {
    if (prices.length == index) {
      return memoMaxPreviousProfit[prices.length - 1];
    }
    // 이전 최대
    int previousMax = memoMaxPreviousProfit[index - 1];

    // 이전 최대랑 현재 최대를 비교
    // 인덱스 샀을때 -> 최대는 외부랑 비교해야됨
    for (int nextIndex = index; nextIndex < prices.length; nextIndex++) {
      maxProfit = Math.max(
          maxProfit,
          Math.max(previousMax, (((prices[nextIndex] - prices[index]) + previousMax) - fee)
          )
      );
    }

    // 배열저장은 이전팔떄 최대 vs 현재 팔때 최대 이익
    for (int previousIndex = index; previousIndex >= 0; previousIndex--) {
      memoMaxPreviousProfit[index] = Math.max(
          previousMax,
          (prices[index] - prices[previousIndex] - fee)
      );
    }

    return dp(prices, fee, index + 1, memoMaxPreviousProfit);
  }

}
