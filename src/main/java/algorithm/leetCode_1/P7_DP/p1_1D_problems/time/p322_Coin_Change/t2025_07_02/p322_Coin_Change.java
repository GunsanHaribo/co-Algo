package algorithm.leetCode_1.P7_DP.p1_1D_problems.time.p322_Coin_Change.t2025_07_02;

import java.util.HashMap;
import java.util.Map;

public class p322_Coin_Change {

  public static void main(String[] args) {
    int[] coins = new int[]{1, 2, 5};
    int amount = 11;
//    int[] coins = new int[]{1, 5};
//    int amount = 8;

    p322_Coin_Change solver = new p322_Coin_Change();
    int answer = solver.coinChange(coins, amount);
    System.out.println(answer);
  }

  Map<Integer, Integer> memoMin = new HashMap<>();

  public int coinChange(int[] coins, int amount) {
    if (amount == 0) {
      return 0;
    }
    if (amount < 0) {
      return -1;
    }
    if (memoMin.containsKey(amount)) {
      return memoMin.get(amount);
    }

    int min = Integer.MAX_VALUE;
    for (int coin : coins) {
      int subResultAmount = coinChange(coins, amount - coin); // 이 부분 한번 트레이싱 필요
      if (subResultAmount >= 0 && subResultAmount < min) {
        min = subResultAmount + 1;
      }
    }

    if (min == Integer.MAX_VALUE) {
      min = -1;
    }

    memoMin.put(amount, min);
    return memoMin.get(amount);
  }

}
