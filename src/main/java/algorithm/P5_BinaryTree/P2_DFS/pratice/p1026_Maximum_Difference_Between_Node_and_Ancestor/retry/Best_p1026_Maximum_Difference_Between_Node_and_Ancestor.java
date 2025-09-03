package algorithm.P5_BinaryTree.P2_DFS.pratice.p1026_Maximum_Difference_Between_Node_and_Ancestor.retry;

import algorithm.P5_BinaryTree.P1_Tree_Maker.TreeHelper;
import algorithm.P5_BinaryTree.P1_Tree_Maker.TreeNode;

public class Best_p1026_Maximum_Difference_Between_Node_and_Ancestor {

  public static void main(String[] args) {
    Best_p1026_Maximum_Difference_Between_Node_and_Ancestor solver = new Best_p1026_Maximum_Difference_Between_Node_and_Ancestor();
//    TreeNode root = TreeHelper.buildTree(
//        new Integer[]{8, 3, 10, 1, 6, null, 14, null, null, 4, 7, 13});

    TreeNode root = TreeHelper.buildTree(
        new Integer[]{1, null, 2, null, 0, 3});

    System.out.println(solver.maxAncestorDiff(root));
  }

  public int maxAncestorDiff(TreeNode root) {
    return findMaxDiff(root, root.val, root.val);
  }

  public int findMaxDiff(TreeNode root, int min, int max) {
    if (root == null) {
      return max - min; // min, max이 양수여서 abs 없어도 됨, 그리고 애초에 max여서
    }

    int currentMax = Math.max(max, root.val);
    int currentMin = Math.min(min, root.val);

    return Math.max(
        findMaxDiff(root.left, currentMin, currentMax),
        findMaxDiff(root.right, currentMin, currentMax)
    );
  }

}
