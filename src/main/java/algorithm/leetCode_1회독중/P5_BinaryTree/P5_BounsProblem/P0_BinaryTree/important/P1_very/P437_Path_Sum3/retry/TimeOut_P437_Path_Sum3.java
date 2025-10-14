package algorithm.leetCode_1회독중.P5_BinaryTree.P5_BounsProblem.P0_BinaryTree.important.P1_very.P437_Path_Sum3.retry;

import algorithm.leetCode_1회독중.P5_BinaryTree.P1_Tree_Maker.TreeHelper;
import algorithm.leetCode_1회독중.P5_BinaryTree.P1_Tree_Maker.TreeNode;
import java.util.Deque;
import java.util.LinkedList;

public class TimeOut_P437_Path_Sum3 {

  public static void main(String[] args) {
    TimeOut_P437_Path_Sum3 solver = new TimeOut_P437_Path_Sum3();
    TreeNode root = TreeHelper.buildTree(new Integer[]{
        10, 5, -3, 3, 2, null, 11, 3, -2, null, 1
    });
    int targetSum = 8;
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
//    int targetSum = 1; // 이게 4
//    TreeNode root = TreeHelper.buildTree(new Integer[]{
//        1, 2
//    });
//    int targetSum = 2;
//    TreeNode root = TreeHelper.buildTree(new Integer[]{
//        0, 1, 1
//    });
//    int targetSum = 0;

//    TreeNode root = TreeHelper.buildTree(new Integer[]{
//        1, -2, -3, 1, 3, -2, null, -1
//    });
//    int targetSum = 0;

    System.out.println(solver.pathSum(root, targetSum));
  }

  private int count = 0;

  public int pathSum(TreeNode root, int targetSum) {
    dfs(root, targetSum, 0, new LinkedList<>());
    return count;
  }

  public void dfs(TreeNode node, int targetSum, int nextSum, Deque<Integer> pathRecorder) {
    if (node == null) {
      return;
    }
    pathRecorder.add(node.val);
    int currentSum = nextSum + node.val;

    dfs(node.left, targetSum, currentSum, pathRecorder);
    updatePostOrderCount(targetSum, currentSum, pathRecorder); // 왼쪽 오른쪽 조상들에 대한 후위 순회는 한번만
    dfs(node.right, targetSum, currentSum, pathRecorder);

    pathRecorder.pollLast();  // 숫자가 하나 더 빠지긴 하네, 3 -> null일떄 right Read해서 뺴버리는듯
  }

  public void updatePostOrderCount(int targetSum, int currentSum, Deque<Integer> pathRecorder) {
    Deque<Integer> copiedPathRecorder = new LinkedList<>(pathRecorder);
    while (!copiedPathRecorder.isEmpty()) {
      if (currentSum == targetSum) {
        count++;
      }
//      updateCount(targetSum, copiedPathRecorder);
      Integer pollFirst = copiedPathRecorder.pollFirst();
      currentSum -= pollFirst;
    }
  }

}
