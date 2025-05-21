package algorithm.P5_BinaryTree.P3_BFS.practice.p103_Binary_Tree_Zigzag_Level_Order_Traversal;

import algorithm.P5_BinaryTree.P2_DFS.example.TreeNode;

import java.util.*;

public class p103_Binary_Tree_Zigzag_Level_Order_Traversal {

    public static void main(String[] args) {

    }

    public int deepestLeavesSum(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);


        while (!queue.isEmpty()) {
            int nodesInCurrentLevel = queue.size();

            for (int i = 0; i < nodesInCurrentLevel; i++) {
                TreeNode node = queue.remove();
                map.put(count, map.getOrDefault(count, 0) + node.val);

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            count++;
        }

        int max = map.keySet()
                .stream()
                .mapToInt(Integer::intValue).max()
                .getAsInt();

        return map.get(max);
    }

}
