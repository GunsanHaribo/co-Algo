package algorithm.P5_BinaryTree.P5_BounsProblem.important.p872_Leaf_Similar_Trees.retry;

import algorithm.P5_BinaryTree.P1_Tree_Maker.TreeHelper;
import algorithm.P5_BinaryTree.P1_Tree_Maker.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class Best_p872_Leaf_Similar_Trees {

  public static void main(String[] args) {
    Best_p872_Leaf_Similar_Trees solver = new Best_p872_Leaf_Similar_Trees();
//    TreeNode root1 = TreeHelper.buildTree(new Integer[]{3, 5, 1, 6, 2, 9, 8, null, null, 7, 4});
//    TreeNode root2 = TreeHelper.buildTree(
//        new Integer[]{3, 5, 1, 6, 7, 4, 2, null, null, null, null, null, null, 9, 8}
//    );

    TreeNode root1 = TreeHelper.buildTree(new Integer[]{1, 2, 3});
    TreeNode root2 = TreeHelper.buildTree(
        new Integer[]{1, 3, 2}
    );

    System.out.println(solver.leafSimilar(root1, root2));
  }

  public boolean leafSimilar(TreeNode root1, TreeNode root2) {
    List<Integer> root1LeafNodeValues = new ArrayList<>();
    List<Integer> root2LeafNodeValues = new ArrayList<>();
    getLeafNodes(root1, root1LeafNodeValues);
    getLeafNodes(root2, root2LeafNodeValues);

    return root1LeafNodeValues.equals(root2LeafNodeValues);
  }

  public void getLeafNodes(TreeNode node, List<Integer> nodes) {
    if (node == null) {
      return;
    }

    if (node.left == null && node.right == null) {
      nodes.add(node.val);
      return;
    }
    getLeafNodes(node.left, nodes);
    getLeafNodes(node.right, nodes);
  }

}
