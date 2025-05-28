package algorithm.P5_BinaryTree.P5_BounsProblem.P1_BFS.P637_Average_of_Levels_in_Binary_Tree;

import algorithm.P5_BinaryTree.P1_Tree_Maker.TreeNode;

import java.util.*;

import static algorithm.P5_BinaryTree.P1_Tree_Maker.TreeHelper.buildTree;

public class P637_Average_of_Levels_in_Binary_Tree {

    public static void main(String[] args) {
        TreeNode root = buildTree(new Integer[]{3, 9, 20, null, null, 15, 7});

        System.out.println(averageOfLevels(root));
    }

    public static List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode current = queue.poll();
                level.add(current.val);

                if (current.left != null) queue.add(current.left);
                if (current.right != null) queue.add(current.right);
            }

            double asDouble = level.stream()
                    .mapToInt(Integer::intValue)
                    .average().getAsDouble();

            result.add(asDouble);
        }

        return result;
    }

}
