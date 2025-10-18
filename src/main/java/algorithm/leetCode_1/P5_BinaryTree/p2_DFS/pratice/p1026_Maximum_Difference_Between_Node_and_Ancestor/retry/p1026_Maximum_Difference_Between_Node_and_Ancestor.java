package algorithm.leetCode_1.P5_BinaryTree.p2_DFS.pratice.p1026_Maximum_Difference_Between_Node_and_Ancestor.retry;

import algorithm.leetCode_1.P5_BinaryTree.p1_Tree_Maker.TreeHelper;
import algorithm.leetCode_1.P5_BinaryTree.p1_Tree_Maker.TreeNode;
import java.util.Arrays;
import java.util.List;

public class p1026_Maximum_Difference_Between_Node_and_Ancestor {

  public static void main(String[] args) {
    p1026_Maximum_Difference_Between_Node_and_Ancestor solver = new p1026_Maximum_Difference_Between_Node_and_Ancestor();
//    TreeNode root = TreeHelper.buildTree(
//        new Integer[]{8, 3, 10, 1, 6, null, 14, null, null, 4, 7, 13});
//    TreeNode root = TreeHelper.buildTree(
//        new Integer[]{1,null,2,null,0,3});
//    TreeNode root = TreeHelper.buildTree(
//        new Integer[]{2, null, 0, 1});
//    TreeNode root = TreeHelper.buildTree(
//        new Integer[]{
//            9, null, 1, 2, 7, 4, null, 8, null, 0, 6, null, null, 3, null, null, null, null, 5});
    TreeNode root = TreeHelper.buildTree(
        new Integer[]{
            2, 5, 0, null, null, 4, null, null, 6, 1, null, 3});
    System.out.println(solver.maxAncestorDiff(root));
  }

  public int maxAncestorDiff(TreeNode root) {
    if (root == null) {
      return -1;
    }

    Integer minRight = findMin(root.right); // 0이 나와야되는대, 여기도 0이 나와야되는데
    Integer minLeft = findMin(root.left);
    Integer maxRight = findMax(root.right);
    Integer maxLeft = findMax(root.left); // 여기서 한번 더 max/min 뽑아도 될 것 같은데

    int currentMax = Integer.MIN_VALUE; // -1일떄는 연산 못하게 해야됨? 그냥 해도 될 것 같은데 에가 타고타고 올라가는 값은 아니여서
    List<Integer> subValues = Arrays.asList(minRight, minLeft, maxRight, maxLeft);
    for (Integer value : subValues) {
      if (value == null) {
        continue;
      }
      int abs = Math.abs(root.val - value);
      if (currentMax < abs) {
        currentMax = abs;
      }
    }

    return Math.max(
        currentMax,
        Math.max(maxAncestorDiff(root.right), maxAncestorDiff(root.left))
    );
  }

  public Integer findMin(TreeNode root) {
    if (root == null) {
      return null; // 여기서 0을 못누는것 같은데
    }
    if (root.left == null && root.right == null) {
      return root.val;
    }
    if (root.left == null) {
      return Math.min(root.val, findMin(root.right));
    }
    if (root.right == null) {
      return Math.min(root.val, findMin(root.left)); // 하아? 여기도 비교해서 ㅈ둬야되네
    }

    return Math.min(root.val, Math.min(findMin(root.left), findMin(root.right)));
  }

  public Integer findMax(TreeNode root) {
    if (root == null) {
      return null;
    }
    if (root.left == null && root.right == null) {
      return root.val;
    }
    if (root.left == null) {
      return Math.max(root.val, findMax(root.right));
    }
    if (root.right == null) {
      return Math.max(root.val, findMax(root.left));
    }

    return Math.max(root.val, Math.max(findMax(root.left), findMax(root.right)));
  }

}
