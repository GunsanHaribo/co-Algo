package algorithm.P6_Graph.p1_DFS.example.p547_Number_of_Provinces.t2025_10_12;

public class p547_Number_of_Provinces {

  public static void main(String[] args) {
    p547_Number_of_Provinces solver = new p547_Number_of_Provinces();
//    int[][] isConnected = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
    int[][] isConnected = {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};

    System.out.println(solver.findCircleNum(isConnected));
  }

  public int findCircleNum(int[][] isConnected) {
    return 1;
  }

}
