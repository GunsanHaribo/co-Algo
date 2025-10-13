package algorithm.P6_Graph.p1_DFS.practice.p2368_Reachable_Nodes_With_Restrictions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class p2368_Reachable_Nodes_With_Restrictions {

  public static void main(String[] args) {
    p2368_Reachable_Nodes_With_Restrictions solution = new p2368_Reachable_Nodes_With_Restrictions();
    int n = 7;
    int[][] edges = {{0, 1}, {1, 2}, {3, 1}, {4, 0}, {0, 5}, {5, 6}};
    int[] restricted = {4, 5};

    int result = solution.reachableNodes(n, edges, restricted);
    System.out.println(result);
  }

  private Set<Integer> seen = new HashSet<>();

  public int reachableNodes(int n, int[][] edges, int[] restricted) {
    for (int restrictValue : restricted) {
      seen.add(restrictValue);
    }

    // 무방향 그래프 만들기
    Map<Integer, Set<Integer>> graph = new HashMap<>();
    for (int[] edge : edges) {
      Set<Integer> orDefault = graph.getOrDefault(edge[0], new HashSet<>());
      orDefault.add(edge[1]);
      graph.put(edge[0], orDefault);

      Set<Integer> orDefault2 = graph.getOrDefault(edge[1], new HashSet<>());
      orDefault2.add(edge[0]);
      graph.put(edge[1], orDefault2);
    }

    dfs(0, graph);

    return seen.size() - restricted.length;
  }

  public void dfs(int node, Map<Integer, Set<Integer>> graph) {
    seen.add(node);

    for (int nextNode : graph.get(node)) {
      if (!seen.contains(nextNode)) {
        dfs(nextNode, graph);
      }
    }
  }

}
