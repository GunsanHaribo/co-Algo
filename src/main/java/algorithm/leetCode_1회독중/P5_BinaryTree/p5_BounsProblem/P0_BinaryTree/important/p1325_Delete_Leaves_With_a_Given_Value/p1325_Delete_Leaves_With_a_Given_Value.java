package algorithm.leetCode_1회독중.P5_BinaryTree.p5_BounsProblem.P0_BinaryTree.important.p1325_Delete_Leaves_With_a_Given_Value;

import algorithm.leetCode_1회독중.P5_BinaryTree.p1_Tree_Maker.TreeNode;

import algorithm.leetCode_1회독중.P5_BinaryTree.p1_Tree_Maker.TreeHelper;
import java.util.ArrayList;
import java.util.List;

public class p1325_Delete_Leaves_With_a_Given_Value {

    public static void main(String[] args) {
        TreeNode root = TreeHelper.buildTree(new Integer[]{1, 2, 3, 2, null, 2, 4});
        int target = 2;

        List<String> path = new ArrayList<>();
        postOrder(removeLeafNodes(root, target), path);
        System.out.println(path);
    }

    public static TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root == null) {
            return null;
        }

        root.left = removeLeafNodes(root.left, target);
        root.right = removeLeafNodes(root.right, target);

        // 자식노드 이면서 target이면 null 반환
        if (root.left == null && root.right == null && root.val == target) {
            return null;
        }

        return root;
    }


    // 확인용
    public static void postOrder(TreeNode node, List<String> path) {
        if (node == null) {
            path.add(null);
            return;
        }

        path.add(node.val + "");
        postOrder(node.left, path);
        postOrder(node.right, path);
    }


}
