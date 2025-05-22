package algorithm.P5_BinaryTree.P3_BFS.practice.p1302_Deepest_Leaves_Sum;

import algorithm.P5_BinaryTree.P1_Tree_Maker.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class p1302_Deepest_Leaves_Sum {
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
