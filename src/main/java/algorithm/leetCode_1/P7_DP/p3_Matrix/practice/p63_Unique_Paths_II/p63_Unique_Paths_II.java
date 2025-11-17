package algorithm.leetCode_1.P7_DP.p3_Matrix.practice.p63_Unique_Paths_II;

public class p63_Unique_Paths_II {

  public static void main(String[] args) {
    p63_Unique_Paths_II solver = new p63_Unique_Paths_II();

//    int[][] obstacleGrid = {
//        {0, 0, 0},
//        {0, 1, 0},
//        {0, 0, 0}
//    }; // 2

    int[][] obstacleGrid = {
        {0, 1},
        {0, 0}
    }; // 2

    System.out.println(solver.uniquePathsWithObstacles(obstacleGrid));
  }


  // 위, 왼쪽
  int[][] dydxs = {
      {-1, 0},
      {0, -1}
  };

  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    int m = obstacleGrid.length;
    int n = obstacleGrid[0].length;

    int[][] dp = new int[m][n];
    if (obstacleGrid[0][0] == 0) {
      dp[0][0] = 1; // 0이면 1, 1이면 0으로 해야합니다.
    } else {
      dp[0][0] = 0; // 0이면 1, 1이면 0으로 해야합니다.
    }

    for (int y = 0; y < m; y++) {
      for (int x = 0; x < n; x++) {
        if (obstacleGrid[y][x] == 1) {
          continue;
        }
        for (int[] dydx : dydxs) {
          int oldY = y + dydx[0];
          int oldX = x + dydx[1];
          if (validateBond(oldY, oldX, m, n)) {
            continue;
          }
          // 애도흐음... 그냥 패스하는게 좋을듯 장애물이면, 아 그리고 장애물이면 그냥 건너뛰지 않나?
          dp[y][x] += dp[oldY][oldX];
        }
      }
    }

    return dp[m - 1][n - 1];
  }

  private boolean validateBond(int y, int x, int m, int n) {
    return y < 0 || x < 0 || y >= m || x >= n;
  }

}
