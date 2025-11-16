package algorithm.leetCode_1.P7_DP.p2_Multi_dimensional.important.p2218_Maximum_Value_of_K_Coins_From_Piles.t2025_11_14;

import java.util.List;

public class p2218_Maximum_Value_of_K_Coins_From_Piles {

  public static void main(String[] args) {
    p2218_Maximum_Value_of_K_Coins_From_Piles solver = new p2218_Maximum_Value_of_K_Coins_From_Piles();
    List<List<Integer>> piles = List.of(
        List.of(1, 100, 3),
        List.of(7, 8, 9)
    );
    int k = 2; // 101

//    List<List<Integer>> piles = List.of(
//        List.of(100),
//        List.of(100),
//        List.of(100),
//        List.of(100),
//        List.of(100),
//        List.of(100),
//        List.of(1, 1, 1, 1, 1, 1, 70));
//    int k = 7; // 706

    System.out.println(solver.maxValueOfCoins(piles, k));
  }

  public int maxValueOfCoins(List<List<Integer>> piles, int k) {
    int n = piles.size();
    // dp[][] -> 앞에서 j개의 pile로 정확히 i개 뽑을떄 최대 합
    int[][] dp = new int[k + 1][n + 1];

    for (int j = 1; j <= n; j++) {
      List<Integer> pile = piles.get(j - 1);
      int m = pile.size();

      // 안뽑고 패스하는 경우들
      for (int i = 0; i <= k; i++) {
        dp[i][j] = dp[i][j - 1];
      }

      // 이번 파일에서는 x개 뽑는 경우들
      // m은 k이거나, piles의 최대
      int runningSum = 0;
      for (int x = 1; x <= m && x <= k; x++) {
        runningSum += pile.get(x - 1);

        for (int i = x; i <= k; i++) {
          dp[i][j] = Math.max(
              dp[i][j],
              dp[i - x][j - 1] + runningSum
          );
        }
      }
    }

    return dp[k][n];
  }

}
