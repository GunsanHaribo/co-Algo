package algorithm.leetCode_1.P5_BinaryTree.p5_BounsProblem.P1_BFS.p1161_Maximum_Level_Sum_of_a_Binary_Tree;

import algorithm.leetCode_1.P5_BinaryTree.p1_Tree_Maker.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

import static algorithm.leetCode_1.P5_BinaryTree.p1_Tree_Maker.TreeHelper.buildTree;

public class p1161_Maximum_Level_Sum_of_a_Binary_Tree {

    public static void main(String[] args) {
        TreeNode root = buildTree(new Integer[]{1,7,0,7,-8,null,null});
        System.out.println(maxLevelSum(root));
    }

    private static int maxSum = Integer.MIN_VALUE;
    private static int minLevel = Integer.MAX_VALUE;

    public static int maxLevelSum(TreeNode root) {
        if (root == null) {
            maxSum = 0;
            minLevel = 0;
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int levelCount = 0;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            int sum = 0;
            levelCount++;

            for (int i = 0; i < levelSize; i++) {
                TreeNode current = queue.poll();
                sum += current.val;

                if (current.left != null) queue.add(current.left);
                if (current.right != null) queue.add(current.right);
            }

            if (maxSum < sum) {
                maxSum = sum;
                minLevel = levelCount;
            }

            if (maxSum == sum) {
                if (minLevel > levelCount) {
                    minLevel = levelCount;
                }
            }
        }

        return minLevel;
    }

}
