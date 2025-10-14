package algorithm.leetCode_1회독중.P5_BinaryTree.P5_BounsProblem.P2_BinarySearhTree.p1305_All_Elements_in_Two_Binary_Search_Trees;

import algorithm.leetCode_1회독중.P5_BinaryTree.P1_Tree_Maker.TreeNode;

import java.util.ArrayList;
import java.util.List;

import static algorithm.leetCode_1회독중.P5_BinaryTree.P1_Tree_Maker.TreeHelper.buildTree;

public class p1305_All_Elements_in_Two_Binary_Search_Trees {
    public static void main(String[] args) {
        TreeNode root1 = buildTree(new Integer[]{2,1,4});
        TreeNode root2 = buildTree(new Integer[]{1,0,3});

        System.out.println(getAllElements(root1, root2));
    }

    public static List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        inOrder(root1, list1);
        inOrder(root2, list2);

        return merge(list1, list2);
    }

    private static void inOrder(TreeNode node, List<Integer> list) {
        if (node == null) return;
        inOrder(node.left, list);
        list.add(node.val);
        inOrder(node.right, list);
    }

    private static List<Integer> merge(List<Integer> list1, List<Integer> list2) {
        List<Integer> result = new ArrayList<>();
        int i = 0, j = 0;

        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i) < list2.get(j)) {
                result.add(list1.get(i++));
            } else {
                result.add(list2.get(j++));
            }
        }

        while (i < list1.size()) result.add(list1.get(i++));
        while (j < list2.size()) result.add(list2.get(j++));

        return result;
    }

}
