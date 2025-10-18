package algorithm.leetCode_1.P5_BinaryTree.p5_BounsProblem.P2_BinarySearhTree.p450_Delete_Node_in_a_BST;

import algorithm.leetCode_1.P5_BinaryTree.p1_Tree_Maker.TreeNode;

import static algorithm.leetCode_1.P5_BinaryTree.p1_Tree_Maker.TreeHelper.buildTree;

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

        if (root.left != null && root.right == null && root.val == key) {
            // -> 이것도 어떻게 할건데
            root = root.left;
        }

        if (root.right != null && root.val == key) {
            // -> 이거 어떻게 할건데
            root = root.right;
        }

        return root;
    }

}
