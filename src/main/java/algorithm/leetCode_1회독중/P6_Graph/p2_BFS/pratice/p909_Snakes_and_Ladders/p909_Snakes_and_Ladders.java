package algorithm.leetCode_1회독중.P6_Graph.p2_BFS.pratice.p909_Snakes_and_Ladders;

import java.util.LinkedList;
import java.util.Queue;

public class p909_Snakes_and_Ladders {

  public static void main(String[] args) {
    int[][] board = {{-1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1},
        {-1, 35, -1, -1, 13, -1}, {-1, -1, -1, -1, -1, -1}, {-1, 15, -1, -1, -1, -1}};

    p909_Snakes_and_Ladders solver = new p909_Snakes_and_Ladders();
    System.out.println(solver.snakesAndLadders(board));
  }

  public int snakesAndLadders(int[][] board) {

    int n = board.length;
    boolean[] visited = new boolean[n * n + 1]; // 1-based index
    Queue<int[]> queue = new LinkedList<>();
    queue.offer(new int[]{1, 0}); // {current square, moves}
    visited[1] = true;

    while (!queue.isEmpty()) {
      int[] curr = queue.poll();
      int pos = curr[0];
      int moves = curr[1];

      // Try all dice rolls
      for (int next = pos + 1; next <= Math.min(pos + 6, n * n); next++) {
        int[] coords = getCoordinates(next, n);
        int row = coords[0], col = coords[1];

        int dest = board[row][col] == -1 ? next : board[row][col];
        if (!visited[dest]) {
          if (dest == n * n) {
            return moves + 1;
          }
          visited[dest] = true;
          queue.offer(new int[]{dest, moves + 1});
        }
      }
    }

    return -1;
  }

  // Helper to convert cell number to board coordinates
  private int[] getCoordinates(int square, int n) {
    int row = n - 1 - (square - 1) / n;
    int col = (square - 1) % n;
    if ((n - row) % 2 == 0) { // even row (from bottom), reverse column
      col = n - 1 - col;
    }
    return new int[]{row, col};
  }

}
