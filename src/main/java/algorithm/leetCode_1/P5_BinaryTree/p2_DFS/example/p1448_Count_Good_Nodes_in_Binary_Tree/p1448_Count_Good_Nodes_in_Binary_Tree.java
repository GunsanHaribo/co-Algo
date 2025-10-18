package algorithm.leetCode_1.P5_BinaryTree.p2_DFS.example.p1448_Count_Good_Nodes_in_Binary_Tree;

import algorithm.leetCode_1.P5_BinaryTree.p1_Tree_Maker.TreeNode;

public class p1448_Count_Good_Nodes_in_Binary_Tree {

    public static void main(String[] args) {
        // [3,3,null,4,2]

        TreeNode leftLeaf = new TreeNode(4);
        TreeNode rightLeaf = new TreeNode(2);
        TreeNode middle = new TreeNode(3, leftLeaf, rightLeaf);
        TreeNode root = new TreeNode(3, middle, null);

        System.out.println(goodNodes(root));
    }

    public static int goodNodes(TreeNode root) {
        int max = root.val;
        return dfs(root, max);
    }

    public static int dfs(TreeNode root, int max) {
        if (root == null) {
            return 0;
        }

        if (max <= root.val) {
            int newMax = root.val;
            return dfs(root.left, newMax) + dfs(root.right, newMax) + 1;
        }

        return dfs(root.left, max) + dfs(root.right, max);
    }

}
