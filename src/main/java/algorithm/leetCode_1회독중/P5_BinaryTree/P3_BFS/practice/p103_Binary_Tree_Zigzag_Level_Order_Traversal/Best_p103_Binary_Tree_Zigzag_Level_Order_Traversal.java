package algorithm.leetCode_1회독중.P5_BinaryTree.P3_BFS.practice.p103_Binary_Tree_Zigzag_Level_Order_Traversal;

import algorithm.leetCode_1회독중.P5_BinaryTree.P1_Tree_Maker.TreeHelper;
import algorithm.leetCode_1회독중.P5_BinaryTree.P1_Tree_Maker.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Best_p103_Binary_Tree_Zigzag_Level_Order_Traversal {

  public static void main(String[] args) {
    Best_p103_Binary_Tree_Zigzag_Level_Order_Traversal solver = new Best_p103_Binary_Tree_Zigzag_Level_Order_Traversal();
    TreeNode root = TreeHelper.buildTree(new Integer[]{3, 9, 20, null, null, 15, 7});
    System.out.println(solver.zigzagLevelOrder(root));
  }

  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    if (root == null) {
      return List.of();
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);

    boolean rightFirst = false;
    List<List<Integer>> results = new ArrayList<>();
    while (!queue.isEmpty()) {
      int rowSize = queue.size();
      LinkedList<Integer> rowNodeValues = new LinkedList<>();

      for (int i = 0; i < rowSize; i++) {
        TreeNode polled = queue.poll();

        if(rightFirst){
          rowNodeValues.addFirst(polled.val);
        }
        if(!rightFirst){
          rowNodeValues.addLast(polled.val);
        }


        if (polled.left != null) {
          queue.add(polled.left);
        }
        if (polled.right != null) {
          queue.add(polled.right);
        }
      }

      results.add(rowNodeValues);
      rightFirst = !rightFirst;
    }

    return results;
  }

}
