package algorithm.leetCode_1회독중.P5_BinaryTree.p5_BounsProblem.P1_BFS.p1609_Even_Odd_Tree;

import algorithm.leetCode_1회독중.P5_BinaryTree.p1_Tree_Maker.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

import static algorithm.leetCode_1회독중.P5_BinaryTree.p1_Tree_Maker.TreeHelper.buildTree;

public class p1609_Even_Odd_Tree {

    public static void main(String[] args) {
        TreeNode root = buildTree(new Integer[]{5,4,2,3,3,7});

        System.out.println(isEvenOddTree(root));
    }

    public static boolean isEvenOddTree(TreeNode root) {
        if (root == null) return false;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int levelCount = 0;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            int prevVal = (levelCount % 2 == 0) ? Integer.MIN_VALUE : Integer.MAX_VALUE;

            for (int i = 0; i < levelSize; i++) {
                TreeNode current = queue.poll();

                if (levelCount % 2 == 0) { // 짝수
                    if (current.val % 2 == 0 || current.val <= prevVal) {
                        return false;
                    }
                } else { // 홀수
                    if (current.val % 2 == 1 || current.val >= prevVal) {
                        return false;
                    }
                }
                prevVal = current.val;

                if (current.left != null) queue.add(current.left);
                if (current.right != null) queue.add(current.right);
            }

            levelCount++;
        }

        return true;
    }

}
