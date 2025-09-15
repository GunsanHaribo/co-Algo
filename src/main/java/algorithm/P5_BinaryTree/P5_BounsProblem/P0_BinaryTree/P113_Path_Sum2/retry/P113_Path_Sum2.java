package algorithm.P5_BinaryTree.P5_BounsProblem.P0_BinaryTree.P113_Path_Sum2.retry;

import algorithm.P5_BinaryTree.P1_Tree_Maker.TreeHelper;
import algorithm.P5_BinaryTree.P1_Tree_Maker.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class P113_Path_Sum2 {

  public static void main(String[] args) {
    P113_Path_Sum2 solver = new P113_Path_Sum2();
//    TreeNode root = TreeHelper.buildTree(
//        new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1}
//    );
//    int targetSum = 22;
    TreeNode root = TreeHelper.buildTree(
        new Integer[]{-2, null, -3}
    );
    int targetSum = -5;

    System.out.println(solver.pathSum(root, targetSum));
  }

  public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
    List<List<Integer>> result = new ArrayList<>();
    dfs(root, targetSum, new ArrayList<>(), result);
    return result;
  }

  public void dfs(
      TreeNode root,
      int targetSum,
      List<Integer> pathValues,
      List<List<Integer>> result
  ) {
    if (root == null) {
      return;
    }

    ArrayList<Integer> newPathValues = new ArrayList<>(pathValues);
    newPathValues.add(root.val);
    if (root.right == null && root.left == null) {
      if (sum(newPathValues) == targetSum) {
        result.add(newPathValues);
        return;
      }
    }

    dfs(root.left, targetSum, newPathValues, result);
    dfs(root.right, targetSum, newPathValues, result);
  }

  public int sum(List<Integer> nodeValues) {
    int sum = 0;
    for (int value : nodeValues) {
      sum += value;
    }
    return sum;
  }

}
