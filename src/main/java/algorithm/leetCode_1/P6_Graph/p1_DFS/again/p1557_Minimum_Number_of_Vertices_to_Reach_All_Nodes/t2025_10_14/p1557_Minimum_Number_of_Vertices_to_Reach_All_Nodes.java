package algorithm.leetCode_1.P6_Graph.p1_DFS.again.p1557_Minimum_Number_of_Vertices_to_Reach_All_Nodes.t2025_10_14;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class p1557_Minimum_Number_of_Vertices_to_Reach_All_Nodes {

  public static void main(String[] args) {
    p1557_Minimum_Number_of_Vertices_to_Reach_All_Nodes solver = new p1557_Minimum_Number_of_Vertices_to_Reach_All_Nodes();
//    int n = 6;
//    List<List<Integer>> edges = List.of(
//        List.of(0, 1),
//        List.of(0, 2),
//        List.of(2, 5),
//        List.of(3, 4),
//        List.of(4, 2)
//    );

    int n = 3;
    List<List<Integer>> edges = List.of(
        List.of(1, 2),
        List.of(1, 0),
        List.of(0, 2)
    );

    System.out.println(solver.findSmallestSetOfVertices(n, edges));
  }

  Map<Integer, Set<Integer>> graph = new HashMap<>();
  Set<Integer> seen = new HashSet<>();
  int[] seenCount; // 맵으로 해도 괜찮을듯, 나중에 필터링하기가 힘들어서

  public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
    seenCount = new int[n];

    for (List<Integer> edge : edges) {
      Set<Integer> orDefault = graph.getOrDefault(edge.get(0), new HashSet<>());
      orDefault.add(edge.get(1));
      graph.put(edge.get(0), orDefault);
    }

    for (int i = 0; i < n; i++) {
      dfs(i);
    }

    List<Integer> answer = new ArrayList<>();
    for (int index = 0; index < n; index++) {
      if (seenCount[index] == 0) {
        answer.add(index);
      }
    }

    return answer;
  }

  private void dfs(int node) {
    seen.add(node);

    Set<Integer> nextNodes = graph.get(node);
    if (nextNodes == null) {
      return;
    }
    for (int nextNode : nextNodes) {
      seenCount[nextNode]++;
      if(!seen.contains(nextNode)){
        dfs(nextNode);
      }
    }
  }

}
