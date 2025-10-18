package algorithm.leetCode_1.P6_Graph.p1_DFS.example.p547_Number_of_Provinces;

public class p547_Number_of_Provinces {

  public static void main(String[] args) {
    p547_Number_of_Provinces solver = new p547_Number_of_Provinces();
//    int[][] isConnected = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
    int[][] isConnected = {{1,0,0},{0,1,0},{0,0,1}};

    System.out.println(solver.findCircleNum(isConnected));
  }

  public int findCircleNum(int[][] isConnected) {
    int n = isConnected.length;
    boolean[] seen = new boolean[n];

    int count = 0;
    for (int i = 0; i < n; i++) {
      if (!seen[i]) {
        count++;
      }
      dfs(i, isConnected, seen, n);
    }

    return count;
  }

  public void dfs(int i, int[][] isConnected, boolean[] seen, int n) {
    if (seen[i]) {
      return;
    }
    seen[i] = true;

    for (int k = 0; k < n; k++) {
      if (seen[k]) {
        continue;
      }
      // 자기자신 참조하는 부분은 없애야 합니다.
      int isLinked = isConnected[i][k];
      if (isLinked == 1) {
        dfs(k, isConnected, seen, n);
      }
    }
  }

}
