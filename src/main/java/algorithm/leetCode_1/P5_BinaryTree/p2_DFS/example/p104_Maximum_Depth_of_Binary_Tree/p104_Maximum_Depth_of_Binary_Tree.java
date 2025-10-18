package algorithm.leetCode_1.P5_BinaryTree.p2_DFS.example.p104_Maximum_Depth_of_Binary_Tree;

import algorithm.leetCode_1.P5_BinaryTree.p1_Tree_Maker.TreeNode;

public class p104_Maximum_Depth_of_Binary_Tree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode left = new TreeNode(9);
        TreeNode right = new TreeNode(20, new TreeNode(15), new TreeNode(7));

        System.out.println(maxDepth(root));
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return Math.max(maxDepth(root.left) + 1, maxDepth(root.right) + 1);
    }

}


