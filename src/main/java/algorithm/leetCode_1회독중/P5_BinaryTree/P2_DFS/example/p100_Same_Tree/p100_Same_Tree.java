package algorithm.leetCode_1회독중.P5_BinaryTree.P2_DFS.example.p100_Same_Tree;

import algorithm.leetCode_1회독중.P5_BinaryTree.P1_Tree_Maker.TreeNode;

public class p100_Same_Tree {

    public static void main(String[] args) {
//        p = [1,2], q = [1,null,2]

        TreeNode pRoot = new TreeNode(1, new TreeNode(2), null);
        TreeNode qRoot = new TreeNode(1, null, new TreeNode(2));

        System.out.println(isSameTree(pRoot, qRoot));
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }

        if (p.val == q.val) {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }

        return false;
    }

}
