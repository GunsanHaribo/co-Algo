package algorithm.leetCode_1.P5_BinaryTree.p5_BounsProblem.P0_BinaryTree.again.P1_very.P1372_Longest_ZigZag_Path_in_a_Binary_Tree;

import algorithm.leetCode_1.P5_BinaryTree.p1_Tree_Maker.TreeNode;
import algorithm.leetCode_1.P5_BinaryTree.p1_Tree_Maker.TreeHelper;

public class Time_Limit_p1372_Longest_ZigZag_Path_in_a_Binary_Tree {

  public static void main(String[] args) {
    Time_Limit_p1372_Longest_ZigZag_Path_in_a_Binary_Tree solver = new Time_Limit_p1372_Longest_ZigZag_Path_in_a_Binary_Tree();
    TreeNode root = TreeHelper.buildTree(
        new Integer[]{1, null, 2, 3, 4, null, null, 5, 6, null, 7, null, null, null, 8}
    );
//    TreeNode root = buildTree(
//        new Integer[]{1, 1, 1, null, 1, null, 1, 1, null, 1, 1, null, 1}
//    );
//    TreeNode root = buildTree(
//        new Integer[]{1}
//    );

    System.out.println(solver.longestZigZag(root));
  }

  private int maxZigZagNodesSum = 0;

  public int longestZigZag(TreeNode root) {
    dfs(root, null, 1);
    return maxZigZagNodesSum - 1;
  }

  public void dfs(TreeNode root, Boolean isLeft, int nodeCount) {
    if (root == null) {
      maxZigZagNodesSum = Math.max(nodeCount - 1, maxZigZagNodesSum);
      return;
    }

    // 둘다 보내야되고, 현재 노드 들어가기전에 미리 +1을 해준다
    if (isLeft == null) {
      dfs(root.left, true, nodeCount + 1);
      dfs(root.right, false, nodeCount + 1);
      return;
    }

    // left
    if (isLeft) {
      if (root.right != null) {
        dfs(root.right, false, nodeCount + 1);
        dfs(root, null, 1);
      }
      if (root.right == null) {
        maxZigZagNodesSum = Math.max(nodeCount, maxZigZagNodesSum);
        dfs(root.left, null, 1);
      }
    }

    // right
    if (!isLeft) {
      if (root.left != null) {
        dfs(root.left, true, nodeCount + 1);
        dfs(root, null, 1);
      }
      if (root.left == null) {
        maxZigZagNodesSum = Math.max(nodeCount, maxZigZagNodesSum);
        dfs(root.right, null, 1);
      }
    }
  }

}
