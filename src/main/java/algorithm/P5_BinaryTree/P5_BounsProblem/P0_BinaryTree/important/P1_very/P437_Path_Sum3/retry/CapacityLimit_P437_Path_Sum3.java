package algorithm.P5_BinaryTree.P5_BounsProblem.P0_BinaryTree.important.P1_very.P437_Path_Sum3.retry;

import algorithm.P5_BinaryTree.P1_Tree_Maker.TreeHelper;
import algorithm.P5_BinaryTree.P1_Tree_Maker.TreeNode;
import java.util.Deque;
import java.util.LinkedList;

public class CapacityLimit_P437_Path_Sum3 {

  public static void main(String[] args) {
    CapacityLimit_P437_Path_Sum3 solver = new CapacityLimit_P437_Path_Sum3();
//    TreeNode root = TreeHelper.buildTree(new Integer[]{
//        10, 5, -3, 3, 2, null, 11, 3, -2, null, 1
//    });
//    int targetSum = 8;
    TreeNode root = TreeHelper.buildTree(new Integer[]{
        1_000_000_000, 1_000_000_000, null, 294_967_296, null, 1_000_000_000, null, 1_000_000_000, null,
        1_000_000_000
    });
    int targetSum = 0; // 0 그런데 2가 나옴

    System.out.println(solver.pathSum(root, targetSum));
//    System.out.println(Integer.MAX_VALUE); //    2_147_483_647
  }

  private int count = 0;

  public int pathSum(TreeNode root, int targetSum) {
    dfs(root, targetSum, 0, new LinkedList<>());
    return count;
  }

  public void dfs(TreeNode node, int targetSum, long nextSum, Deque<Integer> pathRecorder) {
    if (node == null) {
      return;
    }
    pathRecorder.add(node.val);
    long currentSum = nextSum + node.val;

    dfs(node.left, targetSum, currentSum, pathRecorder);
    updatePostOrderCount(targetSum, currentSum, pathRecorder);
    dfs(node.right, targetSum, currentSum, pathRecorder);

    pathRecorder.pollLast();
  }

  public void updatePostOrderCount(int targetSum, long currentSum, Deque<Integer> pathRecorder) {
    Deque<Integer> copiedPathRecorder = new LinkedList<>(pathRecorder);
    while (!copiedPathRecorder.isEmpty()) {
      if (currentSum == targetSum) {
        count++;
      }
      Integer pollFirst = copiedPathRecorder.pollFirst();
      currentSum -= pollFirst;
    }
  }

}
