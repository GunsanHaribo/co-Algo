package algorithm.leetCode_1회독중.P5_BinaryTree.p2_DFS.example.p1448_Count_Good_Nodes_in_Binary_Tree.retry;

import algorithm.leetCode_1회독중.P5_BinaryTree.p1_Tree_Maker.TreeHelper;
import algorithm.leetCode_1회독중.P5_BinaryTree.p1_Tree_Maker.TreeNode;

public class p1448_Count_Good_Nodes_in_Binary_Tree {

  public static void main(String[] args) {
//    TreeNode root = TreeHelper.buildTree(new Integer[]{3, 1, 4, 3, null, 1, 5});
    TreeNode root = TreeHelper.buildTree(new Integer[]{3,3,null,4,2});
    p1448_Count_Good_Nodes_in_Binary_Tree solver = new p1448_Count_Good_Nodes_in_Binary_Tree();
    System.out.println(solver.goodNodes(root));
  }

  // 전위, 후위, 중위를 활용했다는걸 고려해야함?
  // 거의 전위 쓸것 같은데, 중요할 수도?
  public int goodNodes(TreeNode root) {
    return dfs(root, root.val);
  }

  private int dfs(TreeNode node, int maxAncestor) {
    if (node == null) {
      return 0;
    }
    int add = 0;
    if (node.val >= maxAncestor) {
      add = 1;
    }
    maxAncestor = Math.max(node.val, maxAncestor);
    int left = dfs(node.left, maxAncestor);
    int right = dfs(node.right, maxAncestor);

    return left + right + add;
  }

}
