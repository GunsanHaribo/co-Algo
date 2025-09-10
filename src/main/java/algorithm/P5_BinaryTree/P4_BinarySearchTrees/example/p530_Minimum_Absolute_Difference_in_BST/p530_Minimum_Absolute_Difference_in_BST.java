package algorithm.P5_BinaryTree.P4_BinarySearchTrees.example.p530_Minimum_Absolute_Difference_in_BST;

import algorithm.P5_BinaryTree.P1_Tree_Maker.TreeHelper;
import algorithm.P5_BinaryTree.P1_Tree_Maker.TreeNode;

public class p530_Minimum_Absolute_Difference_in_BST {

  public static void main(String[] args) {
    p530_Minimum_Absolute_Difference_in_BST solver = new p530_Minimum_Absolute_Difference_in_BST();
//    TreeNode root = TreeHelper.buildTree(new Integer[]{4, 2, 6, 1, 3});
//    TreeNode root = TreeHelper.buildTree(new Integer[]{1, 0, 48, null, null, 12, 49});
//    TreeNode root = TreeHelper.buildTree(new Integer[]{1, null, 3, 2});
//    TreeNode root = TreeHelper.buildTree(new Integer[]{236, 104, 701, null, 227, null, 9112});
    TreeNode root = TreeHelper.buildTree(new Integer[]{600, 424, 612, null, 499, null, 689});

    System.out.println(solver.getMinimumDifference(root));
  }

  public int getMinimumDifference(TreeNode root) {
    if (root == null) {
      return Integer.MAX_VALUE;
    }

    Integer leftNodeRightest = findRightest(root.left);
    if (leftNodeRightest != null) {
      leftNodeRightest = Math.abs(root.val - leftNodeRightest);
    } else {
      leftNodeRightest = Integer.MAX_VALUE;
    }
    Integer rightNodeLeftest = findLeftest(root.right);
    if (rightNodeLeftest != null) {
      rightNodeLeftest = Math.abs(findLeftest(root.right) - (root.val));
    } else {
      rightNodeLeftest = Integer.MAX_VALUE;
    }

    int currentMin = Math.min(
        leftNodeRightest,
        rightNodeLeftest
    );
    int childMinDiff = Math.min(getMinimumDifference(root.left), getMinimumDifference(root.right));

    return Math.min(currentMin, childMinDiff);
  }

  public Integer findRightest(TreeNode node) {
    if (node == null) {
      return null;
    }
    if (node.right == null && node.left == null) {
      return node.val;
    }

    return findRightest(node.right);
  }

  public Integer findLeftest(TreeNode node) {
    if (node == null) {
      return null;
    }
    if (node.right == null && node.left == null) {
      return node.val;
    }

    return findLeftest(node.left);
  }

  // TODO: 9/9/25 이건 이전것
  public int getMinimumDifference_failed(TreeNode root) {
    if (root == null) {
      return Integer.MAX_VALUE; // 이것도 살짝.. 문제가 될수도
    }
    if (root.left == null && root.right == null) {
      return Integer.MAX_VALUE;
    }

    int currentMin = Integer.MAX_VALUE;
    if (root.left == null && root.right != null) {
      currentMin = root.right.val - root.val;
    }
    if (root.left != null && root.right == null) {
      currentMin = root.val - root.left.val;
    }
    if (root.left != null && root.right != null) {
      currentMin = Math.min(root.right.val - root.val, root.val - root.left.val);
    }

    return Math.min(
        currentMin,
        Math.min(getMinimumDifference_failed(root.left), getMinimumDifference_failed(root.right))
    );
  }

}
