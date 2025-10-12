package algorithm.P6_Graph.p1_DFS.example.p200_Number_of_Islands.t2025_10_12;

import java.util.Arrays;

public class p200_Number_of_Islands {

  public static void main(String[] args) {
    p200_Number_of_Islands solver = new p200_Number_of_Islands();
    char[][] grid = {
        {'1', '1', '1', '1', '0'},
        {'1', '1', '0', '1', '0'},
        {'1', '1', '0', '0', '0'},
        {'0', '0', '0', '0', '0'}
    };
//    char[][] grid = {
//        {'1', '1', '0', '0', '0'},
//        {'1', '1', '0', '0', '0'},
//        {'0', '0', '1', '0', '0'},
//        {'0', '0', '0', '1', '1'}
//    };

    System.out.println(solver.numIslands(grid));
  }

  private boolean[][] seen;

  // 상하좌우
  private int[][] dydxs = new int[][]{
      {-1, 0},
      {1, 0},
      {0, -1},
      {0, 1}
  };

  public int numIslands(char[][] grid) {
    int count = 0;

    int m = grid.length; // 세로
    int n = grid[0].length; // 가로
    seen = new boolean[m][n];

    for (int y = 0; y < m; y++) {
      for (int x = 0; x < n; x++) {
        if (!seen[y][x] && grid[y][x] == '1') {
          count++;
          dfs(y, x, grid, m, n);
        }
      }
    }

    return count;
  }

  public void dfs(int y, int x, char[][] grid, int m, int n) {
    seen[y][x] = true;

    // 상하좌우, 연결되어 있으면 이동합니다.
    for (int[] dydx : dydxs) {
      int nextY = y + dydx[0];
      int nextX = x + dydx[1];

      if (nextY < 0 || nextY >= m || nextX >= n || nextX < 0) {
        continue;
      }
      if (!seen[nextY][nextX] && grid[nextY][nextX] == '1') {
        dfs(nextY, nextX, grid, m, n);
      }
    }
  }

}
