package algorithm.leetCode_1회독중.P5_BinaryTree.P4_BinarySearchTrees.example.p530_Minimum_Absolute_Difference_in_BST.retry.best;

import algorithm.leetCode_1회독중.P5_BinaryTree.P1_Tree_Maker.TreeHelper;
import algorithm.leetCode_1회독중.P5_BinaryTree.P1_Tree_Maker.TreeNode;

public class Best_p530_Minimum_Absolute_Difference_in_BST {

  public static void main(String[] args) {
    Best_p530_Minimum_Absolute_Difference_in_BST solver = new Best_p530_Minimum_Absolute_Difference_in_BST();
//    TreeNode root = TreeHelper.buildTree(new Integer[]{4, 2, 6, 1, 3});
//    TreeNode root = TreeHelper.buildTree(new Integer[]{1, 0, 48, null, null, 12, 49});
//    TreeNode root = TreeHelper.buildTree(new Integer[]{1, null, 3, 2});
//    TreeNode root = TreeHelper.buildTree(new Integer[]{236, 104, 701, null, 227, null, 9112});
    TreeNode root = TreeHelper.buildTree(new Integer[]{600, 424, 612, null, 499, null, 689});

    System.out.println(solver.getMinimumDifference(root));
  }

  // TODO: 9/10/25  아이디어 좋네,
  private int minDiff = Integer.MAX_VALUE;
  private Integer p = null;

  public int getMinimumDifference(TreeNode root) {
    solve(root);
    return minDiff;
  }

  private void solve(TreeNode node) {
    if (node == null) {
      return;
    }

    solve(node.left);
    if (p != null) {
      minDiff = Math.min(minDiff, node.val - p);
    }
    p = node.val; // 오른쪽 너드가 더 크니깐 오른 - 가운데 노드 해주네, 위에 depth로 올라가면 더 작으니깐 상관없네
    solve(node.right);
  }

}
