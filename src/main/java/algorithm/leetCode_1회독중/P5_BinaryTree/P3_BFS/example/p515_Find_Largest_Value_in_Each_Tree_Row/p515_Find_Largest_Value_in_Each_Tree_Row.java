package algorithm.leetCode_1회독중.P5_BinaryTree.P3_BFS.example.p515_Find_Largest_Value_in_Each_Tree_Row;

import algorithm.leetCode_1회독중.P5_BinaryTree.P1_Tree_Maker.TreeHelper;
import algorithm.leetCode_1회독중.P5_BinaryTree.P1_Tree_Maker.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class p515_Find_Largest_Value_in_Each_Tree_Row {

  public static void main(String[] args) {
    p515_Find_Largest_Value_in_Each_Tree_Row solver = new p515_Find_Largest_Value_in_Each_Tree_Row();
    TreeNode root = TreeHelper.buildTree(new Integer[]{1, 3, 2, 5, 3, null, 9});
    System.out.println(solver.largestValues(root));
  }

  public List<Integer> largestValues(TreeNode root) {
    if (root == null) {
      return List.of();
    }

    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);

    List<Integer> largestValuesEachRows = new ArrayList<>();
    while (!queue.isEmpty()) {
      int rowSize = queue.size();
      int max = Integer.MIN_VALUE;
      for (int i = 0; i < rowSize; i++) {
        TreeNode polled = queue.poll();
        if (max < polled.val) {
          max = polled.val;
        }

        if (polled.left != null) {
          queue.add(polled.left);
        }
        if (polled.right != null) {
          queue.add(polled.right);
        }
      }
      largestValuesEachRows.add(max);
    }

    return largestValuesEachRows;
  }

}
