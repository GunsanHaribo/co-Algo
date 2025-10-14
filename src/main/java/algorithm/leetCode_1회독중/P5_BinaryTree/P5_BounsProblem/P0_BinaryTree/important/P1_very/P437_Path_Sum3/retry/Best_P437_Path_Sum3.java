package algorithm.leetCode_1회독중.P5_BinaryTree.P5_BounsProblem.P0_BinaryTree.important.P1_very.P437_Path_Sum3.retry;

import algorithm.leetCode_1회독중.P5_BinaryTree.P1_Tree_Maker.TreeHelper;
import algorithm.leetCode_1회독중.P5_BinaryTree.P1_Tree_Maker.TreeNode;

public class Best_P437_Path_Sum3 {

  public static void main(String[] args) {
    Best_P437_Path_Sum3 solver = new Best_P437_Path_Sum3();
    TreeNode root = TreeHelper.buildTree(new Integer[]{
        10, 5, -3, 3, 2, null, 11, 3, -2, null, 1
    });
    int targetSum = 8;
//    TreeNode root = TreeHelper.buildTree(new Integer[]{
//        1_000_000_000, 1_000_000_000, null, 294_967_296, null, 1_000_000_000, null, 1_000_000_000,
//        null,
//        1_000_000_000
//    });
//    int targetSum = 0; // 0 그런데 2가 나옴

    System.out.println(solver.pathSum(root, targetSum));
  }

  public int pathSum(TreeNode root, int targetSum) {
    if (root == null) return 0;

    // Count paths starting at this node
    int count = countPaths(root, targetSum);

    // Plus paths in the left and right subtrees
    count += pathSum(root.left, targetSum);
    count += pathSum(root.right, targetSum);

    return count;
  }

  // 아 이걸 노드를 내려가면서 계속 반복을 하네
  // 밑으로 내려가면서 + 숫자를 뺴주면서 있는지 없는지
  private int countPaths(TreeNode node, long targetSum) {
    if (node == null) return 0;

    int count = 0;
    if (node.val == targetSum) count++;

    count += countPaths(node.left, targetSum - node.val);
    count += countPaths(node.right, targetSum - node.val);

    return count;
  }

}
