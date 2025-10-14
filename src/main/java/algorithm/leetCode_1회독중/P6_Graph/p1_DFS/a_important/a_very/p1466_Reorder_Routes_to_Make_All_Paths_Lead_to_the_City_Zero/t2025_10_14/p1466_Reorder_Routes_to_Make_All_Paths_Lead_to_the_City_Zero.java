package algorithm.leetCode_1회독중.P6_Graph.p1_DFS.a_important.a_very.p1466_Reorder_Routes_to_Make_All_Paths_Lead_to_the_City_Zero.t2025_10_14;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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

  Set<Integer> seen = new HashSet<>();
  Map<Integer, Set<Integer>> noWayGraph = new HashMap<>();
  Set<String> wayRecords = new HashSet<>();
  int count = 0;


  public int minReorder(int n, int[][] connections) {
    // 무방향 그래프 만들기
    // 만들면서, Set에 방향 그래프 start-node 기록하기
    for (int[] connection : connections) {
      Set<Integer> orDefault = noWayGraph.getOrDefault(connection[0], new HashSet<>());
      orDefault.add(connection[1]);
      noWayGraph.put(connection[0], orDefault);

      Set<Integer> orDefault2 = noWayGraph.getOrDefault(connection[1], new HashSet<>());
      orDefault2.add(connection[0]);
      noWayGraph.put(connection[1], orDefault2);

      wayRecords.add(createRecord(connection[0], connection[1]));
    }

    // 0에서 부터 시작
    // 무방향그래프를 돌면서 0에서 멀어지는 방향이 같으면 count
    // count를 전달할 방법이 마땅치 않으니깐, 전역사용
    dfs(0);

    return count;
  }

  public void dfs(int node) {
    seen.add(node);

    Set<Integer> nextNodes = noWayGraph.get(node);
    for (Integer nextNode : nextNodes) {
      if (!seen.contains(nextNode)) {
        if (wayRecords.contains(createRecord(node, nextNode))) {
          count++;
        }
        dfs(nextNode);
      }
    }
  }

  public String createRecord(int startNode, int endNode) {
    return startNode + "-" + endNode;
  }

}
