package algorithm.leetCode_1회독중.P6_Graph.p1_DFS.example.p547_Number_of_Provinces.t2025_10_12;

public class p547_Number_of_Provinces {

  public static void main(String[] args) {
    p547_Number_of_Provinces solver = new p547_Number_of_Provinces();
//    int[][] isConnected = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
    int[][] isConnected = {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};

    System.out.println(solver.findCircleNum(isConnected));
  }

  private boolean[] seen;

  public int findCircleNum(int[][] isConnected) {
    int count = 0;

    int n = isConnected.length;
    seen = new boolean[n];

    for (int i = 0; i < n; i++) {
      if (!seen[i]) {
        seen[i] = true;
        count++;
        dfs(i, isConnected, n);
      }
    }

    return count;
  }

  // 1하고 연결이 되어 있는 애들 쭉 들어가야됨, 자기자신 제외
  public void dfs(int nodeNumber, int[][] isConnected, int n) {
    seen[nodeNumber] = true;

    // 다음으로, isConnected에 1로 되어있는 숫자들만
    int[] isConnectedRow = isConnected[nodeNumber];
    for (int i = 0; i < n; i++) {
      if (!seen[i] && isConnectedRow[i] == 1) {
        dfs(i, isConnected, n);
      }
    }
  }

}
