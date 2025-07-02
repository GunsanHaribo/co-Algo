package algorithm.P7_DP.p322_Coin_Change;

import java.util.HashMap;
import java.util.Map;

public class p322_Coin_Change {

  public static void main(String[] args) {
    int[] coins = new int[]{1, 2, 5};
    int amount = 11;
//    int[] coins = new int[]{2};
//    int amount = -1;

    p322_Coin_Change solver = new p322_Coin_Change();
    int answer = solver.coinChange(coins, amount);
    System.out.println(answer);
  }

  Map<Integer, Integer> memoMin = new HashMap<>();

  public int coinChange(int[] coins, int amount) {
    if (amount < 0) {
      return -1;
    }
    if (amount == 0) {
      return 0;
    }
    if (memoMin.containsKey(amount)) {
      return memoMin.get(amount);
    }

    int min = Integer.MAX_VALUE;
    for (int coin : coins) {
      int subResult = coinChange(coins, amount - coin);
      // 최소 돌려돌려
      if (subResult >= 0 && subResult < min) {
        min = subResult + 1;
      }
    }

    if (min == Integer.MAX_VALUE) {
      min = -1;
    }

    memoMin.put(amount, min);
    return memoMin.get(amount);
  }

}
