package algorithm.leetCode_1.P5_BinaryTree.p5_BounsProblem.P0_BinaryTree.important.P1_very.firstP1372_Longest_ZigZag_Path_in_a_Binary_Tree.t2025_10_27;

import algorithm.leetCode_1.P5_BinaryTree.p1_Tree_Maker.TreeHelper;
import algorithm.leetCode_1.P5_BinaryTree.p1_Tree_Maker.TreeNode;

public class again_p1372_Longest_ZigZag_Path_in_a_Binary_Tree {

  public static void main(String[] args) {
    again_p1372_Longest_ZigZag_Path_in_a_Binary_Tree solver = new again_p1372_Longest_ZigZag_Path_in_a_Binary_Tree();
//    TreeNode root = TreeHelper.buildTree(new Integer[]{
//        1, null, 2, 3, 4, null, null, 5, 6, null, 7, null, null, null, 8
//    });
//    TreeNode root = TreeHelper.buildTree(new Integer[]{
//        1, 1, 1, null, 1, null, 1, 1, null, 1, 1, null, 1
//    });

    TreeNode root = TreeHelper.buildTree(new Integer[]{
        1
    });

    System.out.println(solver.longestZigZag(root));
  }

  int max = 0;

  public int longestZigZag(TreeNode root) {
    // 초기는 방향이 없으므로 null
    dfs(root.left, true, 1);
    dfs(root.right, false, 1);
    return max;
  }

  public void dfs(TreeNode node, Boolean isLeft, int count) {
    if (node == null) {
      return;
    }

    max = Math.max(count, max);

    // 중간에서 다시 시작할수도 있지 않나?, 중간에서 하는건 안해도 되는건가?
    // 아니 중간이 있나? 밑으로 내려가면서 그냥 count하면 되는거 아닌가?
    if (isLeft) {
      dfs(node.left, true, 1);
      dfs(node.right, false, count + 1);
    }
    if (!isLeft) {
      dfs(node.left, true, count + 1);
      dfs(node.right, false, 1);
    }
  }

}
