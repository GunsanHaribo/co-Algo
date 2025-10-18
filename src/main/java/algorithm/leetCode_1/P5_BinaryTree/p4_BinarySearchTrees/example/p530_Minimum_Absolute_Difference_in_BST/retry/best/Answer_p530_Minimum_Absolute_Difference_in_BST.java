package algorithm.leetCode_1.P5_BinaryTree.p4_BinarySearchTrees.example.p530_Minimum_Absolute_Difference_in_BST.retry.best;

import algorithm.leetCode_1.P5_BinaryTree.p1_Tree_Maker.TreeHelper;
import algorithm.leetCode_1.P5_BinaryTree.p1_Tree_Maker.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class Answer_p530_Minimum_Absolute_Difference_in_BST {

  public static void main(String[] args) {
    Answer_p530_Minimum_Absolute_Difference_in_BST solver = new Answer_p530_Minimum_Absolute_Difference_in_BST();
    TreeNode root = TreeHelper.buildTree(new Integer[]{1, 0, 48, null, null, 12, 49});
    System.out.println(solver.getMinimumDifference(root));
  }

  public int getMinimumDifference(TreeNode root) {
    List<Integer> values = new ArrayList<>();
    dfs(root, values);
    int ans = Integer.MAX_VALUE;
    for (int i = 1; i < values.size(); i++) {
      ans = Math.min(ans, values.get(i) - values.get(i - 1));
    }

    return ans;
  }

  public void dfs(TreeNode node, List<Integer> values) {
    if (node == null) {
      return;
    }

    dfs(node.left, values);
    values.add(node.val);
    dfs(node.right, values);
  }

}
