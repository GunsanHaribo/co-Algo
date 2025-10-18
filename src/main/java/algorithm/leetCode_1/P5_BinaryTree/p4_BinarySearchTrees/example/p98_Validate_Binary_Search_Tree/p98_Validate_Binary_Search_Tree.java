package algorithm.leetCode_1.P5_BinaryTree.p4_BinarySearchTrees.example.p98_Validate_Binary_Search_Tree;

import algorithm.leetCode_1.P5_BinaryTree.p1_Tree_Maker.TreeHelper;
import algorithm.leetCode_1.P5_BinaryTree.p1_Tree_Maker.TreeNode;

public class p98_Validate_Binary_Search_Tree {

  public static void main(String[] args) {
    p98_Validate_Binary_Search_Tree solver = new p98_Validate_Binary_Search_Tree();
//    TreeNode root = TreeHelper.buildTree(new Integer[]{2, 1, 3});
//    TreeNode root = TreeHelper.buildTree(new Integer[]{5, 1, 4, null, null, 3, 6});
    TreeNode root = TreeHelper.buildTree(new Integer[]{5, 4, 6, null, null, 3, 7});

    System.out.println(solver.isValidBST(root));
  }

  public boolean isValidBST(TreeNode root) {
    if (root == null) {
      return true;
    }

    boolean isCurrentSmallLeft = true;
    if (root.left != null) {
      isCurrentSmallLeft = root.left.val < root.val;
    }
    boolean isCurrentBigRight = true;
    if (root.right != null) {
      isCurrentBigRight = root.right.val > root.val;
    }

    boolean isCurrentRight = isCurrentSmallLeft && isCurrentBigRight;
    boolean isSubTree = isValidBST(root.left) && isValidBST(root.right);

    return isCurrentRight && isSubTree;
  }

}
