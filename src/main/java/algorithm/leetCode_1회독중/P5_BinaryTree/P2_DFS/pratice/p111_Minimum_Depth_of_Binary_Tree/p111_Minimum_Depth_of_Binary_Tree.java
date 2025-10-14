package algorithm.leetCode_1회독중.P5_BinaryTree.P2_DFS.pratice.p111_Minimum_Depth_of_Binary_Tree;

import algorithm.leetCode_1회독중.P5_BinaryTree.P1_Tree_Maker.TreeNode;

public class p111_Minimum_Depth_of_Binary_Tree {

    public static void main(String[] args) {
//        [2,null,3,null,4,null,5,null,6]

        TreeNode fifth = new TreeNode(6);
        TreeNode fourth = new TreeNode(5, fifth, null);
        TreeNode third = new TreeNode(4, fourth, null);
        TreeNode second = new TreeNode(3, third, null);
        TreeNode root = new TreeNode(2, second, null);

        System.out.println(minDepth(root));
    }

    static boolean first = true;

    public static int minDepth(TreeNode root) {
        if (root == null) {
            if (first) {
                return 0;
            }
            return Integer.MAX_VALUE;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        first = false;

        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }

}