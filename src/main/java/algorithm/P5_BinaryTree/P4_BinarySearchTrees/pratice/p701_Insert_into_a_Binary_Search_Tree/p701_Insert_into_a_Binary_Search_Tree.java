package algorithm.P5_BinaryTree.P4_BinarySearchTrees.pratice.p701_Insert_into_a_Binary_Search_Tree;

import algorithm.P5_BinaryTree.P1_Tree_Maker.TreeHelper;
import algorithm.P5_BinaryTree.P1_Tree_Maker.TreeNode;

public class p701_Insert_into_a_Binary_Search_Tree {

  public static void main(String[] args) {
    p701_Insert_into_a_Binary_Search_Tree solver = new p701_Insert_into_a_Binary_Search_Tree();
//    TreeNode root = TreeHelper.buildTree(new Integer[]{4, 2, 7, 1, 3});
//    int val = 5;
//    TreeNode root = TreeHelper.buildTree(
//        new Integer[]{4, 2, 7, 1, 3, null, null, null, null, null}
//    );
//    int val = 5;

//    TreeNode root = TreeHelper.buildTree(new Integer[]{40, 20, 60, 10, 30, 50, 70});
//    int val = 25;
    TreeNode root = TreeHelper.buildTree(new Integer[]{});
    int val = 5;

    TreeHelper.printLevelOrder(solver.insertIntoBST(root, val));
  }

  public TreeNode insertIntoBST(TreeNode root, int val) {
    if (root == null) {
      return new TreeNode(val);
    }

    insert(root, val);
    return root;
  }

  public void insert(TreeNode root, int val) {
    if (root == null) {
      return;
    }

    if (root.val > val) {
      if (root.left == null) {
        root.left = new TreeNode(val);
      } else {
        insertIntoBST(root.left, val);
      }
    }

    if (root.val < val) {
      if (root.right == null) {
        root.right = new TreeNode(val);
      } else {
        insertIntoBST(root.right, val);
      }
    }
  }

}
