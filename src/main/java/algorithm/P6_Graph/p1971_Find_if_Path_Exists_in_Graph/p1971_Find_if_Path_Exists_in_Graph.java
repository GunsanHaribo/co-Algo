package algorithm.P6_Graph.p1971_Find_if_Path_Exists_in_Graph;

public class p1971_Find_if_Path_Exists_in_Graph {

  public static void main(String[] args) {
    int[][] grid = {
        {0,0,1,0,0,0,0,1,0,0,0,0,0},
        {0,0,0,0,0,0,0,1,1,1,0,0,0},
        {0,1,1,0,1,0,0,0,0,0,0,0,0},
        {0,1,0,0,1,1,0,0,1,0,1,0,0},
        {0,1,0,0,1,1,0,0,1,1,1,0,0},
        {0,0,0,0,0,0,0,0,0,0,1,0,0},
        {0,0,0,0,0,0,0,1,1,1,0,0,0},
        {0,0,0,0,0,0,0,1,1,0,0,0,0}
    };
    p1971_Find_if_Path_Exists_in_Graph solver = new p1971_Find_if_Path_Exists_in_Graph();
    int result = solver.maxAreaOfIsland(grid);
    System.out.println("Max area: " + result);
  }

  int m;
  int n;
  int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
  boolean[][] seen;


  public int maxAreaOfIsland(int[][] grid) {
    m = grid.length;
    n = grid[0].length;
    seen = new boolean[m][n];

    int maxArea = 0;
    for (int row = 0; row < m; row++) {
      for (int col = 0; col < n; col++) {
        if (grid[row][col] == 1 && !seen[row][col]) {
          int area = dfs(grid, row, col);
          maxArea = Math.max(maxArea, area);
        }
      }
    }
    return maxArea;
  }

  private int dfs(int[][] grid, int row, int col) {
    seen[row][col] = true;
    int area = 1;
    for (int[] dir : directions) {
      int nr = row + dir[0];
      int nc = col + dir[1];
      if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == 1 && !seen[nr][nc]) {
        area += dfs(grid, nr, nc);
      }
    }
    return area;
  }

}
