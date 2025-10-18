package algorithm.leetCode_1.P6_Graph.p1_DFS.a_important.p841_Keys_and_Rooms.t2025_10_12;

import java.util.Arrays;
import java.util.List;

public class p841_Keys_and_Rooms {

  public static void main(String[] args) {
    p841_Keys_and_Rooms solver = new p841_Keys_and_Rooms();
    List<List<Integer>> rooms = List.of(List.of(1), List.of(2), List.of(3), List.of());
//    List<List<Integer>> rooms = List.of(List.of(1, 3), List.of(3, 0, 1), List.of(2), List.of(0));
//    List<List<Integer>> rooms = List.of(List.of(), List.of(), List.of(1), List.of(2, 3));

    System.out.println(solver.canVisitAllRooms(rooms));
  }

  private boolean[] seen;

  public boolean canVisitAllRooms(List<List<Integer>> rooms) {
    int n = rooms.size();
    seen = new boolean[n];
    seen[0] = true;

    List<Integer> zeroRoomKeys = rooms.get(0);
    for (Integer zeroRoomKey : zeroRoomKeys) {
      dfs(0, zeroRoomKey, rooms);
    }

    boolean isAllVisited = true;
    for (boolean s : seen) {
      isAllVisited = isAllVisited && s;
    }
    System.out.println(Arrays.toString(seen));
    return isAllVisited;
  }

  private void dfs(int currentRoom, Integer linkedRoom, List<List<Integer>> rooms) {
    if (linkedRoom == currentRoom) {
      return;
    }

    seen[linkedRoom] = true;

    List<Integer> nextRoomKeys = rooms.get(linkedRoom);
    for (int nextRoomKey : nextRoomKeys) {
      if (!seen[nextRoomKey]) {
        dfs(linkedRoom, nextRoomKey, rooms);
      }
    }
  }

}
