package algorithm.leetCode_1회독중.P5_BinaryTree.p2_DFS.pratice.p111_Minimum_Depth_of_Binary_Tree.retry;

import algorithm.leetCode_1회독중.P5_BinaryTree.p1_Tree_Maker.TreeHelper;
import algorithm.leetCode_1회독중.P5_BinaryTree.p1_Tree_Maker.TreeNode;

public class p111_Minimum_Depth_of_Binary_Tree {

  public static void main(String[] args) {
    p111_Minimum_Depth_of_Binary_Tree solver = new p111_Minimum_Depth_of_Binary_Tree();
    TreeNode root = TreeHelper.buildTree(new Integer[]{3, 9, 20, null, null, 15, 7});
//    TreeNode root = TreeHelper.buildTree(new Integer[]{2, null, 3, null, 4, null, 5, null, 6});
    System.out.println(solver.minDepth(root));
  }

//  public int minDepth(TreeNode root) {
//    if (root == null) {
//      return 0;
//    }
//
//    int leftDepth = minDepth(root.left);
//    int rightDepth = minDepth(root.right);
//    if (leftDepth == 0) {
//      return rightDepth + 1;
//    }
//    if (rightDepth == 0) {
//      return leftDepth + 1;
//    }
//    return Math.min(leftDepth, rightDepth) + 1;
//  }

  public int minDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }

    int leftDepth = minDepth(root.left);
    int rightDepth = minDepth(root.right);
    if (leftDepth == 0 || rightDepth == 0) {
      return Math.max(leftDepth, rightDepth) + 1;
    }
    return Math.min(leftDepth, rightDepth) + 1;
  }

}
