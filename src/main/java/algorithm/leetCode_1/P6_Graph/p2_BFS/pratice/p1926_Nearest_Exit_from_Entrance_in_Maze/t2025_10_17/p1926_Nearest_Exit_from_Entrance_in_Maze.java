package algorithm.leetCode_1.P6_Graph.p2_BFS.pratice.p1926_Nearest_Exit_from_Entrance_in_Maze.t2025_10_17;

import java.util.LinkedList;
import java.util.Queue;

public class p1926_Nearest_Exit_from_Entrance_in_Maze {

  public static void main(String[] args) {
    p1926_Nearest_Exit_from_Entrance_in_Maze solver = new p1926_Nearest_Exit_from_Entrance_in_Maze();
//    char[][] maze = {
//        {'+', '+', '.', '+' },
//        {'.', '.', '.', '+' },
//        {'+', '+', '+', '.' }
//    };
//
//    int[] entrance = {1, 2};
    char[][] maze = {
        {'+', '+', '+'},
        {'.', '.', '.'},
        {'+', '+', '+'}
    };
    int[] entrance = {1, 0};

    System.out.println(solver.nearestExit(maze, entrance));
  }

  // 상,하,좌,우
  private int[][] dydxs = {
      {-1, 0},
      {1, 0},
      {0, -1},
      {0, 1}
  };

  private boolean[][] seen;

  public int nearestExit(char[][] maze, int[] entrance) {
    int y = maze.length;
    int x = maze[0].length;
    seen = new boolean[y][x];
    Queue<int[]> queue = new LinkedList<>();
    queue.add(entrance);
    seen[entrance[0]][entrance[1]] = true;

    int count = 0;
    while (!queue.isEmpty()) {
      int n = queue.size();
      count++; // 본인부터 1이여서, 가능

      for (int i = 0; i < n; i++) {
        // 요소 뽑기
        int[] polled = queue.poll();
        // exit
        if (isExit(polled[0], polled[1], y, x, entrance)) {
          System.out.println("y:" + polled[0] + ", x:" + polled[1]);
          return count - 1;
        }

        // 다음
        for (int[] dydx : dydxs) {
          int nextY = polled[0] + dydx[0];
          int nextX = polled[1] + dydx[1];
          if (validateBond(nextY, nextX, y, x, maze) || seen[nextY][nextX]) {
            continue;
          }
          seen[nextY][nextX] = true;
          queue.add(new int[]{nextY, nextX});
        }
      }
    }

    return -1;
  }

  public boolean isExit(int y, int x, int my, int nx, int[] entrance) {
    return
        (y == 0 || x == 0 || y == my - 1 || x == nx - 1)
        &&
        !(y == entrance[0] && x == entrance[1]);
  }

  public boolean validateBond(int nextY, int nextX, int my, int nx, char[][] maze) {
    return nextY >= my || nextY < 0 || nextX >= nx || nextX < 0 || (maze[nextY][nextX] == '+');
  }

}
