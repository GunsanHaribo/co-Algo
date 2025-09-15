package algorithm.P5_BinaryTree.P5_BounsProblem.important.P113_Path_Sum2.retry;

import algorithm.P5_BinaryTree.P1_Tree_Maker.TreeHelper;
import algorithm.P5_BinaryTree.P1_Tree_Maker.TreeNode;
import java.util.List;

public class BackTracking_P113_Path_Sum2 {

  public static void main(String[] args) {
    BackTracking_P113_Path_Sum2 solver = new BackTracking_P113_Path_Sum2();
    TreeNode root = TreeHelper.buildTree(
        new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1}
    );
    int targetSum = 22;
//    TreeNode root = TreeHelper.buildTree(
//        new Integer[]{-2, null, -3}
//    );
//    int targetSum = -5;

    System.out.println(solver.pathSum(root, targetSum));
  }

  public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
    return List.of();
  }

}
