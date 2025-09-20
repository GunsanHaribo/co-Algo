package algorithm.P5_BinaryTree.P5_BounsProblem.P1_BFS.P102_Binary_Tree_Level_Order_Traversal.retry;

import algorithm.P5_BinaryTree.P1_Tree_Maker.TreeHelper;
import algorithm.P5_BinaryTree.P1_Tree_Maker.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P102_Binary_Tree_Level_Order_Traversal {

  public static void main(String[] args) {
    P102_Binary_Tree_Level_Order_Traversal solver = new P102_Binary_Tree_Level_Order_Traversal();
//    TreeNode root = TreeHelper.buildTree(new Integer[]{
//        3, 9, 20, null, null, 15, 7
//    });
    TreeNode root = TreeHelper.buildTree(new Integer[]{
        1
    });

    System.out.println(solver.levelOrder(root));
  }

  public List<List<Integer>> levelOrder(TreeNode root) {
    if (root == null) {
      return List.of();
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);

    List<List<Integer>> answer = new ArrayList<>();
    while (!queue.isEmpty()) {
      int size = queue.size();
      List<Integer> temp = new ArrayList<>();
      for (int i = 0; i < size; i++) {
        TreeNode polled = queue.poll();
        temp.add(polled.val);
        if (polled.left != null) {
          queue.add(polled.left);
        }
        if (polled.right != null) {
          queue.add(polled.right);
        }
      }
      answer.add(temp);
    }

    return answer;
  }

}
