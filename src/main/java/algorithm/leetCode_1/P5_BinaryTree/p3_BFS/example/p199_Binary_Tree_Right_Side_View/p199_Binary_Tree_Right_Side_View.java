package algorithm.leetCode_1.P5_BinaryTree.p3_BFS.example.p199_Binary_Tree_Right_Side_View;

import algorithm.leetCode_1.P5_BinaryTree.p1_Tree_Maker.TreeHelper;
import algorithm.leetCode_1.P5_BinaryTree.p1_Tree_Maker.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class p199_Binary_Tree_Right_Side_View {

  public static void main(String[] args) {
    p199_Binary_Tree_Right_Side_View solver = new p199_Binary_Tree_Right_Side_View();
    TreeNode root = TreeHelper.buildTree(new Integer[]{1, 2, 3, null, 5, null, 4});
//    TreeNode root = TreeHelper.buildTree(new Integer[]{1, 2, 3, 4, null, null, null, 5});
//    TreeNode root = TreeHelper.buildTree(new Integer[]{});
    System.out.println(solver.rightSideView(root));
  }

  public List<Integer> rightSideView(TreeNode root) {
    if (root == null) {
      return List.of();
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);

    List<Integer> rightViewNodeValues = new ArrayList<>();
    while (!queue.isEmpty()) {
      int currentLength = queue.size();
      int prev = 0;

      for (int i = 0; i < currentLength; i++) {
        TreeNode polled = queue.poll();
        prev = polled.val;

        if (polled.left != null) {
          queue.add(polled.left);
        }
        if (polled.right != null) {
          queue.add(polled.right);
        }

      }
      rightViewNodeValues.add(prev);
    }

    return rightViewNodeValues;
  }

  public List<Integer> rightSideView0(TreeNode root) {
    if (root == null) {
      return List.of();
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);

    List<Integer> rightViewNodeValues = new ArrayList<>();
    while (!queue.isEmpty()) {
      List<TreeNode> temp = new ArrayList<>();
      while (!queue.isEmpty()) {
        temp.add(queue.poll());
      }

      for (TreeNode node : temp) {
        if (node.left != null) {
          queue.add(node.left);
        }
        if (node.right != null) {
          queue.add(node.right);
        }
      }

      rightViewNodeValues.add(temp.get(temp.size() - 1).val);
    }

    return rightViewNodeValues;
  }

}
