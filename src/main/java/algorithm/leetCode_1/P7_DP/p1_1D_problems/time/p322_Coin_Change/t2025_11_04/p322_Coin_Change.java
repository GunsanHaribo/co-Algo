package algorithm.leetCode_1.P7_DP.p1_1D_problems.time.p322_Coin_Change.t2025_11_04;

import java.util.HashSet;
import java.util.Set;

public class p322_Coin_Change {

  public static void main(String[] args) {
    p322_Coin_Change solver = new p322_Coin_Change();
//    int[] coins = {1, 2, 5};
//    int amount = 11;

    int[] coins = {2};
    int amount = 3;

//    int[] coins = {1};
//    int amount = 0;

    System.out.println(solver.coinChange(coins, amount));
  }

  public int coinChange(int[] coins, int amount) {
    int[] dp = new int[amount + 1];
    dp[0] = 0;
    Set<Integer> coinSet = new HashSet<>();
    for (int coin : coins) {
      coinSet.add(coin);
    }

    for (int i = 1; i < dp.length; i++) {
      if (coinSet.contains(i)) {
        dp[i] = 1;
        continue;
      }

      int min = Integer.MAX_VALUE;
      for (int coin : coins) {
        int previous = i - coin;
        if (previous < 0) {
          continue;
        }
        min = Math.min(min, dp[previous]);
      }
      if (min == Integer.MAX_VALUE) {
        dp[i] = Integer.MAX_VALUE;
        continue;
      }

      dp[i] = 1 + min;
    }

    if (dp[amount] == Integer.MAX_VALUE) {
      return -1;
    }

    return dp[amount];
  }

}
