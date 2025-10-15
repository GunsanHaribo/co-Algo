package algorithm.leetCode_1회독중.P5_BinaryTree.p4_BinarySearchTrees.example.p98_Validate_Binary_Search_Tree;

import algorithm.leetCode_1회독중.P5_BinaryTree.p1_Tree_Maker.TreeHelper;
import algorithm.leetCode_1회독중.P5_BinaryTree.p1_Tree_Maker.TreeNode;

public class Best_p98_Validate_Binary_Search_Tree {

  public static void main(String[] args) {
    Best_p98_Validate_Binary_Search_Tree solver = new Best_p98_Validate_Binary_Search_Tree();
//    TreeNode root = TreeHelper.buildTree(new Integer[]{5, 4, 6, null, null, 3, 7});
//    TreeNode root = TreeHelper.buildTree(new Integer[]{2, 2, 2});
    TreeNode root = TreeHelper.buildTree(new Integer[]{2147483647}); // 딱 걸치게 되는데
    System.out.println(solver.isValidBST(root));
  }

  public boolean isValidBST(TreeNode root) {
    return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE); // 범위를 맞춰서 넣어야 합니다., int, long 범위 맞춰야겠네
  }

  public boolean dfs(TreeNode node, long min, long max) {
    if (node == null) {
      return true;
    }
    // 여기서 걸리네,
    if (node.val <= min || node.val >= max) {
      return false;
    }

    boolean left = dfs(node.left, min, node.val);
    boolean right = dfs(node.right, node.val, max);
    return left && right;
  }

}
