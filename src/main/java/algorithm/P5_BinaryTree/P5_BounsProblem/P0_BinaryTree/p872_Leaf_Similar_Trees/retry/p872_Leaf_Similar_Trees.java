package algorithm.P5_BinaryTree.P5_BounsProblem.P0_BinaryTree.p872_Leaf_Similar_Trees.retry;

import algorithm.P5_BinaryTree.P1_Tree_Maker.TreeHelper;
import algorithm.P5_BinaryTree.P1_Tree_Maker.TreeNode;

public class p872_Leaf_Similar_Trees {

  public static void main(String[] args) {
    p872_Leaf_Similar_Trees solver = new p872_Leaf_Similar_Trees();
    TreeNode root1 = TreeHelper.buildTree(new Integer[]{3, 5, 1, 6, 2, 9, 8, null, null, 7, 4});
    TreeNode root2 = TreeHelper.buildTree(
        new Integer[]{3, 5, 1, 6, 7, 4, 2, null, null, null, null, null, null, 9, 8}
    );

//    TreeNode root1 = TreeHelper.buildTree(new Integer[]{1, 2, 3});
//    TreeNode root2 = TreeHelper.buildTree(
//        new Integer[]{1, 3, 2}
//    );

    System.out.println(solver.leafSimilar(root1, root2));
  }

  public boolean leafSimilar(TreeNode root1, TreeNode root2) {
    if (root1 == null || root2 == null) {
      return true;
    }
    // 둘 다 리프 노드면 반환해야함
    if (
        (root1.left == null && root1.right == null)
            && (root2.left == null && root2.right == null)
    ) {
      return root1.val == root2.val;
    }
    // root2가 리프노드가 아닌경우
    if (
        (root1.left == null && root1.right == null)
            && (root2.left != null || root2.right != null)
    ) {
      return leafSimilar(root1, root2.left) && leafSimilar(root1, root2.right);
    }
    // root1이 리프노드가 아닌경우
    if (
        (root1.left != null || root1.right != null)
            && (root2.left == null && root2.right == null)
    ) {
      return leafSimilar(root1.left, root2) && leafSimilar(root1.right, root2);
    }

    // 둘 다 리프노드가 아닌경우, 이것도 아니면 어쩔 수없는거고
    return leafSimilar(root1.left, root2.left) && leafSimilar(root1.right, root2.right);
  }

}
