package algorithm.P5_BinaryTree.P5_BounsProblem.P0_BinaryTree.p1372_Longest_ZigZag_Path_in_a_Binary_Tree;

import algorithm.P5_BinaryTree.P1_Tree_Maker.TreeNode;

import static algorithm.P5_BinaryTree.P1_Tree_Maker.TreeHelper.buildTree;

public class p1372_Longest_ZigZag_Path_in_a_Binary_Tree {

    public static void main(String[] args) {
        TreeNode root = buildTree(new Integer[]{1, null, 1, 1, 1, null, null, 1, 1, null, 1, null, null, null, 1});

        System.out.println(longestZigZag(root));
    }


    public static int longestZigZag(TreeNode root) {
        return 0;
    }

}
