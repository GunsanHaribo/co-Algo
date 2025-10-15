package algorithm.leetCode_1회독중.P5_BinaryTree.p2_DFS.pratice.p1026_Maximum_Difference_Between_Node_and_Ancestor;

import algorithm.leetCode_1회독중.P5_BinaryTree.p1_Tree_Maker.TreeNode;
import algorithm.leetCode_1회독중.P5_BinaryTree.p1_Tree_Maker.TreeHelper;

public class p1026_Maximum_Difference_Between_Node_and_Ancestor {

    public static void main(String[] args) {
//        TreeNode root = buildTree(new Integer[]{8, 3, 10, 1, 6, null, 14, null, null, 4, 7, 13});
        TreeNode root = TreeHelper.buildTree(new Integer[]{1,null,2,null,0,3});

        System.out.println(maxAncestorDiff(root));
    }

    public static int maxAncestorDiff(TreeNode root) {
        if (root == null) {
            return -1;
        }
        if (root.right == null && root.left == null) {
            return -1;
        }

        int leftMinValue = minDfs(root.left);
        int leftMaxValue = maxDfs(root.left);
        int rightMinValue = minDfs(root.right);
        int rightMaxValue = maxDfs(root.right);

        int min = Math.min(leftMinValue, rightMinValue);
        int max = Math.max(leftMaxValue, rightMaxValue);

        int maxAbs = Math.max(Math.abs(root.val - min), Math.abs(root.val - max));

        return Math.max(maxAbs, Math.max(maxAncestorDiff(root.left), maxAncestorDiff(root.right)));
    }

    private static int maxDfs(TreeNode node) {
        if (node == null) {
            return Integer.MIN_VALUE;
        }

        return Math.max(node.val, Math.max(maxDfs(node.left), maxDfs(node.right)));
    }

    private static int minDfs(TreeNode node) {
        if (node == null) {
            return Integer.MAX_VALUE;
        }

        return Math.min(node.val, Math.min(minDfs(node.left), minDfs(node.right)));
    }

}
