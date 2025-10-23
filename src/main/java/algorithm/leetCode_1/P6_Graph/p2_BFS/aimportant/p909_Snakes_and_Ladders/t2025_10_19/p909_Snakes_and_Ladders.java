package algorithm.leetCode_1.P6_Graph.p2_BFS.aimportant.p909_Snakes_and_Ladders.t2025_10_19;

import java.util.LinkedList;
import java.util.Queue;

public class p909_Snakes_and_Ladders {

  public static void main(String[] args) {
    p909_Snakes_and_Ladders solver = new p909_Snakes_and_Ladders();

    int[][] board = {
        {-1, -1, -1, -1, -1, -1},
        {-1, -1, -1, -1, -1, -1},
        {-1, -1, -1, -1, -1, -1},
        {-1, 35, -1, -1, 13, -1},
        {-1, -1, -1, -1, -1, -1},
        {-1, 15, -1, -1, -1, -1}
    };

//    int[][] board = {
//        {-1, -1},
//        {-1, 3}
//    };

    // 이거 무한루프 안돌게 해야함 // -1을 기대합니다.
//    int[][] board = {
//        {1, 1, -1},
//        {1, 1, 1},
//        {-1, 1, 1}
//    };

//    int[][] board = {
//        {2, -1, -1, -1, -1},
//        {-1, -1, -1, -1, -1},
//        {-1, -1, -1, -1, -1},
//        {-1, -1, -1, -1, -1},
//        {-1, -1, -1, -1, -1}
//    };

    System.out.println(solver.snakesAndLadders(board));
  }

  public int snakesAndLadders(int[][] board) {
    // 지그재그여서 flatMap은 못씀니다.
//    int[] flatBoard = Arrays.stream(board)
//        .flatMapToInt(Arrays::stream)
//        .toArray();

    // 홀짝으로 해주면 안되네;;
    int n = board.length;
    int totalNumber = n * n;
    int[] flatBoard = new int[totalNumber];
    int count = 0;
    boolean isStartFront = true;
    for (int i = n - 1; i >= 0; i--) {
      // 나머지가 0이면 앞으로
      if (isStartFront) {
        for (int j = 0; j < n; j++) {
          flatBoard[count++] = board[i][j];
        }
      }
      // 나머지가 1이면 뒤에서 시작
      if (!isStartFront) {
        for (int j = n - 1; j >= 0; j--) {
          flatBoard[count++] = board[i][j];
        }
      }
      isStartFront = !isStartFront;
    }
//    System.out.println(Arrays.toString(flatBoard));

    boolean[] seen = new boolean[flatBoard.length];

    // 주어진 수에 -1이 인덱스 입니다.
    int lastIndex = totalNumber - 1;
    Queue<State> queue = new LinkedList<>();
    queue.add(new State(0, 0));
    seen[0] = true;

    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        State poll = queue.poll();
        if (poll.index == flatBoard.length - 1) {
          return poll.depth;
        }

        for (int dIndex = 1; dIndex < 7; dIndex++) {
          int nextIndex = Math.min(poll.index + dIndex, lastIndex);

          // 이미 안가봤던 곳이고,,, 아 근데 생각을 해보니깐 굳이 이거 seen 처리해야되나?
          // 있으나 마나 인것 같긴한데, 오히려 더 방해 될수도, 상하좌우 무빙이 아니니깐 seen 버리자

          // 다음 인덱스로 보냅니다.
          // 근데 이게 포함이 되면인가 아니면, 그냥 딱2에 도착을 하면 보내는 건가?
          // 2번은 못가는 것도 포함 시켜야함 -> 이게 빡센데
          // nextIndex로 넣어 줍니다. 근데 nexIndex에 사다리나, 다른게 있으면, 사다리 쪽으로 넣어줍니다.

          // 사다리인지 체크
          // 한턴에 2번은 못탄다..라.. -> 이건 근데 bfs하면 자동으로 됨
          // 딱, next칸에 있어야되네
          if (flatBoard[nextIndex] != -1 && nextIndex != lastIndex) {
            nextIndex = flatBoard[nextIndex] - 1;
          }
          if (seen[nextIndex]) {
            continue;
          }
          seen[nextIndex] = true;
          queue.add(new State(nextIndex, poll.depth + 1));
        }
      }
    }

    return -1;
  }

  private record State(int index, int depth) {

  }

}
