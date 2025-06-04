package algorithm.P5_BinaryTree.P5_BounsProblem.P2_BinarySearhTree.p450_Delete_Node_in_a_BST;

import algorithm.P5_BinaryTree.P1_Tree_Maker.TreeNode;

import static algorithm.P5_BinaryTree.P1_Tree_Maker.TreeHelper.buildTree;

public class p450_Delete_Node_in_a_BST {

    public static void main(String[] args) {
        TreeNode root = buildTree(new Integer[]{5, 3, 6, 2, 4, null, 7});
        int key = 3;

        System.out.println(deleteNode(root, key));
    }

    public static TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        // 허허...
        if (root.right == null && root.val == key) {
            root = root.right;
        }

        if (root.right != null && root.val == key) {
            root = root.right;
        }

        return root;
    }

}
