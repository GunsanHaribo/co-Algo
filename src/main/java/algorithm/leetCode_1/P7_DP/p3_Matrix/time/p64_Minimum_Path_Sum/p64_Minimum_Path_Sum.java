package algorithm.leetCode_1.P7_DP.p3_Matrix.time.p64_Minimum_Path_Sum;

import java.util.Arrays;

public class p64_Minimum_Path_Sum {

  public static void main(String[] args) {
    p64_Minimum_Path_Sum solver = new p64_Minimum_Path_Sum();
//    int[][] grid = {
//        {1, 3, 1},
//        {1, 5, 1},
//        {4, 2, 1}
//    }; // 7

    int[][] grid = {
        {1, 2, 3},
        {4, 5, 6}
    };

    System.out.println(solver.minPathSum(grid));
  }

  // 왼쪽, 위쪽
  int[][] dydxs = {
      {0, -1},
      {-1, 0}
  };

  public int minPathSum(int[][] grid) {
    int m = grid.length;
    int n = grid[0].length; //1 <= m, n <= 200

    int[][] dp = new int[m][n];
    for (int i = 0; i < m; i++) {
      Arrays.fill(dp[i], Integer.MAX_VALUE);
    }
    dp[0][0] = grid[0][0];

    for (int y = 0; y < m; y++) {
      for (int x = 0; x < n; x++) {
        for (int[] dydx : dydxs) {
          int oldY = y + dydx[0];
          int oldX = x + dydx[1];
          if (validateBound(oldY, oldX, m, n)) {
            continue;
          }
          dp[y][x] = Math.min(dp[y][x], grid[y][x] + dp[oldY][oldX]);
        }
      }
    }

    return dp[m - 1][n - 1];
  }

  private boolean validateBound(int y, int x, int m, int n) {
    return y < 0 || x < 0 || y >= m || x >= n;
  }
}
