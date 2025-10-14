package algorithm.leetCode_1회독중.P6_Graph.p1_DFS.a_important.p1971_Find_if_Path_Exists_in_Graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class p1971_Find_if_Path_Exists_in_Graph {

  public static void main(String[] args) {
    p1971_Find_if_Path_Exists_in_Graph solver = new p1971_Find_if_Path_Exists_in_Graph();
//    int n = 3;
//    int[][] edges = {
//        {0, 1},
//        {1, 2},
//        {2, 0}
//    };
//
//    int source = 0;
//    int destination = 2;

//    int n = 6;
//    int[][] edges = {
//        {0, 1},
//        {0, 2},
//        {3, 5},
//        {5, 4},
//        {4, 3}
//    };
//    int source = 0;
//    int destination = 5;

//    int n = 1;
//    int[][] edges = {};
//    int source = 0;
//    int destination = 0;

    int n = 10;
    int[][] edges = {
        {0, 7},
        {0, 8},
        {6, 1},
        {2, 0},
        {0, 4},
        {5, 8},
        {4, 7},
        {1, 3},
        {3, 5},
        {6, 5}
    };
    int source = 7;
    int destination = 5;

    System.out.println(solver.validPath(n, edges, source, destination));
  }

  private Set<Integer> seen = new HashSet<>();

  public boolean validPath(int n, int[][] edges, int source, int destination) {
    if (edges.length == 0) {
      if (source == 0 && destination == 0) {
        return true;
      }
      return false;
    }

    Map<Integer, Set<Integer>> graph = new HashMap<>();
    for (int[] edge : edges) {
      Set<Integer> orDefault = graph.getOrDefault(edge[0], new HashSet<>());
      orDefault.add(edge[1]);
      graph.put(edge[0], orDefault);

      Set<Integer> orDefault2 = graph.getOrDefault(edge[1], new HashSet<>());
      orDefault2.add(edge[0]);
      graph.put(edge[1], orDefault2);
    }
    System.out.println(graph);

    dfs(source, graph);

    return seen.contains(destination);
  }

  // 최대한 현재노드만 포함
  // 한번만 나오면 되긴 하는데, 한번 하기는 어렵지
  public void dfs(int node, Map<Integer, Set<Integer>> graph) {
    seen.add(node);

    for (int nextNode : graph.get(node)) {
      if (!seen.contains(nextNode)) {
        dfs(nextNode, graph);
      }
    }
  }

}
