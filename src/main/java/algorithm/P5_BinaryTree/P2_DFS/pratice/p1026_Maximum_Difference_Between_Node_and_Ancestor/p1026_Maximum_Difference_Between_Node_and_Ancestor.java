package algorithm.P5_BinaryTree.P2_DFS.pratice.p1026_Maximum_Difference_Between_Node_and_Ancestor;

import algorithm.P5_BinaryTree.P1_Tree_Maker.TreeNode;

public class p1026_Maximum_Difference_Between_Node_and_Ancestor {

    public static void main(String[] args) {
//        root = [8,3,10,1,6,null,14,null,null,4,7,13]


    }

    public int maxAncestorDiff(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.right == null && root.left == null) {
            return root.val;
        }

        return Math.max(Math.abs(maxAncestorDiff(root.left) - root.val) , Math.abs(maxAncestorDiff(root.right) - root.val));
    }

}
