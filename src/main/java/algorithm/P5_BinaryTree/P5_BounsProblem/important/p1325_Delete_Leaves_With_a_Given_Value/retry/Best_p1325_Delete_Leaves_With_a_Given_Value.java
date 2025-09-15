package algorithm.P5_BinaryTree.P5_BounsProblem.important.p1325_Delete_Leaves_With_a_Given_Value.retry;

import algorithm.P5_BinaryTree.P1_Tree_Maker.TreeHelper;
import algorithm.P5_BinaryTree.P1_Tree_Maker.TreeNode;

public class Best_p1325_Delete_Leaves_With_a_Given_Value {

  public static void main(String[] args) {
    Best_p1325_Delete_Leaves_With_a_Given_Value solver = new Best_p1325_Delete_Leaves_With_a_Given_Value();
    TreeNode root = TreeHelper.buildTree(new Integer[]{
        1, 2, 3, 2, null, 2, 4
    });
    int target = 2;

    TreeNode result = solver.removeLeafNodes(root, target);
    TreeHelper.printLevelOrder(result);
  }

  public TreeNode removeLeafNodes(TreeNode root, int target) {
    if (root == null) {
      return null;
    }
    TreeNode left = removeLeafNodes(root.left, target);
    TreeNode right = removeLeafNodes(root.right, target);
    root.left = left;
    root.right = right;

    if (root.left == null && root.right == null) {
      if (root.val == target) {
        return null;
      }
    }
    return root;
  }

}
