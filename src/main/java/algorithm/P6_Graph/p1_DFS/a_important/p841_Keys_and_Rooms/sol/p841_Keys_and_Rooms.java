package algorithm.P6_Graph.p1_DFS.a_important.p841_Keys_and_Rooms.sol;

import java.util.List;

public class p841_Keys_and_Rooms {

  public static void main(String[] args) {
    p841_Keys_and_Rooms solver = new p841_Keys_and_Rooms();
    List<List<Integer>> rooms = List.of(List.of(1), List.of(2), List.of(3), List.of());
//    List<List<Integer>> rooms = List.of(List.of(1, 3), List.of(3, 0, 1), List.of(2), List.of(0));
//    List<List<Integer>> rooms = List.of(List.of(), List.of(), List.of(1), List.of(2, 3));

    System.out.println(solver.canVisitAllRooms(rooms));
  }

  int cnt = 0;

  public boolean canVisitAllRooms(List<List<Integer>> rooms) {
    dfs(0, new boolean[rooms.size()], rooms);
    return (cnt == rooms.size()) ? true : false;
  }

  void dfs(int room, boolean[] visited, List<List<Integer>> rooms) {
    visited[room] = true;
    cnt++;

    for (int key : rooms.get(room)) {
      if (!visited[key]) {
        dfs(key, visited, rooms);
      }
    }
  }

}
