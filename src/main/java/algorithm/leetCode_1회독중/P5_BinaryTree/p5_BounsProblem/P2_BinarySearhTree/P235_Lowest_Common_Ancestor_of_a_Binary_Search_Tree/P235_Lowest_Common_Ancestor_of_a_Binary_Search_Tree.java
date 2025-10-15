package algorithm.leetCode_1회독중.P5_BinaryTree.p5_BounsProblem.P2_BinarySearhTree.P235_Lowest_Common_Ancestor_of_a_Binary_Search_Tree;

import algorithm.leetCode_1회독중.P5_BinaryTree.p1_Tree_Maker.TreeNode;

import static algorithm.leetCode_1회독중.P5_BinaryTree.p1_Tree_Maker.TreeHelper.buildTree;

public class P235_Lowest_Common_Ancestor_of_a_Binary_Search_Tree {

    public static void main(String[] args) {
        TreeNode root = buildTree(new Integer[]{6, 2, 8, 0, 4, 7, 9, null, null, 3, 5});

        TreeNode p = new TreeNode(2);
        TreeNode q = new TreeNode(8);
        System.out.println(lowestCommonAncestor(root, p, q));
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        else if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        else { // 같으면 루트 반환
            return root;
        }
    }

}
