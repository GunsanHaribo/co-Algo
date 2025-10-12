package algorithm.P6_Graph.p1_DFS.example.p1557_Minimum_Number_of_Vertices_to_Reach_All_Nodes;

import java.util.List;

public class p1557_Minimum_Number_of_Vertices_to_Reach_All_Nodes {

  public static void main(String[] args) {
    p1557_Minimum_Number_of_Vertices_to_Reach_All_Nodes solver = new p1557_Minimum_Number_of_Vertices_to_Reach_All_Nodes();
    int n = 6;
    List<List<Integer>> edges = List.of(
        List.of(0, 1),
        List.of(0, 2),
        List.of(2, 5),
        List.of(3, 4),
        List.of(4, 2)
    );
    System.out.println(solver.findSmallestSetOfVertices(n, edges));
  }

  public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {


    return List.of();
  }

}
