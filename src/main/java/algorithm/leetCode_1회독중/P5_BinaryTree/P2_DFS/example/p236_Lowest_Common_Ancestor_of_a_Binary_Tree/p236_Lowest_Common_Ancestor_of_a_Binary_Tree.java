package algorithm.leetCode_1회독중.P5_BinaryTree.P2_DFS.example.p236_Lowest_Common_Ancestor_of_a_Binary_Tree;

import algorithm.leetCode_1회독중.P5_BinaryTree.P1_Tree_Maker.TreeNode;

import algorithm.leetCode_1회독중.P5_BinaryTree.P1_Tree_Maker.TreeHelper;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class p236_Lowest_Common_Ancestor_of_a_Binary_Tree {

    public static void main(String[] args) {
//        TreeNode root = buildTree(
//                new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4}
//        );
//        TreeNode p = new TreeNode(2);
//        TreeNode q = new TreeNode(8);


        TreeNode root = TreeHelper.buildTree(
                new Integer[]{-1, 0, 3, -2, 4, null, null, 8}
        );
        TreeNode p = new TreeNode(8);
        TreeNode q = new TreeNode(4);


        System.out.println(lowestCommonAncestor(root, p, q).val);
    }

    // 대가 이런 식은 맞는데, 재귀 적인 부분 처리해야함
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Set<Integer> requires = new HashSet<>(Arrays.asList(p.val, q.val));

        return findAncestor(root, requires);
    }

    private static TreeNode findAncestor(TreeNode root, Set<Integer> requires) {
        if (root == null) {
            return null;
        }

        TreeNode leftNode = findAncestor(root.left, requires);
        TreeNode rightNode = findAncestor(root.right, requires);

        boolean isRootPorQ = isContainPorQ(root, requires);
        boolean isLeftPorQ = isContainPorQ(leftNode, requires);
        boolean isRightPorQ = isContainPorQ(rightNode, requires);

        if (!isRootPorQ) {
            if (isLeftPorQ && isRightPorQ) {
                requires.add(root.val);
                return root;
            }
            if (!isLeftPorQ && !isRightPorQ) {
                return root;
            }
            if (isLeftPorQ) {
                return leftNode;
            }

            return rightNode;
        }

        return root;
    }


    private static boolean isContainPorQ(TreeNode node, Set<Integer> requires) {
        if (node == null) {
            return false;
        }

        return requires.contains(node.val);
    }

}
