package algorithm.leetCode_1회독중.P5_BinaryTree.p5_BounsProblem.P0_BinaryTree.P101_Symmetric_Tree.retry;

import algorithm.leetCode_1회독중.P5_BinaryTree.p1_Tree_Maker.TreeHelper;
import algorithm.leetCode_1회독중.P5_BinaryTree.p1_Tree_Maker.TreeNode;

public class p101_Symmetric_Tree {

  public static void main(String[] args) {
    p101_Symmetric_Tree solver = new p101_Symmetric_Tree();
    TreeNode root = TreeHelper.buildTree(new Integer[]{1, 2, 2, 3, 4, 4, 3});

    System.out.println(solver.isSymmetric(root));
  }

  public boolean isSymmetric(TreeNode root) {
    if (root == null) {
      return false;
    }

    return dfs(root.left, root.right);
  }

  public boolean dfs(TreeNode left, TreeNode right) {
    if (left == null && right == null) {
      return true;
    }
    if (left == null || right == null) {
      return false;
    }

    boolean isSymmetricCurrentValue = left.val == right.val;
    return isSymmetricCurrentValue && dfs(left.left, right.right) && dfs(left.right, right.left);
  }

}

