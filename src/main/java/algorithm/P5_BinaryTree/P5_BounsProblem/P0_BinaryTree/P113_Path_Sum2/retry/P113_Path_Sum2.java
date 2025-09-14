package algorithm.P5_BinaryTree.P5_BounsProblem.P0_BinaryTree.P113_Path_Sum2.retry;

import algorithm.P5_BinaryTree.P1_Tree_Maker.TreeHelper;
import algorithm.P5_BinaryTree.P1_Tree_Maker.TreeNode;
import java.util.List;

public class P113_Path_Sum2 {

  public static void main(String[] args) {
    P113_Path_Sum2 solver = new P113_Path_Sum2();
    TreeNode root = TreeHelper.buildTree(
        new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1}
    );
    int targetSum = 22;

    System.out.println(solver.pathSum(root, targetSum));
  }

  public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
    return List.of();
  }

}
