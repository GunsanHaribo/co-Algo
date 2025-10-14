package algorithm.P6_Graph.p1_DFS.a_important.p841_Keys_and_Rooms.t2025_10_14;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class p841_Keys_and_Rooms {

  public static void main(String[] args) {
    p841_Keys_and_Rooms solver = new p841_Keys_and_Rooms();
//    List<List<Integer>> rooms = List.of(
//        List.of(1),
//        List.of(2),
//        List.of(3),
//        List.of()
//    );

    List<List<Integer>> rooms = List.of(
        List.of(1, 3),
        List.of(3,0,1),
        List.of(2),
        List.of(0)
    );

    System.out.println(solver.canVisitAllRooms(rooms));
  }

  private Set<Integer> seen = new HashSet<>();

  public boolean canVisitAllRooms(List<List<Integer>> rooms) {
    dfs(0, rooms);
    return seen.size() == rooms.size();
  }

  public void dfs(int node, List<List<Integer>> rooms) {
    seen.add(node);

    List<Integer> nextNodes = rooms.get(node);
    for (Integer nextNode : nextNodes) {
      if (!seen.contains(nextNode)) {
        dfs(nextNode, rooms);
      }
    }
  }

}
