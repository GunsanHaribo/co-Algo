package algorithm.P5_BinaryTree.P5_BounsProblem.P0_BinaryTree.P101_Symmetric_Tree;

import algorithm.P5_BinaryTree.P1_Tree_Maker.TreeNode;

import static algorithm.P5_BinaryTree.P1_Tree_Maker.TreeHelper.buildTree;

public class Symmetric_Tree {
    public static void main(String[] args) {
        // Level 3

        TreeNode treeNode = buildTree(new Integer[]{1,2,2,3,4,4,3});
//
//        TreeNode treeNode = buildTree(
//                new Integer[]{5, 2, 2, 4, null, null, 1, null, 1, null, 4, 2, null, 2, null}
//        );
//        printLevelOrder(treeNode);
//        System.out.println();

        System.out.println(isSymmetric(treeNode));
    }

    public static boolean isSymmetric(TreeNode root) {
        String left = leftFirstDfs(root.left);
        String right = rightFirstDfs(root.right);
        if (left.length() != right.length()) {
            return false;
        }

        return left.equals(right);
    }

    public static String leftFirstDfs(TreeNode node) {
        if (node == null) {
            return "*";
        }
        if (node.left == null && node.right == null) {
            return node.val + "";
        }

        return node.val + leftFirstDfs(node.left) + leftFirstDfs(node.right);
    }

    public static String rightFirstDfs(TreeNode node) {
        if (node == null) {
            return "*";
        }
        if (node.left == null && node.right == null) {
            return node.val + "";
        }

        return node.val + rightFirstDfs(node.right) + rightFirstDfs(node.left);
    }
}
