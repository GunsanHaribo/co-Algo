package algorithm.leetCode_1회독중.P5_BinaryTree.P5_BounsProblem.P0_BinaryTree.P226_InvertBinaryTree.retry;

import algorithm.leetCode_1회독중.P5_BinaryTree.P1_Tree_Maker.TreeHelper;
import algorithm.leetCode_1회독중.P5_BinaryTree.P1_Tree_Maker.TreeNode;

public class P226_InvertBinaryTree {

  public static void main(String[] args) {
    P226_InvertBinaryTree solver = new P226_InvertBinaryTree();
    TreeNode treeNode = TreeHelper.buildTree(new Integer[]{4, 2, 7, 1, 3, 6, 9});

    System.out.println(solver.invertTree(treeNode));
    TreeHelper.printLevelOrder(treeNode);
  }

  public TreeNode invertTree(TreeNode root) {
    if (root == null) {
      return null;
    }

    TreeNode temp = root.left;
    root.left = invertTree(root.right);
    root.right = invertTree(temp);

    return root;
  }

}
