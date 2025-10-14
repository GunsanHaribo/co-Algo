package algorithm.P6_Graph.p1_DFS.a_important.p1557_Minimum_Number_of_Vertices_to_Reach_All_Nodes.t2025_10_13;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

//    int n = 5;
//    List<List<Integer>> edges = List.of(
//        List.of(0, 1),
//        List.of(2, 1),
//        List.of(3, 1),
//        List.of(1, 4),
//        List.of(2, 4)
//    );
//
//    int n = 4;
//    List<List<Integer>> edges = List.of(
//        List.of(2, 0),
//        List.of(0, 3),
//        List.of(3, 1)
//    );// 기댓값은 [2]
    System.out.println(solver.findSmallestSetOfVertices(n, edges));
  }

  private boolean[] seen;

  public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
    // seen 배열
    seen = new boolean[n];

    // 간선배열, 인접리스트로 변경
    Map<Integer, HashSet<Integer>> nearList = new HashMap<>();
    for (List<Integer> edge : edges) {
      Integer startNode = edge.get(0);
      Integer endNode = edge.get(1);

      HashSet<Integer> orDefault = nearList.getOrDefault(startNode, new HashSet<>());
      orDefault.add(endNode);
      nearList.put(startNode, orDefault);
    }
    System.out.println(nearList);

    // 전체 순회
    // 단, 연결된게 많은 것부터 순회 -> 실패
    // 돌면서 어디 노드 다녀왔는지 추가 해주자 -> 이전 문제랑 비슷한데
    Set<Integer> nodes = new HashSet<>();
    for (int node : nearList.keySet()) {
      if (!seen[node]) {
        nodes.add(node);
        dfs(node, nearList);
      }
    }
    System.out.println(nodes);

    // 부분집합에 포함되는지 확인
    // 겹치는게 있잖아, 겹치는게 있으면 안됨, 하나라도 다른게 있으면 살려둬야함
    Map<Integer, Set<Integer>> nodePossibleWays = new HashMap<>();
    for (int node : nodes) {
      Set<Integer> set = new HashSet<>();
      set.add(node); // 본인도 들어가야함
      dfsPossibleWay(node, set, nearList);
      nodePossibleWays.put(node, set);
    }
    System.out.println(nodePossibleWays);

    List<Integer> sub = new ArrayList<>();
    for (Integer key : nodes) {
      for (Integer key2 : nodes) {
        if (key.equals(key2)) {
          continue;
        }
        if (nodePossibleWays.get(key).containsAll(nodePossibleWays.get(key2))) {
          sub.add(key2);
        }
      }
    }

    // 기록해 놓은거 삭제
    for (Integer subValue : sub) {
      nodes.remove(subValue);
    }

    System.out.println("정답");
    return new ArrayList<>(nodes);
  }

  public void dfsPossibleWay(
      int node,
      Set<Integer> record,
      Map<Integer, HashSet<Integer>> nearList
  ) {
    HashSet<Integer> integers = nearList.get(node);
    if (integers == null) {
      return;
    }
    for (Integer value : integers) {
      record.add(value);
      dfsPossibleWay(value, record, nearList);
    }
  }

  public void dfs(int node, Map<Integer, HashSet<Integer>> nearList) {
    seen[node] = true;

    HashSet<Integer> integers = nearList.get(node);
    if (integers == null) {
      return;
    }
    for (Integer value : integers) {
      if (!seen[value]) {
        dfs(value, nearList);
      }
    }
  }

}
