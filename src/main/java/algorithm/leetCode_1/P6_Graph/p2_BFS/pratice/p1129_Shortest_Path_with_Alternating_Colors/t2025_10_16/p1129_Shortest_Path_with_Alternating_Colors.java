package algorithm.leetCode_1.P6_Graph.p2_BFS.pratice.p1129_Shortest_Path_with_Alternating_Colors.t2025_10_16;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class p1129_Shortest_Path_with_Alternating_Colors {

  public static void main(String[] args) {
    p1129_Shortest_Path_with_Alternating_Colors solver = new p1129_Shortest_Path_with_Alternating_Colors();
//    int n = 3;
//    int[][] redEdges = {
//        {0, 1},
//        {1, 2}
//    };
//    int[][] blueEdges = {};
//
//    int n = 3;
//    int[][] redEdges = {
//        {0, 1}
//    };
//    int[][] blueEdges = {
//        {2, 1}
//    };

    int n = 3;
    int[][] redEdges = {
        {1, 0}
    };
    int[][] blueEdges = {
        {2, 1}
    };

//    int n = 5;
//    int[][] redEdges = {
//        {0, 1},
//        {1, 2},
//        {2, 3},
//        {3, 4}
//    };
//    int[][] blueEdges = {
//        {1, 2},
//        {2, 3},
//        {3, 1}
//    };

    System.out.println(Arrays.toString(solver.shortestAlternatingPaths(n, redEdges, blueEdges)));
  }

  public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
    // 0. 간선 배열 인접리스트로 변환
    Map<Integer, Set<Integer>> redNearLists = new HashMap<>();
    int redN = redEdges.length;
    for (int i = 0; i < redN; i++) {
      Set<Integer> orDefault = redNearLists.getOrDefault(redEdges[i][0], new HashSet<>());
      orDefault.add(redEdges[i][1]);
      redNearLists.put(redEdges[i][0], orDefault);
    }
    System.out.println(redNearLists);

    Map<Integer, Set<Integer>> blueNearLists = new HashMap<>();
    int blueM = blueEdges.length;
    for (int i = 0; i < blueM; i++) {
      Set<Integer> orDefault = blueNearLists.getOrDefault(blueEdges[i][0], new HashSet<>());
      orDefault.add(blueEdges[i][1]);
      blueNearLists.put(blueEdges[i][0], orDefault);
    }
    System.out.println(blueNearLists);

    ////////////////////////////
    // 1. BFS
    // 1-1. blue의 경우, red의 경우 나눠서 진행,
    // 둘다 -1이 아니라면 최소 뽑기
    int[] answer = new int[n];
    answer[0] = 0;
    for (int i = 1; i < n; i++) {
      int shortPathStartRed = bfs(i, redNearLists, blueNearLists, n, true);
      int shortPathStartBlue = bfs(i, redNearLists, blueNearLists, n, false);
      if (shortPathStartRed == -1 && shortPathStartBlue == -1) {
        answer[i] = -1;
        continue;
      }
      if (shortPathStartRed == -1) {
        answer[i] = shortPathStartBlue - 1;
        continue;
      }
      if (shortPathStartBlue == -1) {
        answer[i] = shortPathStartRed - 1;
        continue;
      }

      int min = Math.min(shortPathStartRed, shortPathStartBlue) - 1;
      answer[i] = min;
    }

    return answer;
  }

  public int bfs(
      int x,
      Map<Integer, Set<Integer>> redNearLists,
      Map<Integer, Set<Integer>> blueNearLists,
      int n,
      boolean isRed
  ) {
    boolean[] seenRed = new boolean[n];
    boolean[] seenBlue = new boolean[n];
    Queue<Integer> queue = new LinkedList<>();
    queue.add(0);
    if (isRed) {
      seenRed[0] = true;
    } else {
      seenBlue[0] = true;
    }

    int count = 0;
    while (!queue.isEmpty()) {
      count++;

      int tempQSize = queue.size();
      for (int i = 0; i < tempQSize; i++) {
        Integer poll = queue.poll();
        if (poll == x) {
          return count;
        }

        if (isRed) {
          Set<Integer> nextNodes = blueNearLists.get(poll);
          if (nextNodes == null) {
            continue;
          }
          for (int nextNode : nextNodes) {
            if (!seenRed[nextNode]) {
              seenRed[nextNode] = true;
              queue.add(nextNode);
            }
          }
        }

        if (!isRed) {
          Set<Integer> nextNodes = redNearLists.get(poll);
          if (nextNodes == null) {
            continue;
          }
          for (int nextNode : nextNodes) {
            if (!seenBlue[nextNode]) {
              seenBlue[nextNode] = true;
              queue.add(nextNode);
            }
          }
        }
      }
      isRed = !isRed;
    }

    return -1;
  }

}
