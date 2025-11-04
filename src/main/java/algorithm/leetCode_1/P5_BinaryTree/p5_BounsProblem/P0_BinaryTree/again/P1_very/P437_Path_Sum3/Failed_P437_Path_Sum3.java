package algorithm.leetCode_1.P5_BinaryTree.p5_BounsProblem.P0_BinaryTree.again.P1_very.P437_Path_Sum3;

import algorithm.leetCode_1.P5_BinaryTree.p1_Tree_Maker.TreeHelper;
import algorithm.leetCode_1.P5_BinaryTree.p1_Tree_Maker.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

public class Failed_P437_Path_Sum3 {

  public static void main(String[] args) {
    Failed_P437_Path_Sum3 solver = new Failed_P437_Path_Sum3();
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
    TreeNode root = TreeHelper.buildTree(new Integer[]{
        10, 5, -3, 3, 2, null, 11, 3, -2, null, 1
    });
    int targetSum = 8;
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

    System.out.println(solver.pathSum(root, targetSum)); // 3기대
  }

  private int totalCount = 0;

  public int pathSum(TreeNode root, int targetSum) {
    dfs(root, targetSum, 0, new LinkedList<>());
    return totalCount;
  }

  public void dfs(TreeNode root, int targetSum, int currentSum, Queue<Integer> queue) {
    if (root == null) {
      return;
    }

    // 큐에 투가하는로직
    Queue<Integer> newQueue = new LinkedList<>(queue);
    newQueue.add(root.val);
    int nextSum = currentSum + root.val;

    // targetSum과 같은 숫자가 들어왔을때 위에걸 날려주는로직 -> 이게 왜있는거지
    if (targetSum == root.val) {
      if (nextSum == targetSum) {
        totalCount += 1;
      }
      while (!newQueue.isEmpty()) {
        Integer poll = newQueue.poll();
        nextSum -= poll;
        if (nextSum == targetSum && targetSum != 0) {
          totalCount += 1;
        }
      }
    }

    //  nextSum이 targetSum일떄 count++, 밑에서는 안하고 들어오면 진행
    if (nextSum == targetSum && targetSum != 0) {
      totalCount += 1;
    }

    // targetSum이 양수면 내려가면서, 합이 특정수보다 크면 먼저들어간 수를 뺴줍니다.
    if (targetSum > 0 && nextSum > targetSum) {
      while (nextSum > targetSum) {
        Integer poll = newQueue.poll();
        nextSum -= poll;
      }
    }

    // targetSum이 음수면 내려가면서, 합이 특성 수보다 작으면 뺴줍니다.
    if (targetSum < 0 && nextSum < targetSum) {
      while (nextSum < targetSum) {
        Integer poll = newQueue.poll();
        nextSum -= poll;
      }
    }

    // 다음 진행
    dfs(root.left, targetSum, nextSum, newQueue);
    dfs(root.right, targetSum, nextSum, newQueue);
  }

}
