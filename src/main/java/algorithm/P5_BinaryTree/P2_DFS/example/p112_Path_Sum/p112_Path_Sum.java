package algorithm.P5_BinaryTree.P2_DFS.example.p112_Path_Sum;

import algorithm.P5_BinaryTree.P2_DFS.example.TreeNode;

public class p112_Path_Sum {

    public static void main(String[] args) {
        TreeNode leftLeaf = new TreeNode(7);
        TreeNode rightLeaf = new TreeNode(2);
        TreeNode middle1 = new TreeNode(11, leftLeaf, rightLeaf);
        TreeNode middle2 = new TreeNode(4, middle1, null);
        TreeNode root = new TreeNode(5, middle2, null);

        System.out.println(hasPathSum(root, 22));
    }

    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }

        int newTargetSum = targetSum - root.val;
        return hasPathSum(root.left, newTargetSum) || hasPathSum(root.right, newTargetSum);
    }

}
