package algorithm.P5_BinaryTree.P5_BounsProblem.P0_BinaryTree.important.P437_Path_Sum3;

import algorithm.P5_BinaryTree.P1_Tree_Maker.TreeHelper;
import algorithm.P5_BinaryTree.P1_Tree_Maker.TreeNode;
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
//    TreeNode root = TreeHelper.buildTree(new Integer[]{
//        10, 5, -3, 3, 2, null, 11, 3, -2, null, 1
//    });
//    int targetSum = 8;
//    TreeNode root = TreeHelper.buildTree(new Integer[]{
//        1, 2
//    });
//    int targetSum = 2;
    TreeNode root = TreeHelper.buildTree(new Integer[]{
        0,1,1
    });
    int targetSum = 0;

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
    if(currentSum == targetSum){
      totalCount += 1;
    }

    Queue<Integer> newQueue = new LinkedList<>(queue);
    newQueue.add(root.val);
    int nextSum = currentSum + root.val;
    if (targetSum == root.val) {
      if (nextSum == targetSum) {
        totalCount += 1;
      }
      while (!newQueue.isEmpty()) {
        Integer poll = newQueue.poll();
        nextSum -= poll;
        if (nextSum == targetSum && targetSum != 0) {
          totalCount += 1; // 2 + 2 가 나와야 하지않나?, 왜여기서 +1 안되지, 여기서 틀
        }
      }
    }


    if (nextSum == targetSum && targetSum != 0) {
      totalCount += 1;
    }
    if (targetSum > 0 && nextSum > targetSum) {
      while (nextSum > targetSum) {
        Integer poll = newQueue.poll();
        nextSum -= poll;
      }
    }
    if (targetSum < 0 && nextSum < targetSum) {
      while (nextSum < targetSum) {
        Integer poll = newQueue.poll();
        nextSum -= poll;
      }
    }

    // 뺴줬을때 같으면 어떻게 하게, 근데 이게 말이되나, 이전것들은 다 작았는데, 생각해보면 가능할 것 같기도하고, 가능한 이야기인데


    dfs(root.left, targetSum, nextSum, newQueue);
    dfs(root.right, targetSum, nextSum, newQueue);
  }

}
