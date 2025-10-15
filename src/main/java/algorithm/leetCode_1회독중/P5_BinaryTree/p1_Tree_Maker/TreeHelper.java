package algorithm.leetCode_1회독중.P5_BinaryTree.p1_Tree_Maker;

import java.util.LinkedList;
import java.util.Queue;

public final class TreeHelper {

  public static void printLevelOrder(TreeNode root) {
    if (root == null) {
      return;
    }

    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);

    while (!queue.isEmpty()) {
      // 리스트에 한번에 넣어보자

      // 큐사이즈 만큼 넣고
      for (int i = 0; i < queue.size(); i++) {
        TreeNode current = queue.poll();
        if (current == null) {
          continue;
        }
        queue.offer(current.left);
        queue.offer(current.right);
        System.out.print(current + " ");
      }
      System.out.println();
    }
  }

  // 트리 생성 함수
  // 레벨 순서대로 출력된느 것도 만들어야 한다.
  public static TreeNode buildTree(Integer[] values) {
      if (values == null || values.length == 0) {
          return null;
      }

    TreeNode root = new TreeNode(values[0]);
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);

    int index = 1;
    while (index < values.length) {
      TreeNode current = queue.poll();

      if (index < values.length && values[index] != null) {
        current.left = new TreeNode(values[index]);
        queue.offer(current.left);
      }
      index++;

      if (index < values.length && values[index] != null) {
        current.right = new TreeNode(values[index]);
        queue.offer(current.right);
      }
      index++;
    }

    return root;
  }

}
