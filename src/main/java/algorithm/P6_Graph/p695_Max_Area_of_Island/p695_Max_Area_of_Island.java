package algorithm.P6_Graph.p695_Max_Area_of_Island;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class p695_Max_Area_of_Island {

  public static void main(String[] args) {
    int n = 3;
    int[][] edges = new int[][]{{0, 1}, {1, 2}, {2, 0}};
    int source = 0;
    int destination = 2;

    System.out.println(validPath(n, edges, source, destination));
  }

  public static boolean validPath(int n, int[][] edges, int source, int destination) {
    Map<Integer, List<Integer>> graph = new HashMap<>();
    for (int i = 0; i < n; i++) {
      graph.put(i, new ArrayList<>());
    }

    for (int[] edge : edges) {
      int u = edge[0];
      int v = edge[1];
      graph.get(u).add(v);
      graph.get(v).add(u);
    }

    boolean[] visited = new boolean[n];
    return dfs(graph, source, destination, visited);
  }

  private static boolean dfs(Map<Integer, List<Integer>> graph, int current, int destination, boolean[] visited) {
    if (current == destination) return true;

    visited[current] = true;

    for (int neighbor : graph.get(current)) {
      if (!visited[neighbor]) {
        if (dfs(graph, neighbor, destination, visited)) {
          return true;
        }
      }
    }

    return false;
  }

}
