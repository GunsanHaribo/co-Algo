package algorithm.leetCode_1회독중.P5_BinaryTree.p5_BounsProblem.P2_BinarySearhTree.P700_Search_in_a_Binary_Search_Tree;

import algorithm.leetCode_1회독중.P5_BinaryTree.p1_Tree_Maker.TreeNode;

import static algorithm.leetCode_1회독중.P5_BinaryTree.p1_Tree_Maker.TreeHelper.buildTree;

public class P700_Search_in_a_Binary_Search_Tree {
    public static void main(String[] args) {
        TreeNode treeNode = buildTree(new Integer[]{4, 2, 7, 1, 3});

        System.out.println(searchBST(treeNode, 1));
    }

    public static TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }

        if (root.val == val) {
            return root;
        } else if (val < root.val) {
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }
    }

}
