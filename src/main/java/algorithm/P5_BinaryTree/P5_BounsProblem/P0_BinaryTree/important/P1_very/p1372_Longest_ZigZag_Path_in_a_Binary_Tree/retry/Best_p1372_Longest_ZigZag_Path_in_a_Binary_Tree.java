package algorithm.P5_BinaryTree.P5_BounsProblem.P0_BinaryTree.important.P1_very.p1372_Longest_ZigZag_Path_in_a_Binary_Tree.retry;

import algorithm.P5_BinaryTree.P1_Tree_Maker.TreeHelper;
import algorithm.P5_BinaryTree.P1_Tree_Maker.TreeNode;

public class Best_p1372_Longest_ZigZag_Path_in_a_Binary_Tree {

  public static void main(String[] args) {
    Best_p1372_Longest_ZigZag_Path_in_a_Binary_Tree solver = new Best_p1372_Longest_ZigZag_Path_in_a_Binary_Tree();
    TreeNode root = TreeHelper.buildTree(new Integer[]{
        1, null, 1, 1, 1, null, null, 1, 1, null, 1, null, null, null, 1
    });
//    TreeNode root = TreeHelper.buildTree(new Integer[]{
//        1, 1, 1, null, 1, null, 1, 1, null, 1, 1, null, 1
//    });
//    TreeNode root = TreeHelper.buildTree(new Integer[]{
//        1
//    });

    System.out.println(solver.longestZigZag(root));
  }

  public int longestZigZag(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int max = 0;
    // 1. 현재 노드에서 left, right 보내는거랑
    max = Math.max(max, longestZigZagSubTree(root.left, true, 1)); // 현재 count+1
    max = Math.max(max, longestZigZagSubTree(root.right, false, 1));

    // 2. 아예 rigth, left부터 다시 시작하는 거랑
    max = Math.max(max, longestZigZag(root.left));
    max = Math.max(max, longestZigZag(root.right));

    return max;
  }

  public int longestZigZagSubTree(TreeNode root, boolean isLeft, int count) {
    if (root == null) {
      return 0;
    }

    // 만약에 left인데 right가 없으면 count 반환
    if (isLeft) {
      if (root.right == null) {
        return count;
      }
      return longestZigZagSubTree(root.right, false, count + 1);
    }

    // 만약에 right인데 left가 없으면 count 반환
    if (root.left == null) {
      return count;
    }
    return longestZigZagSubTree(root.left, true, count + 1);
  }

}
