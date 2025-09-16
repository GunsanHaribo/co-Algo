package algorithm.P5_BinaryTree.P5_BounsProblem.P0_BinaryTree.important.p1325_Delete_Leaves_With_a_Given_Value.retry;

import algorithm.P5_BinaryTree.P1_Tree_Maker.TreeHelper;
import algorithm.P5_BinaryTree.P1_Tree_Maker.TreeNode;

public class p1325_Delete_Leaves_With_a_Given_Value {

  public static void main(String[] args) {
    p1325_Delete_Leaves_With_a_Given_Value solver = new p1325_Delete_Leaves_With_a_Given_Value();
    TreeNode root = TreeHelper.buildTree(new Integer[]{
        1, 2, 3, 2, null, 2, 4
    });
    int target = 2;

    TreeNode result = solver.removeLeafNodes(root, target);
//    System.out.println(result);
    TreeHelper.printLevelOrder(result);
  }

  public TreeNode removeLeafNodes(TreeNode root, int target) {
    if (root == null) {
      return null;
    }
    if (root.left == null && root.right == null) {
      if (root.val == target) {
        return null;
      }
      return root;
    }

    TreeNode left = removeLeafNodes(root.left, target);
    TreeNode right = removeLeafNodes(root.right, target);
    root.left = left;
    root.right = right;

    if (left == null && right == null) {
      if (root.val == target) {
        return null;
      }
    }
    return root;
  }

}
