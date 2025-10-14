package algorithm.leetCode_1회독중.P5_BinaryTree.P2_DFS.example.p100_Same_Tree.retry;

import algorithm.leetCode_1회독중.P5_BinaryTree.P1_Tree_Maker.TreeHelper;
import algorithm.leetCode_1회독중.P5_BinaryTree.P1_Tree_Maker.TreeNode;

public class p100_Same_Tree {

  public static void main(String[] args) {
//    TreeNode p = TreeHelper.buildTree(new Integer[]{1, 2});
//    TreeNode q = TreeHelper.buildTree(new Integer[]{1, null, 2});

    TreeNode p = TreeHelper.buildTree(new Integer[]{1, 2, 3});
    TreeNode q = TreeHelper.buildTree(new Integer[]{1, 2, 3});
    p100_Same_Tree solver = new p100_Same_Tree();
    System.out.println(solver.isSameTree(p, q));
  }

  public boolean isSameTree(TreeNode p, TreeNode q) {
    if (p == null && q == null) {
      return true;
    }
    if (p == null || q == null) {
      return false;
    }

    boolean left = isSameTree(p.left, q.left);
    boolean right = isSameTree(p.right, q.right);

    return p.val == q.val && left && right;
  }

}
