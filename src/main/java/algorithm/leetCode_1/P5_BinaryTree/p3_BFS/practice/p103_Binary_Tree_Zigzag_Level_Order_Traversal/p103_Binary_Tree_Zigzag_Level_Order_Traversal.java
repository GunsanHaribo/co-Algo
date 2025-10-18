package algorithm.leetCode_1.P5_BinaryTree.p3_BFS.practice.p103_Binary_Tree_Zigzag_Level_Order_Traversal;

import algorithm.leetCode_1.P5_BinaryTree.p1_Tree_Maker.TreeHelper;
import algorithm.leetCode_1.P5_BinaryTree.p1_Tree_Maker.TreeNode;

import java.util.*;

public class p103_Binary_Tree_Zigzag_Level_Order_Traversal {

  public static void main(String[] args) {
    p103_Binary_Tree_Zigzag_Level_Order_Traversal solver = new p103_Binary_Tree_Zigzag_Level_Order_Traversal();
//    TreeNode root = TreeHelper.buildTree(new Integer[]{3, 9, 20, null, null, 15, 7});
//    TreeNode root = TreeHelper.buildTree(new Integer[]{1, 2, 3, 4, null, null, 5});
    TreeNode root = TreeHelper.buildTree(
        new Integer[]{0, 2, 4, 1, null, 3, -1, 5, 1, null, 6, null, 8}
    );
    System.out.println(solver.zigzagLevelOrder(root));
  }

  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    if (root == null) {
      return List.of();
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);

    boolean rightFirst = false;
    List<List<Integer>> results = new ArrayList<>();
    while (!queue.isEmpty()) {
      int rowSize = queue.size();

      List<Integer> rowNodeValues = new ArrayList<>();
      for (int i = 0; i < rowSize; i++) {
        TreeNode polled = queue.poll();
        rowNodeValues.add(polled.val);

        if (polled.left != null) {
          queue.add(polled.left);
        }
        if (polled.right != null) {
          queue.add(polled.right);
        }
      }

      List<Integer> temp = new ArrayList<>();
      if (rightFirst) {
        for (int i = rowNodeValues.size() - 1; i >= 0; i--) {
          temp.add(rowNodeValues.get(i));
        }
//        rowNodeValues = rowNodeValues.stream()
//            .sorted(Comparator.reverseOrder())
//            .toList();
      }else {
        temp = rowNodeValues;
      }
      results.add(temp);
      rightFirst = !rightFirst;
    }

    return results;
  }

}