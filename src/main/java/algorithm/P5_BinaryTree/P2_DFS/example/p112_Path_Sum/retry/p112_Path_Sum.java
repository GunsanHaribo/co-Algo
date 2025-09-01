package algorithm.P5_BinaryTree.P2_DFS.example.p112_Path_Sum.retry;

import algorithm.P5_BinaryTree.P1_Tree_Maker.TreeHelper;
import algorithm.P5_BinaryTree.P1_Tree_Maker.TreeNode;

public class p112_Path_Sum {

  public static void main(String[] args) {
//    TreeNode root = TreeHelper.buildTree(
//        new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1}
//    );
//    int targetSum = 22;
    TreeNode root = TreeHelper.buildTree(
        new Integer[]{1, 2}
    );
    int targetSum = 1;
    p112_Path_Sum pathSum = new p112_Path_Sum();
    System.out.println(pathSum.hasPathSum(root, targetSum));
  }

  public boolean hasPathSum(TreeNode node, int targetSum) {
    if (node == null) {
      return false;
    }
    // 리프노드 조건 추가
    if (node.right == null && node.left == null) {
//      return true;
      return node.val == targetSum;
    }

    boolean left = hasPathSum(node.left, targetSum - node.val);
    boolean right = hasPathSum(node.right, targetSum - node.val);

    return left || right;
  }

}