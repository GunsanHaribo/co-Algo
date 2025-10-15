package algorithm.leetCode_1회독중.P5_BinaryTree.p5_BounsProblem.P0_BinaryTree.P226_InvertBinaryTree;

import algorithm.leetCode_1회독중.P5_BinaryTree.p1_Tree_Maker.TreeNode;
import algorithm.leetCode_1회독중.P5_BinaryTree.p1_Tree_Maker.TreeHelper;

public class P226_InvertBinaryTree {

    public static void main(String[] args) {
        TreeNode root = TreeHelper.buildTree(new Integer[]{4,2,7,1,3,6,9});

        System.out.println(invertTree(root));
    }

    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        root.left = right;
        root.right = left;

        return root;
    }

}
