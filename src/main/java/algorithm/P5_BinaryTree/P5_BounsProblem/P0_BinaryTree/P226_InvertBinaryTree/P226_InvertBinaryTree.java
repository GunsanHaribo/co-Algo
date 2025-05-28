package algorithm.P5_BinaryTree.P5_BounsProblem.P0_BinaryTree.P226_InvertBinaryTree;

import algorithm.P5_BinaryTree.P1_Tree_Maker.TreeNode;

import static algorithm.P5_BinaryTree.P1_Tree_Maker.TreeHelper.buildTree;

public class P226_InvertBinaryTree {

    public static void main(String[] args) {
        TreeNode root = buildTree(new Integer[]{4,2,7,1,3,6,9});

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
