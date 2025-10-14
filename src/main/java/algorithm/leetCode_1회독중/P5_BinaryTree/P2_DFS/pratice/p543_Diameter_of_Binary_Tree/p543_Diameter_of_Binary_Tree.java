package algorithm.leetCode_1회독중.P5_BinaryTree.P2_DFS.pratice.p543_Diameter_of_Binary_Tree;

import algorithm.leetCode_1회독중.P5_BinaryTree.P1_Tree_Maker.TreeNode;

public class p543_Diameter_of_Binary_Tree {
    public static void main(String[] args) {
//        root = [1,2,3,4,5]

        TreeNode leaf0 = new TreeNode(5);
        TreeNode leaf1 = new TreeNode(4);

        TreeNode leaf2 = new TreeNode(3);

        TreeNode leaf3 = new TreeNode(2, leaf1, leaf0);
        TreeNode root = new TreeNode(1, leaf3, leaf2);

        System.out.println(diameterOfBinaryTree(root));
    }

    static int answerMax = Integer.MIN_VALUE;
    static boolean first = true;

    public static int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        if(answerMax == Integer.MIN_VALUE){
            return 0;
        }

        return answerMax;
    }

    private static int dfs(TreeNode node) {
        if (node == null) return 0;
        int left = dfs(node.left);
        int right = dfs(node.right);
        answerMax = Math.max(answerMax, left + right);

        return Math.max(left, right) + 1;
    }

// 노드에 지름이 이미 있어야됨
//    [4,/-7,-3/,null,null,-9,-3/,9,-7,-4,null,/6,null,-6,-6/,null,null,////   0,6,5,null//  9,null, null, -1,/-4,null,null,null,-2] -----> 8
//                       4      // 애가 7이고 // 노드 마다 두노드 사이에 경로의 길이는 가지고 있어야지 않나?
//                     /   \   //
//                 -7           -3     // 구해야되는게 left depth  +  right depth 의 최대 값의 합 //애가 만약에 8이면
//                         /         \
//                   -9                -3
//                  /  \            /      \
//                9   -7           -4        null
//               / \   / \       /   \
//             6,null -6,-6     null,null
//           / \     / \    /  \    /  \
//         0,   6   5 null
//      /  \  /  \   /
//    9,null,null,-1  -4(여기네), null, null -2    -> 루트에 저장해야 할 것은 양쪽의 depth와 최댓감ㅅ
//
    // 음... 약간... 저 내용을 넣어줄 필요성이 있는 것가틍ㄴ데
    //

}
