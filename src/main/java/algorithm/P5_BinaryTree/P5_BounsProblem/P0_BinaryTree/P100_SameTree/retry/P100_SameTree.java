package algorithm.P5_BinaryTree.P5_BounsProblem.P0_BinaryTree.P100_SameTree.retry;

import algorithm.P5_BinaryTree.P1_Tree_Maker.TreeHelper;
import algorithm.P5_BinaryTree.P1_Tree_Maker.TreeNode;

public class P100_SameTree {

  public static void main(String[] args) {
    P100_SameTree solver = new P100_SameTree();
//    TreeNode p = TreeHelper.buildTree(new Integer[]{1, 2, 3});
//    TreeNode q = TreeHelper.buildTree(new Integer[]{1, 2, 3});

//    TreeNode p = TreeHelper.buildTree(new Integer[]{10, 5, 15});
//    TreeNode q = TreeHelper.buildTree(new Integer[]{10, 5, null, null, 15});

    TreeNode p = TreeHelper.buildTree(new Integer[]{10, 5, 15, 1, 2, 3, 4});
    TreeNode q = TreeHelper.buildTree(new Integer[]{10, 5, 15, 1, 2, 3, 4});

    System.out.println(solver.isSameTree(p, q));
  }

  public boolean isSameTree(TreeNode p, TreeNode q) {
    if (p == null && q == null) {
      return true;
    }
    if (p == null || q == null) {
      return false;
    }

    boolean isSameVal = p.val == q.val;
    return isSameVal && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
  }

}
