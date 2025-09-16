package algorithm.P5_BinaryTree.P5_BounsProblem.P0_BinaryTree.important.p872_Leaf_Similar_Trees;

import algorithm.P5_BinaryTree.P1_Tree_Maker.TreeNode;

import static algorithm.P5_BinaryTree.P1_Tree_Maker.TreeHelper.buildTree;

public class p872_Leaf_Similar_Trees {

    public static void main(String[] args) {
//        TreeNode root1 = buildTree(new Integer[]{3, 5, 1, 6, 2, 9, 8, null, null, 7, 4});
//        TreeNode root2 = buildTree(new Integer[]{3, 5, 1, 6, 7, 4, 2, null, null, null, null, null, null, 9, 8});
        TreeNode root1 = buildTree(new Integer[]{3,5,1,6,2,9,8,null,null,7,14});
        TreeNode root2 = buildTree(new Integer[]{3,5,1,6,71,4,2,null,null,null,null,null,null,9,8});

        System.out.println(leafSimilar(root1, root2));
    }

    public static boolean leafSimilar(TreeNode root1, TreeNode root2) {
        String left = leafNodes(root1);
        String right = leafNodes(root2);

        return left.equals(right);
    }

    public static String leafNodes(TreeNode node) {
        if (node == null) {
            return "";
        }
        if (node.right == null && node.left == null) {
            return "*" + node.val + "*";
        }

        return leafNodes(node.left) + leafNodes(node.right);
    }

}
