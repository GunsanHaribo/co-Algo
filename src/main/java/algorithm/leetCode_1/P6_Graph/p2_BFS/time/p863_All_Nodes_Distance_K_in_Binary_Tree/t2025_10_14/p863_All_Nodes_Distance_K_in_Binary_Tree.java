package algorithm.leetCode_1.P6_Graph.p2_BFS.time.p863_All_Nodes_Distance_K_in_Binary_Tree.t2025_10_14;

import algorithm.leetCode_1.P5_BinaryTree.p1_Tree_Maker.TreeHelper;
import algorithm.leetCode_1.P5_BinaryTree.p1_Tree_Maker.TreeNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class p863_All_Nodes_Distance_K_in_Binary_Tree {

  public static void main(String[] args) {
    p863_All_Nodes_Distance_K_in_Binary_Tree solver = new p863_All_Nodes_Distance_K_in_Binary_Tree();
    TreeNode root = TreeHelper.buildTree(new Integer[]{
        3, 5, 1, 6, 2, 0, 8, null, null, 7, 4
    });
    int target = 5;
    int k = 2;

//    TreeNode root = TreeHelper.buildTree(new Integer[]{1});
//    int target = 1;
//    int k = 3;
//
//    TreeNode root = TreeHelper.buildTree(new Integer[]{
//        0, 1, 3, null, 2
//    });
//    int target = 1;
//    int k = 2;

    System.out.println(solver.distanceK(root, new TreeNode(target), k));
  }

  Map<Integer, Set<Integer>> graph = new HashMap<>();
  Set<Integer> seen = new HashSet<>();

  public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
    dfsTree(root);
    System.out.println(graph);

    Queue<Integer> queue = new LinkedList<>();
    queue.add(target.val);
    seen.add(target.val);
    int count = 0;

    while (!queue.isEmpty()) {
      count++;
      if (count == k + 1) {
        return new ArrayList<>(queue);
      }

//      queue.size(); -> 이게 for문 안에드어가면 계속 추가되면 안끊김
//      for (int i = 0; i < queue.size(); i++) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        Integer poll = queue.poll();
        if (!graph.containsKey(poll)) {
          continue;
        }
        Set<Integer> nextNodes = graph.get(poll);
        for (int nextNode : nextNodes) {
          if (!seen.contains(nextNode)) {
            seen.add(nextNode);
            queue.add(nextNode);
          }
        }
      }
    }

    return List.of();
  }

  public void dfsTree(TreeNode node) {
    if (node == null) {
      return;
    }

    linkNode(node.val, node.left);
    linkNode(node.val, node.right);

    dfsTree(node.left);
    dfsTree(node.right);
  }

  public void linkNode(int parentNodeValue, TreeNode childNode) {
    if (childNode == null) {
      return;
    }
    Set<Integer> orDefault = graph.getOrDefault(parentNodeValue, new HashSet<>());
    orDefault.add(childNode.val);
    graph.put(parentNodeValue, orDefault);

    Set<Integer> orDefault2 = graph.getOrDefault(childNode.val, new HashSet<>());
    orDefault2.add(parentNodeValue);
    graph.put(childNode.val, orDefault2);
  }

}
