package algorithm.leetCode_1회독중.P5_BinaryTree.p2_DFS.example.p104_Maximum_Depth_of_Binary_Tree.retry;

import algorithm.leetCode_1회독중.P5_BinaryTree.p1_Tree_Maker.TreeHelper;
import algorithm.leetCode_1회독중.P5_BinaryTree.p1_Tree_Maker.TreeNode;

/**
 * 흠.. 이걸 다시 풀어야되나, 고민이 되는구만 한번 트래킹용으로 풀어볼까.. 어떻게 작동할지 한번 다 적어보고, 그에 맞게 동작하는지 확인해보는 느낌으로
 */
public class p104_Maximum_Depth_of_Binary_Tree {

  public static void main(String[] args) {
    TreeNode root = TreeHelper.buildTree(new Integer[]{3, 9, 20, null, null, 15, 7});
    p104_Maximum_Depth_of_Binary_Tree solver = new p104_Maximum_Depth_of_Binary_Tree();
    System.out.println(solver.maxDepth(root));
  }

  public int maxDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }

    int left = maxDepth(root.left);
    int right = maxDepth(root.right);

    return Math.max(left, right) + 1;
  }

}
