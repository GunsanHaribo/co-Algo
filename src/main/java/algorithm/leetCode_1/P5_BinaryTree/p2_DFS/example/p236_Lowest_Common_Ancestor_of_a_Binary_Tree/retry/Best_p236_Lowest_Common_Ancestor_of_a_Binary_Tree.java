package algorithm.leetCode_1.P5_BinaryTree.p2_DFS.example.p236_Lowest_Common_Ancestor_of_a_Binary_Tree.retry;

import algorithm.leetCode_1.P5_BinaryTree.p1_Tree_Maker.TreeHelper;
import algorithm.leetCode_1.P5_BinaryTree.p1_Tree_Maker.TreeNode;

public class Best_p236_Lowest_Common_Ancestor_of_a_Binary_Tree {

  public static void main(String[] args) {
    Best_p236_Lowest_Common_Ancestor_of_a_Binary_Tree solver = new Best_p236_Lowest_Common_Ancestor_of_a_Binary_Tree();
    TreeNode root = TreeHelper.buildTree(new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4});
    TreeNode p = new TreeNode(5);
    TreeNode q = new TreeNode(1);
//    TreeNode root = TreeHelper.buildTree(new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4});
//    TreeNode p = new TreeNode(5);
//    TreeNode q = new TreeNode(4);
//
//    TreeNode root = TreeHelper.buildTree(new Integer[]{-1, 0, 3, -2, 4, null, null, 8});
//    TreeNode p = new TreeNode(8);
//    TreeNode q = new TreeNode(4);

    System.out.println(solver.lowestCommonAncestor(root, p, q));
  }

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null) { // 이거 생각을 못해서 나온 문제 같은데,
      return null;  // 해당하는게 없으면 null로 처리한다는 생각을
    }
    // 루트가 같으면 루트 반환
    if (root.equals(p) || root.equals(q)) {
      return root;
    }

    TreeNode left = lowestCommonAncestor(root.left, p, q);
    TreeNode right = lowestCommonAncestor(root.right, p, q);

    if (left != null && right != null) {
      return root;
    }

    if (left != null) { // 거의 루트이 입장에서 오른쪽이 null이면 정답이 없어서 왼쪽 노드에 답이 있는거임
      return left;
    }

    return right;
  }

}
