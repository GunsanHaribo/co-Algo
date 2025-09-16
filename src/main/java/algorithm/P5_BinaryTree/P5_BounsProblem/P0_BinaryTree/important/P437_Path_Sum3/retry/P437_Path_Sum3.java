package algorithm.P5_BinaryTree.P5_BounsProblem.P0_BinaryTree.important.P437_Path_Sum3.retry;

import algorithm.P5_BinaryTree.P1_Tree_Maker.TreeHelper;
import algorithm.P5_BinaryTree.P1_Tree_Maker.TreeNode;

public class P437_Path_Sum3 {

  public static void main(String[] args) {
    P437_Path_Sum3 solver = new P437_Path_Sum3();
//    TreeNode root = TreeHelper.buildTree(new Integer[]{
//        10, 5, -3, 3, 2, null, 11, 3, -2, null, 1
//    });
//    int targetSum = 8;
//    TreeNode root = TreeHelper.buildTree(new Integer[]{
//        5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1
//    });
//    int targetSum = 22;

//    TreeNode root = TreeHelper.buildTree(new Integer[]{
//        -2, null, -3
//    });
//    int targetSum = -3;

//    TreeNode root = TreeHelper.buildTree(new Integer[]{
//        1, -2, -3
//    });
//    int targetSum = -2;
//    TreeNode root = TreeHelper.buildTree(new Integer[]{
//        0, 1, 1
//    });
//    int targetSum = 1;
//    TreeNode root = TreeHelper.buildTree(new Integer[]{
//        10, 5, -3, 3, 2, null, 11, 3, -2, null, 1
//    });
//    int targetSum = 8;
//    TreeNode root = TreeHelper.buildTree(new Integer[]{
//        1, 2
//    });
//    int targetSum = 2;
    TreeNode root = TreeHelper.buildTree(new Integer[]{
        0, 1, 1
    });
    int targetSum = 0;

//    TreeNode root = TreeHelper.buildTree(new Integer[]{
//        1, -2, -3, 1, 3, -2, null, -1
//    });
//    int targetSum = 0;

    System.out.println(solver.pathSum(root, targetSum)); // 3기대
  }

  public int pathSum(TreeNode root, int targetSum) {
    return 0;
  }

}
