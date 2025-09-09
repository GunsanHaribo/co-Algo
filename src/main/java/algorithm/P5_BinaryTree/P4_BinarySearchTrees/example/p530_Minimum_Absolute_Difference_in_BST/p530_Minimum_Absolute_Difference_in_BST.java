package algorithm.P5_BinaryTree.P4_BinarySearchTrees.example.p530_Minimum_Absolute_Difference_in_BST;

import algorithm.P5_BinaryTree.P1_Tree_Maker.TreeHelper;
import algorithm.P5_BinaryTree.P1_Tree_Maker.TreeNode;

public class p530_Minimum_Absolute_Difference_in_BST {

  public static void main(String[] args) {
    p530_Minimum_Absolute_Difference_in_BST solver = new p530_Minimum_Absolute_Difference_in_BST();
//    TreeNode root = TreeHelper.buildTree(new Integer[]{4, 2, 6, 1, 3});
//    TreeNode root = TreeHelper.buildTree(new Integer[]{1, 0, 48, null, null, 12, 49});
//    TreeNode root = TreeHelper.buildTree(new Integer[]{1, null, 3, 2});
    TreeNode root = TreeHelper.buildTree(new Integer[]{236, 104, 701, null, 227, null, 9112});

    System.out.println(solver.getMinimumDifference(root));
  }

  public int getMinimumDifference(TreeNode root) {
    if (root == null) {
      return Integer.MAX_VALUE;
    }

    int a = root.val - findRightest(root.left);
    int b = findLeftest(root.right) - (root.val); // null일떄 흐음.. 이걸 어떻게하지?
    int currentMin = Math.min(
        a, // 여기서 나오는것 같은데
        b
    );
    int childMinDiff = Math.min(getMinimumDifference(root.left), getMinimumDifference(root.right));

    return Math.min(currentMin, childMinDiff);
  }

  public int findRightest(TreeNode node) {
    // null 일떄 안넣어주면 안되나?
    if (node.right == null && node.left != null) {
      return node.val; // 부모에서 왼쪽이 null이면 부모반환
    }
    if (node.right == null && node.left == null) {
      return node.val;
    }

    return findRightest(node.right);
  }

  public int findLeftest(TreeNode node) {
    if (node.left == null && node.right != null) {
      return node.val; // 부모에서 왼쪽이 null이면 부모반환
    }
    if (node.right == null && node.left == null) {
      return node.val; // 끝까지 들어가서 뭐가 없을때는 자기자신 반환
    }

    return findLeftest(node.left);
  }

  /////////////////////////
  /////////////////////////
  public int getMinimumDifference_failed(TreeNode root) {
    if (root == null) {
      return Integer.MAX_VALUE; // 이것도 살짝.. 문제가 될수도
    }
    if (root.left == null && root.right == null) {
      return Integer.MAX_VALUE;
    }

    int currentMin = Integer.MAX_VALUE;
    if (root.left == null && root.right != null) {
      currentMin = root.right.val - root.val;
    }
    if (root.left != null && root.right == null) {
      currentMin = root.val - root.left.val;
    }
    if (root.left != null && root.right != null) {
      currentMin = Math.min(root.right.val - root.val, root.val - root.left.val);
    }

    return Math.min(
        currentMin,
        Math.min(getMinimumDifference_failed(root.left), getMinimumDifference_failed(root.right))
    );
  }

}
