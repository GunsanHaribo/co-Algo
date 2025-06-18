package algorithm.P6_Graph.BFS.p1926_Nearest_Exit_from_Entrance_in_Maze;

import java.util.LinkedList;
import java.util.Queue;

public class p1926_Nearest_Exit_from_Entrance_in_Maze {

  public static void main(String[] args) {
    char[][] maze = {{'+', '+', '+' }, {'.', '.', '.' }, {'+', '+', '+' }};
    int[] entrance = {1, 0};

    p1926_Nearest_Exit_from_Entrance_in_Maze solver = new p1926_Nearest_Exit_from_Entrance_in_Maze();
    System.out.println(solver.nearestExit(maze, entrance));
  }

  int m;
  int n;
  int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

  public int nearestExit(char[][] maze, int[] entrance) {
    if (maze[entrance[0]][entrance[1]] == '+') {
      return -1;
    }

    m = maze.length;
    n = maze[0].length;

    boolean[][] seen = new boolean[m][n];
    seen[entrance[0]][entrance[1]] = true;
    Queue<State> queue = new LinkedList<>();
    queue.add(new State(entrance[0], entrance[1], 0));

    while (!queue.isEmpty()) {
      State state = queue.remove();
      int row = state.row;
      int col = state.col;
      int steps = state.steps;

      // validate 체크하면서 넣어주기
      for (int[] direction : directions) {
        int nextRow = row + direction[0];
        int nextCol = col + direction[1];

        if (valid(nextRow, nextCol, maze) && !seen[nextRow][nextCol]) {

          // .이고 border일떄
          if (isBorder(nextRow, nextCol) && !(nextRow == entrance[0] && nextCol == entrance[1])) {
            return steps + 1;
          }
          seen[nextRow][nextCol] = true;
          queue.add(new State(nextRow, nextCol, steps + 1));
        }
      }

    }
    return -1;
  }

  public boolean isBorder(int row, int col) {
    return row == 0 || col == 0 || row == m - 1 || col == n - 1;
  }

  public boolean valid(int row, int col, char[][] maze) {
    return 0 <= row && row < m
        && 0 <= col && col < n
        && maze[row][col] == '.';
  }

  class State {

    int row;
    int col;
    int steps;

    State(int row, int col, int steps) {
      this.row = row;
      this.col = col;
      this.steps = steps;
    }

  }

}
