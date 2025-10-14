package algorithm.leetCode_1회독중.P6_Graph.p1_DFS.example.p200_Number_of_Islands;

public class p200_Number_of_Islands {

  public static void main(String[] args) {
    p200_Number_of_Islands solver = new p200_Number_of_Islands();
//    char[][] grid = {
//        {'1', '1', '1', '1', '0'},
//        {'1', '1', '0', '1', '0'},
//        {'1', '1', '0', '0', '0'},
//        {'0', '0', '0', '0', '0'}
//    };
    char[][] grid = {
        {'1', '1', '0', '0', '0'},
        {'1', '1', '0', '0', '0'},
        {'0', '0', '1', '0', '0'},
        {'0', '0', '0', '1', '1'}
    };

    System.out.println(solver.numIslands(grid));
  }

  private boolean[][] seen;

  // 상하좌우, 첫번쨰가 y로 하는게 움직이기 좋을듯,
  // 배열도 그래서
  private int[][] yx = {
      {-1, 0},
      {1, 0},
      {0, -1},
      {0, 1}
  };

  public int numIslands(char[][] grid) {
    seen = new boolean[grid.length][];
    for (int i = 0; i < grid.length; i++) {
      seen[i] = new boolean[grid[i].length];
    }

    // 전체 돌리기
    int count = 0;
    int mSize = grid.length;
    for (int y = 0; y < mSize; y++) {
      int nSize = grid[y].length;
      for (int x = 0; x < nSize; x++) {
        if (!seen[y][x]) {
          // false면 들어가긴 합니다. false면 들어가는데
          // false면들어가야하나?그리고 1이면
          if (grid[y][x] == '1') {
            count++;
          }
          dfs(y, x, grid);
        }
      }
    }

    return count;
  }

  public void dfs(int y, int x, char[][] grid) {
    // 경계를 넘어버리거나, 0일 경우에, 이미 방문한경우 return;
    try {
      char component = grid[y][x];
      if (component == '0' || seen[y][x]) {
        return;
      }
    } catch (IndexOutOfBoundsException e) {
      return; // 여기서 이러면 전체를 끝내지 않나?
    }

    // 아니면 방문 표시
    seen[y][x] = true;

    // 상하좌우 보내버리기~
    for (int[] dydx : yx) {
      dfs(y + dydx[0], x + dydx[1], grid);
    }
  }

}
