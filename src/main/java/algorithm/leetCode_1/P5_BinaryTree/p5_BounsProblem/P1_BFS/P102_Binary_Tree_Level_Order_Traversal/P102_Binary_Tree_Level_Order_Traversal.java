package algorithm.leetCode_1.P5_BinaryTree.p5_BounsProblem.P1_BFS.P102_Binary_Tree_Level_Order_Traversal;

import algorithm.leetCode_1.P5_BinaryTree.p1_Tree_Maker.TreeNode;

import algorithm.leetCode_1.P5_BinaryTree.p1_Tree_Maker.TreeHelper;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P102_Binary_Tree_Level_Order_Traversal {

    public static void main(String[] args) {
        TreeNode root = TreeHelper.buildTree(new Integer[]{3, 9, 20, null, null, 15, 7});

        System.out.println(levelOrder(root));
    }


    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) { // 노드 사이즈로 for문
                TreeNode current = queue.poll();
                level.add(current.val);

                if (current.left != null) queue.add(current.left);
                if (current.right != null) queue.add(current.right);
            }

            result.add(level);
        }

        return result;
    }

}
