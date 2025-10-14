package algorithm.leetCode_1회독중.P5_BinaryTree.P4_BinarySearchTrees.example.p938_Range_Sum_of_BST;

import algorithm.leetCode_1회독중.P5_BinaryTree.P1_Tree_Maker.TreeNode;
import algorithm.leetCode_1회독중.P5_BinaryTree.P1_Tree_Maker.TreeHelper;

public class p938_Range_Sum_of_BST {

  public static void main(String[] args) {
    int low = 6;
    int high = 10;
    TreeNode root = TreeHelper.buildTree(new Integer[]{10, 5, 15, 3, 7, 13, 18, 1, null, 6});

    System.out.println(rangeSumBST(root, low, high));

  }

  public static int rangeSumBST(TreeNode root, int low, int high) {
    if (root == null) {
      return 0;
    }

    if (low <= root.val && root.val <= high) {
      return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
    }

    if (root.val < low) {
      return rangeSumBST(root.right, low, high);
    }

    return rangeSumBST(root.left, low, high);
  }

}
