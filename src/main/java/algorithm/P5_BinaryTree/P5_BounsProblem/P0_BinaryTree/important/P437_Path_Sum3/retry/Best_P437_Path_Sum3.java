package algorithm.P5_BinaryTree.P5_BounsProblem.P0_BinaryTree.important.P437_Path_Sum3.retry;

import algorithm.P5_BinaryTree.P1_Tree_Maker.TreeHelper;
import algorithm.P5_BinaryTree.P1_Tree_Maker.TreeNode;
import java.util.LinkedList;

public class Best_P437_Path_Sum3 {

  public static void main(String[] args) {
    Best_P437_Path_Sum3 solver = new Best_P437_Path_Sum3();
//    TreeNode root = TreeHelper.buildTree(new Integer[]{
//        10, 5, -3, 3, 2, null, 11, 3, -2, null, 1
//    });
//    int targetSum = 8;
    TreeNode root = TreeHelper.buildTree(new Integer[]{
        1_000_000_000, 1_000_000_000, null, 294_967_296, null, 1_000_000_000, null, 1_000_000_000,
        null,
        1_000_000_000
    });
    int targetSum = 0; // 0 그런데 2가 나옴
  }

  public int pathSum(TreeNode root, int targetSum) {
    return 0;
  }

}
