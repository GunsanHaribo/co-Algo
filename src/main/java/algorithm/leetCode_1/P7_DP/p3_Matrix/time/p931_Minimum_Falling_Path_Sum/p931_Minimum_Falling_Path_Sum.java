package algorithm.leetCode_1.P7_DP.p3_Matrix.time.p931_Minimum_Falling_Path_Sum;

public class p931_Minimum_Falling_Path_Sum {

  public static void main(String[] args) {
    p931_Minimum_Falling_Path_Sum solver = new p931_Minimum_Falling_Path_Sum();

//    int[][] matrix = {
//        {2, 1, 3},
//        {6, 5, 4},
//        {7, 8, 9}
//    }; // 13
//
//    int[][] matrix = {
//        {-19, 5},
//        {-40, -5}
//    };

    int[][] matrix = {
        {-48}
    };

    System.out.println(solver.minFallingPathSum(matrix));
  }

  // 위, 대각선 위 오른쪽 왼쪽
  int[][] dydxs = {
      {-1, 0},
      {-1, -1},
      {-1, 1}
  };

  public int minFallingPathSum(int[][] matrix) {
    int m = matrix.length;
    int n = matrix[0].length;
    int[][] dp = new int[m][n];
    // 첫행

    int lastRowMin = Integer.MAX_VALUE;
    for (int i = 0; i < n; i++) {
      dp[0][i] = matrix[0][i];
      lastRowMin = Math.min(lastRowMin, dp[0][i]);
    }
    if (m == 1) {
      return lastRowMin;
    }

    // 첫번쨰 열 부터하는 다른 방법이 있을 것 같긴함
    lastRowMin = Integer.MAX_VALUE;
    for (int y = 1; y < m; y++) {
      for (int x = 0; x < n; x++) {
        int oldMin = 10_001;
        for (int[] dydx : dydxs) {
          int oldY = y + dydx[0];
          int oldX = x + dydx[1];
          if (validateBond(oldY, oldX, m, n)) {
            continue;
          }
          oldMin = Math.min(dp[oldY][oldX], oldMin);
        }
        dp[y][x] = matrix[y][x] + oldMin;
        if (y == m - 1) {
          lastRowMin = Math.min(dp[y][x], lastRowMin);
        }
      }
    }

    return lastRowMin;
  }

  private boolean validateBond(int y, int x, int m, int n) {
    return y < 0 || x < 0 || y >= m || x >= n;
  }

}
