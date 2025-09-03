package algorithm.P5_BinaryTree.P2_DFS.pratice.p543_Diameter_of_Binary_Tree.retry;

import algorithm.P5_BinaryTree.P1_Tree_Maker.TreeHelper;
import algorithm.P5_BinaryTree.P1_Tree_Maker.TreeNode;

public class p543_Diameter_of_Binary_Tree {

  public static void main(String[] args) {
    p543_Diameter_of_Binary_Tree solver = new p543_Diameter_of_Binary_Tree();
    TreeNode root = TreeHelper.buildTree(new Integer[]{1, 2, 3, 4, 5});
//    TreeNode root = TreeHelper.buildTree(new Integer[]{1, 2});
    System.out.println(solver.diameterOfBinaryTree(root));
  }

  public int diameterOfBinaryTree(TreeNode root) {
    return maxDiameter(root, 0);
  }

  public int maxDiameter(TreeNode node, int currentDepth) { // 이건 그냥 diameter인데, 따로 계산 하는 로직이 있나?
    if (node == null) {
      return currentDepth - 1;
    }

    return Math.max(
        maxDiameter(node.left, currentDepth + 1),
        maxDiameter(node.right, currentDepth + 1)
    );
  }


  // TODO: 9/3/25 이전 풀이
  public int diameterOfBinaryTree0(TreeNode root) {
    if (root == null) {
      return 0;
    }

    int leftDepth = maxDepth(root.left) - 1;
    int rightDepth = maxDepth(root.right) - 1;

    return Math.max(
        leftDepth + rightDepth + 2,
        Math.max(
            diameterOfBinaryTree(root.left),
            diameterOfBinaryTree(root.right)
        )
    );
  }

  public int maxDepth(TreeNode node) {
    if (node == null) {
      return 0;
    }
    return Math.max(maxDepth(node.left), maxDepth(node.right)) + 1;
  }


  // TODO: 9/3/25 전역 변수 있는게 조금 마음에 안들긴하네
  int diameter = 0;

  public int diameterOfBinaryTree2(TreeNode root) {
    height(root);
    return diameter;
  }

  int height(TreeNode root) {
    if (root == null) {
      return 0;
    }

    int leftHeight = height(root.left);
    int rightHeight = height(root.right);

    diameter = Math.max(diameter, leftHeight + rightHeight);

    return 1 + Math.max(leftHeight, rightHeight);
  }

}
