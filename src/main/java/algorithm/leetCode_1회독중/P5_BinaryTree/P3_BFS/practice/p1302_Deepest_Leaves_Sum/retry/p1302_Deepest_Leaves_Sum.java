package algorithm.leetCode_1회독중.P5_BinaryTree.P3_BFS.practice.p1302_Deepest_Leaves_Sum.retry;

import algorithm.leetCode_1회독중.P5_BinaryTree.P1_Tree_Maker.TreeHelper;
import algorithm.leetCode_1회독중.P5_BinaryTree.P1_Tree_Maker.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

public class p1302_Deepest_Leaves_Sum {

  public static void main(String[] args) {
    p1302_Deepest_Leaves_Sum solver = new p1302_Deepest_Leaves_Sum();
//    TreeNode root = TreeHelper.buildTree(
//        new Integer[]{1, 2, 3, 4, 5, null, 6, 7, null, null, null, null, 8}
//    );
    TreeNode root = TreeHelper.buildTree(
        new Integer[]{6, 7, 8, 2, 7, 1, 3, 9, null, 1, 4, null, null, null, 5}
    );
    System.out.println(solver.deepestLeavesSum(root));
  }

  public int deepestLeavesSum(TreeNode root) {
    if (root == null) {
      return 0;
    }

    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    int sum = 0;
    while (!queue.isEmpty()) {
      sum = 0;
      int rowSize = queue.size();

      for (int i = 0; i < rowSize; i++) {
        TreeNode polled = queue.poll();
        sum += polled.val;
        if (polled.left != null) {
          queue.add(polled.left);
        }
        if (polled.right != null) {
          queue.add(polled.right);
        }
      }
    }

    return sum;
  }

}
