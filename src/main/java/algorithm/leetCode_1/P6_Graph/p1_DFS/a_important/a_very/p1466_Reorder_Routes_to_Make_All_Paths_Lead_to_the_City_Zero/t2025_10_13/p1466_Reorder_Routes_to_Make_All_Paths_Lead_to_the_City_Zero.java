package algorithm.leetCode_1.P6_Graph.p1_DFS.a_important.a_very.p1466_Reorder_Routes_to_Make_All_Paths_Lead_to_the_City_Zero.t2025_10_13;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class p1466_Reorder_Routes_to_Make_All_Paths_Lead_to_the_City_Zero {

  public static void main(String[] args) {
    p1466_Reorder_Routes_to_Make_All_Paths_Lead_to_the_City_Zero solver = new p1466_Reorder_Routes_to_Make_All_Paths_Lead_to_the_City_Zero();
//    int n = 6;
//    int[][] connections = {
//        {0, 1},
//        {1, 3},
//        {2, 3},
//        {4, 0},
//        {4, 5}
//    };

    int n = 5;
    int[][] connections = {
        {1, 0},
        {1, 2},
        {3, 2},
        {3, 4}
    };

    System.out.println(solver.minReorder(n, connections));
  }

  private boolean[] seen;

  public int minReorder(int n, int[][] connections) {
    seen = new boolean[n];
    // 단방향 그래프 만들기
    Map<Integer, HashSet<Integer>> wayGraphs = new HashMap<>();
    for (int[] connection : connections) {
      HashSet<Integer> orDefault = wayGraphs.getOrDefault(connection[0], new HashSet<>());
      orDefault.add(connection[1]);
      wayGraphs.put(connection[0], orDefault);
    }
    System.out.println("wayGraphs");
    System.out.println(wayGraphs);

    // 무방향 그래프 만들기
    Map<Integer, HashSet<Integer>> anyWayGraphs = new HashMap<>();
    for (int[] connection : connections) {
      HashSet<Integer> orDefault = anyWayGraphs.getOrDefault(connection[0], new HashSet<>());
      HashSet<Integer> orDefault2 = anyWayGraphs.getOrDefault(connection[1], new HashSet<>());
      //
      orDefault.add(connection[1]);
      anyWayGraphs.put(connection[0], orDefault);
      //
      orDefault2.add(connection[0]);
      anyWayGraphs.put(connection[1], orDefault2);
    }
    System.out.println("anyWayGraphs");
    System.out.println(anyWayGraphs);

    // 0에서 이동, 무방향 그래프를 따라서 이동
    Map<Integer, HashSet<Integer>> toZeroReverseGraph = new HashMap<>();
    moveZeroToOthers(0, anyWayGraphs, toZeroReverseGraph);
    System.out.println("리버스 제로");
    System.out.println(toZeroReverseGraph);

    // toZeroReverseGraph 그래프 돌면서, 단방향 그래프랑 비교해서 없으면 count++
    int count = 0;
    for (Integer key : toZeroReverseGraph.keySet()) {
      HashSet<Integer> reverseToOrder = toZeroReverseGraph.get(key);
      HashSet<Integer> wayGraphOrder = wayGraphs.get(key);
      if (wayGraphOrder != null) {
        reverseToOrder.removeIf(wayGraphOrder::contains);
        count += reverseToOrder.size();
      }
      if (wayGraphOrder == null) {
        count += reverseToOrder.size();
      }
    }

    return count;
  }

  public void moveZeroToOthers(
      Integer value,
      Map<Integer, HashSet<Integer>> anyWayGraphs,
      Map<Integer, HashSet<Integer>> toZeroReverseGraph
  ) {
    seen[value] = true;

    HashSet<Integer> nextValues = anyWayGraphs.get(value);
    for (Integer nextValue : nextValues) {
      if (!seen[nextValue]) {
        HashSet<Integer> orDefault = toZeroReverseGraph.getOrDefault(nextValue, new HashSet<>());
        orDefault.add(value);
        toZeroReverseGraph.put(nextValue, orDefault);

        moveZeroToOthers(nextValue, anyWayGraphs, toZeroReverseGraph);
      }
    }
  }

}
