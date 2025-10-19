package algorithm.leetCode_1.P6_Graph.p2_BFS.aimportant.p542_01_Matrix.t2025_10_19;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class p542_01_Matrix {

  public static void main(String[] args) {
    p542_01_Matrix solver = new p542_01_Matrix();
    int[][] mat = {
        {0, 1, 0, 1, 1},
        {1, 1, 0, 0, 1},
        {0, 0, 0, 1, 0},
        {1, 0, 1, 1, 1},
        {1, 0, 0, 0, 1}
    };

    int[][] sol = solver.updateMatrix(mat);
    for (int[] row : sol) {
      System.out.println(Arrays.toString(row));
    }
  }

  int[][] dydxs = {
      {-1, 0},
      {1, 0},
      {0, -1},
      {0, 1}
  };

  public int[][] updateMatrix(int[][] mat) {
    int my = mat.length;
    int nx = mat[0].length;
    boolean[][] seen = new boolean[my][nx];

    Queue<State> queue = new LinkedList<>();
    for (int y = 0; y < my; y++) {
      for (int x = 0; x < nx; x++) {
        if (mat[y][x] == 0) {
          seen[y][x] = true;
          queue.add(new State(y, x, 0));

        }
      }
    }

    int[][] answer = new int[my][nx];
    while (!queue.isEmpty()) {
      int n = queue.size();
      for (int i = 0; i < n; i++) {
        State poll = queue.poll();
        answer[poll.y][poll.x] = poll.count;

        for (int[] dydx : dydxs) {
          int newY = poll.y + dydx[0];
          int newX = poll.x + dydx[1];
          if (validateBond(newY, newX, my, nx) || seen[newY][newX]) {
            continue;
          }

          seen[newY][newX] = true;
          queue.add(new State(newY, newX, poll.count + 1));
        }
      }
    }

    return answer;
  }


  private record State(int y, int x, int count) {

  }

  private boolean validateBond(int nextY, int nextX, int my, int nx) {
    return nextY < 0 || nextX < 0 || nextY >= my || nextX >= nx;
  }
}
