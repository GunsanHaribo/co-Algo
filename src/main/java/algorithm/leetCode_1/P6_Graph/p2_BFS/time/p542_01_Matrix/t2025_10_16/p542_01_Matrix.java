package algorithm.leetCode_1.P6_Graph.p2_BFS.time.p542_01_Matrix.t2025_10_16;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class p542_01_Matrix {

  public static void main(String[] args) {
    p542_01_Matrix solver = new p542_01_Matrix();
//    int[][] mat = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
//    int[][] mat = {{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};
//    int[][] mat = {함
//        {0, 1, 0},
//        {0, 1, 0},
//        {0, 1, 0},
//        {0, 1, 0},
//        {0, 1, 0}
//    };

    // 위뿐만아니라 아래하고도 붙어있네, 이러면 내가 가지고 있는풀이는 못쓰는데
    // 답지를 보자
    int[][] mat = {
        {0,1,0,1,1},
        {1,1,0,0,1},
        {0,0,0,1,0},
        {1,0,1,1,1},
        {1,0,0,0,1}
    };

    int[][] sol = solver.updateMatrix(mat);
    for (int[] row : sol) {
      System.out.println(Arrays.toString(row));
    }

//    System.out.println("####int[]equals비교####");
//    Set<int[]> set = new HashSet<>();
//    set.add(new int[]{0, 0});
//    System.out.println(set.contains(new int[]{0, 0})); // false 나오네
//
//    Set<State> set2 = new HashSet<>();
//    set2.add(new State(new int[]{0, 0}, 0));
//    System.out.println(set2.contains(new State(new int[]{0, 0}, 1))); // ?
  }

  // 상하좌우
  int[][] dydxs = {
      {-1, 0},
      {1, 0},
      {0, -1},
      {0, 1}
  };

  boolean[][] seen;

  // seen 처리를 늦게하는 방향으로 진행하자
  public int[][] updateMatrix(int[][] mat) {
    int my = mat.length;
    int nx = mat[0].length;
    seen = new boolean[my][nx];

    Queue<State> queue = new LinkedList<>();
    queue.add(new State(0, 0));
    seen[0][0] = true;

    while (!queue.isEmpty()) {
      int n = queue.size();

      Map<State, Integer> temp = new HashMap<>();
      for (int i = 0; i < n; i++) {
        State poll = queue.poll();

        for (int[] dydx : dydxs) {
          int[] newYX = {poll.y + dydx[0], poll.x + dydx[1]};
          // nextY,X 유효성 검사
          if (validateBound(newYX, my, nx) || seen[newYX[0]][newYX[1]]) {
            continue;
          }

          State newState = new State(newYX[0], newYX[1]);
          int newCount = mat[poll.y][poll.x];
          if (mat[newYX[0]][newYX[1]] == 1) {
            newCount++;
          } else {
            newCount = 0;
          }

          // 있으면, (있는거 vs 새로 만들어지는거?)
          // (2,0,1) -> (2,1,2), (1,1,1) -> (2,1,2)
          // (2,1,2),-> (2,2,3)[이미 들어감], (1,2,0) -> (2,2,1) -> 이떄는 작은거 골라야된다 이거 하자
          if (temp.containsKey(newState)) {
            Integer minCountSameLevel = Math.min(temp.get(newState), newCount);
            temp.put(newState, minCountSameLevel);
            continue;
          }

          // 없다면 그냥 넣어주기,
          // (2,0,1)->(2,0) 없으면 (2,0,1)로 넣어주기, 그대로 넣어주기
          // (2,1,1)->(2,1) 없고, mat 숫자가 1이면,  (2,1,2)로 넣어주기
          temp.put(newState, newCount);
        }
      }

      // 0,2가 왜 이렇게 나오지?
      // 큐에 넣으면서 seen 처리 및 value 업데이트
      for (Map.Entry<State, Integer> value : temp.entrySet()) {
        State newYX = value.getKey();
        seen[newYX.y][newYX.x] = true;
        mat[newYX.y][newYX.x] = value.getValue();
        queue.add(newYX);
      }
    }

    return mat;
  }

  private record State(int y, int x) {

  }

  private boolean validateBound(int[] newYX, int my, int nx) {
    return newYX[0] < 0 || newYX[0] >= my || newYX[1] >= nx || newYX[1] < 0;
  }

}
