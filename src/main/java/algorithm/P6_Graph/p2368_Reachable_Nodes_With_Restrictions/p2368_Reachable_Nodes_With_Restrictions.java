package algorithm.P6_Graph.p2368_Reachable_Nodes_With_Restrictions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
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

  Set<Integer> restrictedSet = new HashSet<>();
  Map<Integer, List<Integer>> graph = new HashMap<>();
  Set<Integer> seen = new HashSet<>();

  public int reachableNodes(int n, int[][] edges, int[] restricted) {
    for (int r : restricted) {
      restrictedSet.add(r);
    }

    for (int i = 0; i < n; i++) {
      graph.put(i, new ArrayList<>());
    }
    for (int[] edge : edges) {
      graph.get(edge[0]).add(edge[1]);
      graph.get(edge[1]).add(edge[0]);
    }
    seen.add(0);
    return dfs(0);
  }

  public int dfs(int node) {
    int count = 1;
    for (int neighbor : graph.get(node)) {
      if (!seen.contains(neighbor) && !restrictedSet.contains(neighbor)) {
        seen.add(neighbor);
        count += dfs(neighbor);
      }
    }
    return count;
  }

}
