package algorithm.leetCode_1.P7_DP.p3_Matrix.time.p62_Unique_Paths;

public class p62_Unique_Paths {

  public static void main(String[] args) {
    p62_Unique_Paths solver = new p62_Unique_Paths();
    int m = 3;
    int n = 7;

    System.out.println(solver.uniquePaths(m, n));
  }

  // 왼쪽, 위쪽
  int[][] dydxs = {
      {0, -1},
      {-1, 0}
  };

  public int uniquePaths(int m, int n) {
    int[][] dp = new int[m][n];
    dp[0][0] = 1;

    for (int y = 0; y < m; y++) {
      for (int x = 0; x < n; x++) {
        for (int[] dydx : dydxs) {
          int oldY = y + dydx[0];
          int oldX = x + dydx[1];
          if (validateBound(oldY, oldX, m, n)) {
            continue;
          }
          dp[y][x] += dp[oldY][oldX];
        }
      }
    }

    return dp[m - 1][n - 1];
  }

  private boolean validateBound(int newY, int newX, int m, int n) {
    return newY < 0 || newX < 0 || newY >= m || newX >= n;
  }
}
