package algorithm.leetCode_1.P6_Graph.p2_BFS.aimportant.p1091_Shortest_Path_in_Binary_Matrix.t2025_10_14;

import java.util.LinkedList;
import java.util.Queue;

public class p1091_Shortest_Path_in_Binary_Matrix {

  public static void main(String[] args) {
    p1091_Shortest_Path_in_Binary_Matrix solver = new p1091_Shortest_Path_in_Binary_Matrix();
//    int[][] grid = {{0, 0, 0}, {1, 1, 0}, {1, 1, 0}};
//    int[][] grid = {{0, 1}, {1, 0}};
    int[][] grid = {
        {1, 0, 0},
        {1, 1, 0},
        {1, 1, 0}
    };

    System.out.println(solver.shortestPathBinaryMatrix(grid));
  }

  int[][] dydxs = {
      {-1, -1}, {-1, 0}, {-1, 1},
      {0, -1}, {0, 1},
      {1, -1}, {1, 0}, {1, 1}
  };

  boolean[][] seen;

  public int shortestPathBinaryMatrix(int[][] grid) {
    int count = 0; // 본인거 합쳐서 진행
    int n = grid.length;
    seen = new boolean[n][n];
    Queue<int[]> queue = new LinkedList<>();
    if (grid[0][0] == 0) {
      queue.add(new int[]{0, 0});
      seen[0][0] = true;
    }

    while (!queue.isEmpty()) {
      count++;

      int size = queue.size();
      for (int i = 0; i < size; i++) {
        int[] polled = queue.poll();
//        seen[polled[0]][polled[1]] = true; -> 여기에 넣으면 안되는이유?
        if (polled[0] == n - 1 && polled[1] == n - 1) {
          return count;
        }

        for (int[] dydx : dydxs) {
          int nextY = polled[0] + dydx[0];
          int nextX = polled[1] + dydx[1];
          if (validate(nextY, nextX, n, grid) || seen[nextY][nextX]) {
            continue;
          }

          seen[nextY][nextX] = true;
          queue.add(new int[]{nextY, nextX});
        }
      }
    }

    return -1;
  }

  private boolean validate(int nextY, int nextX, int n, int[][] grid) {
    return nextY < 0 || nextY >= n || nextX < 0 || nextX >= n || grid[nextY][nextX] == 1;
  }

}
