package algorithm.leetCode_1.P6_Graph.p1_DFS.practice.p695_Max_Area_of_Island;

import java.util.HashSet;
import java.util.Set;

public class p695_Max_Area_of_Island {

  public static void main(String[] args) {
    p695_Max_Area_of_Island solver = new p695_Max_Area_of_Island();
//    int[][] grid = {
//        {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
//        {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
//        {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
//        {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
//        {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
//        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
//        {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
//        {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
//    };

    int[][] grid = {{0,0,0,0,0,0,0,0}};

    System.out.println(solver.maxAreaOfIsland(grid));
  }

  // 상하좌우
  private int[][] dydxs = {
      {-1, 0},
      {1, 0},
      {0, -1},
      {0, 1}
  };

  private boolean[][] seen;

  public int maxAreaOfIsland(int[][] grid) {
    int m = grid[0].length;
    int n = grid.length;

    // seen 초기화
    seen = new boolean[n][m];
    for (int y = 0; y < n; y++) {
      for (int x = 0; x < m; x++) {
        if (grid[y][x] == 0) {
          seen[y][x] = true;
        }
      }
    }

    // 최대, 최소 확인
    int max = 0;
    for (int y = 0; y < n; y++) {
      for (int x = 0; x < m; x++) {
        if (grid[y][x] == 1 && !seen[y][x]) {
          Set<String> record = new HashSet<>();
          dfs(y, x, record, n, m);
          max = Math.max(max, record.size());
        }
      }
    }

    return max;
  }

  private void dfs(int y, int x, Set<String> record, int n, int m) {
    seen[y][x] = true;
    record.add(y + "-" + x);

    for (int[] dydx : dydxs) {
      int nextY = y + dydx[0];
      int nextX = x + dydx[1];
      if (validate(nextY, nextX, n, m) || seen[nextY][nextX]) {
        continue;
      }
      dfs(nextY, nextX, record, n, m);
    }
  }

  private boolean validate(int y, int x, int n, int m) {
    return y < 0 || y >= n || x < 0 || x >= m;
  }

}
