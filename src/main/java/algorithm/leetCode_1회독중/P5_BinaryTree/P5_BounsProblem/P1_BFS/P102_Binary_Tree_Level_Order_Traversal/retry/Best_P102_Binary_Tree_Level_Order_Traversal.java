package algorithm.leetCode_1회독중.P5_BinaryTree.P5_BounsProblem.P1_BFS.P102_Binary_Tree_Level_Order_Traversal.retry;

import algorithm.leetCode_1회독중.P5_BinaryTree.P1_Tree_Maker.TreeHelper;
import algorithm.leetCode_1회독중.P5_BinaryTree.P1_Tree_Maker.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class Best_P102_Binary_Tree_Level_Order_Traversal {

  public static void main(String[] args) {
    Best_P102_Binary_Tree_Level_Order_Traversal solver = new Best_P102_Binary_Tree_Level_Order_Traversal();
//    TreeNode root = TreeHelper.buildTree(new Integer[]{
//        3, 9, 20, null, null, 15, 7
//    });
    TreeNode root = TreeHelper.buildTree(new Integer[]{
        1
    });

    System.out.println(solver.levelOrder(root));
  }

  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> al = new ArrayList<>();
    pre(root, 0, al);
    return al;
  }

  public static void pre(TreeNode root, int l, List<List<Integer>> al) {
    if (root == null) {
      return;
    }
    if (al.size() == l) {
      List<Integer> li = new ArrayList<>();
      li.add(root.val);
      al.add(li);
    } else {
      al.get(l).add(root.val);
    }
    pre(root.left, l + 1, al);
    pre(root.right, l + 1, al);
  }

}
