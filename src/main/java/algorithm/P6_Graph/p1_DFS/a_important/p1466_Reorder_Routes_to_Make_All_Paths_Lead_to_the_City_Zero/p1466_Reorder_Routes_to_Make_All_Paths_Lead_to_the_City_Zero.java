package algorithm.P6_Graph.p1_DFS.a_important.p1466_Reorder_Routes_to_Make_All_Paths_Lead_to_the_City_Zero;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class p1466_Reorder_Routes_to_Make_All_Paths_Lead_to_the_City_Zero {

  public static void main(String[] args) {
    p1466_Reorder_Routes_to_Make_All_Paths_Lead_to_the_City_Zero solver = new p1466_Reorder_Routes_to_Make_All_Paths_Lead_to_the_City_Zero();
    int n = 6;
    int[][] connections = {
        {0, 1},
        {1, 3},
        {2, 3},
        {4, 0},
        {4, 5}
    };

    System.out.println(solver.minReorder(n, connections));
  }

  private Map<Integer, HashSet<Integer>> anyWayGraphs = new HashMap<>();
  private Map<Integer, HashSet<Integer>> wayGraphs = new HashMap<>();


  public int minReorder(int n, int[][] connections) {



    return 0;
  }

  // 이전 노드 랑 같이 해서 넣어주던가
  public void findZero() {

    return;
  }

}
