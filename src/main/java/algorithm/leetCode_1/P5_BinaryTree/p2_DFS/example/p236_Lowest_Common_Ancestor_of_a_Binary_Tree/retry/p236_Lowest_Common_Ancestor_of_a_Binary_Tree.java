package algorithm.leetCode_1.P5_BinaryTree.p2_DFS.example.p236_Lowest_Common_Ancestor_of_a_Binary_Tree.retry;

import algorithm.leetCode_1.P5_BinaryTree.p1_Tree_Maker.TreeHelper;
import algorithm.leetCode_1.P5_BinaryTree.p1_Tree_Maker.TreeNode;
import java.util.HashSet;
import java.util.Set;

public class p236_Lowest_Common_Ancestor_of_a_Binary_Tree {

  public static void main(String[] args) {
    p236_Lowest_Common_Ancestor_of_a_Binary_Tree solver = new p236_Lowest_Common_Ancestor_of_a_Binary_Tree();
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
    Set<Integer> targets = new HashSet<>();
    targets.add(p.val);
    targets.add(q.val);

    return findLowestCommonAncestor(root, targets);
  }

  // 함수 따로 빼는게 좋은 것 같긴하네
  public TreeNode findLowestCommonAncestor(TreeNode root, Set<Integer> targets) {
    if (root == null) {
      return new TreeNode(Integer.MIN_VALUE);
    }

    TreeNode left = findLowestCommonAncestor(root.left, targets);
    TreeNode right = findLowestCommonAncestor(root.right, targets);

    // 왼쪽에만 있을 경우
    // 만약에 부모가 true면 부모 반환
    if (targets.contains(left.val) && !targets.contains(right.val)) {
      if (targets.contains(root.val)) {
        return root;
      }
      return left;
    }
    // 오른쪽에만 있을 경우
    // 여기도 만약에 부모가 true면 부모 반환
    if (!targets.contains(left.val) && targets.contains(right.val)) {
      if (targets.contains(root.val)) {
        return root;
      }
      return right;
    }
    // 둘다 있을경우 set에 추가
    if (targets.contains(left.val) && targets.contains(right.val)) {
      targets.add(root.val);
      return root;
    }

    return root;
  }
}
