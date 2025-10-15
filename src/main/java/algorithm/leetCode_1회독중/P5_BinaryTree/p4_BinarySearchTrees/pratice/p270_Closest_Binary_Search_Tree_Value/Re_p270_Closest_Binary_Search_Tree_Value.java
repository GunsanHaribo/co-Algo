package algorithm.leetCode_1회독중.P5_BinaryTree.p4_BinarySearchTrees.pratice.p270_Closest_Binary_Search_Tree_Value;

import algorithm.leetCode_1회독중.P5_BinaryTree.p1_Tree_Maker.TreeHelper;
import algorithm.leetCode_1회독중.P5_BinaryTree.p1_Tree_Maker.TreeNode;

public class Re_p270_Closest_Binary_Search_Tree_Value {

  public static void main(String[] args) {
    Re_p270_Closest_Binary_Search_Tree_Value solver = new Re_p270_Closest_Binary_Search_Tree_Value();
//    TreeNode root = TreeHelper.buildTree(new Integer[]{4, 2, 5, 1, 3});
//    double target = 3.714286;

    TreeNode root = TreeHelper.buildTree(new Integer[]{8, 7, 50, null, null, 9, null});
    double target = 9.1;

    System.out.println(solver.findNearestNode(root, target));
  }


  private int nearestNumber = Integer.MAX_VALUE;
  private double nearestGap = Double.MAX_VALUE;

  public int findNearestNode(TreeNode root, double target) {
    // 차가 작은 방향으로 이동합니다. "왼 < 오 = -1"
    calculateNearest(root, target);

    return nearestNumber;
  }

  public Integer calculateNearest(TreeNode root, double target) {
    if (root == null) {
      return null;
    }
    if (Double.compare(calculateAbsGap(root, target), nearestGap) < 0) {
      nearestGap = calculateAbsGap(root, target);
      nearestNumber = root.val;
    }

    double leftGap = calculateAbsGap(root.left, target);
    double rightGap = calculateAbsGap(root.right, target);
    int compareLeftRight = Double.compare(leftGap, rightGap);
    if (compareLeftRight <= 0) {
      return calculateNearest(root.left, target);
    }

    return calculateNearest(root.right, target);
  }

  public double calculateAbsGap(TreeNode node, double target) {
    if (node == null) {
      return Double.MAX_VALUE;
    }

    double gap = (double) node.val - target;
    return Math.abs(gap);
  }

}
