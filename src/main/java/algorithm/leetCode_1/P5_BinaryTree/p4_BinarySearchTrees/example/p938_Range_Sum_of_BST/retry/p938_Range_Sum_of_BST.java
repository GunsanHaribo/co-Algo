package algorithm.leetCode_1.P5_BinaryTree.p4_BinarySearchTrees.example.p938_Range_Sum_of_BST.retry;

import algorithm.leetCode_1.P5_BinaryTree.p1_Tree_Maker.TreeHelper;
import algorithm.leetCode_1.P5_BinaryTree.p1_Tree_Maker.TreeNode;

public class p938_Range_Sum_of_BST {

  public static void main(String[] args) {
    p938_Range_Sum_of_BST solver = new p938_Range_Sum_of_BST();
//    TreeNode root = TreeHelper.buildTree(new Integer[]{10, 5, 15, 3, 7, null, 18});
//    int low = 7;
//    int high = 15;

    TreeNode root = TreeHelper.buildTree(new Integer[]{10,5,15,3,7,13,18,1,null,6});
    int low = 6;
    int high = 10;

    System.out.println(solver.rangeSumBST(root, low, high));
  }

  public int rangeSumBST(TreeNode root, int low, int high) {
    if (root == null) {
      return 0;
    }
    if (root.val < low) {
      return rangeSumBST(root.right, low, high);
    }
    if (root.val > high) {
      return rangeSumBST(root.left, low, high);
    }

    return rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high) + root.val;
  }

}
