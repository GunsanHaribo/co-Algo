package algorithm.leetCode_1.P6_Graph.p2_BFS.aimportant.p1293_Shortest_Path_in_a_Grid_with_Obstacles_Elimination.t2025_10_18;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class p1293_Shortest_Path_in_a_Grid_with_Obstacles_Elimination {

  public static void main(String[] args) {
    p1293_Shortest_Path_in_a_Grid_with_Obstacles_Elimination solver = new p1293_Shortest_Path_in_a_Grid_with_Obstacles_Elimination();
//    int[][] grid = {
//        {0, 0, 0},
//        {1, 1, 0},
//        {0, 0, 0},
//        {0, 1, 1},
//        {0, 0, 0}
//    };
//    int k = 1;

//    int[][] grid = {
//        {0, 1, 1},
//        {1, 1, 1},
//        {1, 0, 0}
//    };
//    int k = 1;

    int[][] grid = {
        {0, 0},
        {1, 0},
        {1, 0},
        {1, 0},
        {1, 0},
        {1, 0},

        {0, 0},
        {0, 1},
        {0, 1},
        {0, 1},

        {0, 0},
        {1, 0},
        {1, 0},
        {0, 0}
    };
    int k = 4; // 나와야되는값은 14

    System.out.println(solver.shortestPath(grid, k));
  }

  int[][] dydxs = {
      {-1, 0},
      {1, 0},
      {0, -1},
      {0, 1}
  };

  // 벽이라면, k올리고 뚫고 가는거랑
  // 그냥 가는거 두가지, 그중 마무리가 최대인것
  public int shortestPath(int[][] grid, int k) {
    int m = grid.length;
    int n = grid[0].length;
    boolean[][] seen = new boolean[m][n];
    int[][] answer = new int[m][n];
    for (int[] row : answer) {
      Arrays.fill(row, -1);
    }

    Queue<State> queue = new LinkedList<>();
    queue.add(new State(0, 0, 0, 0));
    seen[0][0] = true;

    while (!queue.isEmpty()) {
      // 같은 계층에 있는거 다뽑아줘야함 -> 이걸 까먹었네;;
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        State poll = queue.poll();
        // -1이면 그냥 넣고
        // -1이 아니라면 최소값만 넣는다.
        if (answer[poll.y][poll.x] == -1) {
          answer[poll.y][poll.x] = poll.count;
        } else {
          answer[poll.y][poll.x] = Math.min(poll.count, answer[poll.y][poll.x]);
        }

        for (int[] dydx : dydxs) {
          int newY = poll.y + dydx[0];
          int newX = poll.x + dydx[1];
          if (validateBond(newY, newX, m, n) || seen[newY][newX]) {
            continue;
          }

//          seen[newY][newX] = true;
          if (grid[poll.y][poll.x] == 0) {
            seen[newY][newX] = true;
          }

          // 벽에 도착했을떄, k가 남아있으면 치워보고 안남아있으면 계속 가져간다.
          if (grid[newY][newX] == 1) {
            if (poll.k >= k) {
              continue;
            }
            queue.add(new State(newY, newX, poll.count + 1, poll.k + 1));
            continue;
          }

          queue.add(new State(newY, newX, poll.count + 1, poll.k));
        }
      }

    }

    return answer[m - 1][n - 1];
  }

  private record State(int y, int x, int count, int k) {

  }

  private boolean validateBond(int newY, int newX, int m, int n) {
    return newX < 0 || newY < 0 || newY >= m || newX >= n;
  }
}
