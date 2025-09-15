package algorithm.P5_BinaryTree.P5_BounsProblem.important.P113_Path_Sum2;

import algorithm.P5_BinaryTree.P1_Tree_Maker.TreeNode;

import java.util.ArrayList;
import java.util.List;

import static algorithm.P5_BinaryTree.P1_Tree_Maker.TreeHelper.buildTree;

public class P113_Path_Sum2 {

    public static void main(String[] args) {
        TreeNode root = buildTree(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1});

        System.out.println(pathSum(root, 22));
    }

    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(root, targetSum, new ArrayList<>(), result);
        return result;
    }

    private static void dfs(TreeNode node, int remainingSum, List<Integer> path, List<List<Integer>> result) {
        if (node == null) return;

        path.add(node.val);

        if (node.left == null && node.right == null && remainingSum == node.val) {
            result.add(new ArrayList<>(path));
        } else {
            dfs(node.left, remainingSum - node.val, path, result);
            dfs(node.right, remainingSum - node.val, path, result);
        }

        path.remove(path.size() - 1);
    }

}
