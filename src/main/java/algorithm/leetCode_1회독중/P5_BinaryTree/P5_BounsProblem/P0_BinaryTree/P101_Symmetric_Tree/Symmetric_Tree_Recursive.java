package algorithm.leetCode_1회독중.P5_BinaryTree.P5_BounsProblem.P0_BinaryTree.P101_Symmetric_Tree;

import algorithm.leetCode_1회독중.P5_BinaryTree.P1_Tree_Maker.TreeNode;

import static algorithm.leetCode_1회독중.P5_BinaryTree.P1_Tree_Maker.TreeHelper.buildTree;

public class Symmetric_Tree_Recursive {
    public static void main(String[] args) {
        TreeNode root = buildTree(new Integer[]{1,2,2,null,3,null,3});

        System.out.println(isSymmetric(root));
    }

    public static boolean isSymmetric(TreeNode root) {
        return isMirror(root.left, root.right);
    }

    private static boolean isMirror(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        boolean isSymmetricTreeNode = (left.val == right.val);

        return isSymmetricTreeNode && isMirror(left.left, right.right) && isMirror(left.right, right.left);
    }

}
