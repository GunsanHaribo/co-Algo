package algorithm.P5_BinaryTree.P2_DFS.example.p236_Lowest_Common_Ancestor_of_a_Binary_Tree;

import algorithm.P5_BinaryTree.P2_DFS.example.TreeNode;

public class p236_Lowest_Common_Ancestor_of_a_Binary_Tree {

    public static void main(String[] args) {
//[3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4

//        TreeNode leaf = new TreeNode(8);
//        TreeNode leaf2 = new TreeNode(0);
//        TreeNode right = new TreeNode(1, leaf2, leaf);
//
//        TreeNode leaf1 = new TreeNode(4);
//        TreeNode leaf0 = new TreeNode(7);
//        TreeNode left1right1 = new TreeNode(2, leaf0, leaf1);
//        TreeNode left2 = new TreeNode(6);
//        TreeNode left = new TreeNode(5, left2, left1right1);
//        TreeNode root = new TreeNode(3, left, right);
//        preOrder(root);


//        TreeNode p = new TreeNode(5);
//        TreeNode q = new TreeNode(1);


//        TreeNode p = new TreeNode(5);
//        TreeNode q = new TreeNode(4);


        TreeNode right = new TreeNode(3);

        TreeNode right3 = new TreeNode(8);
        TreeNode right2 = new TreeNode(4);
        TreeNode right1 = new TreeNode(-2, right3, null);

        TreeNode left = new TreeNode(0, right1, right2);
        TreeNode root = new TreeNode(-1, left, right);


        TreeNode p = new TreeNode(3);
        TreeNode q = new TreeNode(8);

//        preOrder(root);
        System.out.println(lowestCommonAncestor(root, p, q).val);

        //        -1
        //    0       3
        //  -2 4
        // 8

         // T || F -> T라고 쓰고 싶은데 T가 그리고 T인거 반환하면되지않나 싶은데
        //
    }

    public static void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        System.out.println(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }


    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return new TreeNode(Integer.MIN_VALUE);
        }

        boolean isRootPorQ = isContainPorQ(root, p, q);
        boolean isLeftPorQ = isContainPorQ(lowestCommonAncestor(root.left, p, q), p, q); // 이게 타고 들어와야되는데 그게 안됨
        boolean isRightPorQ = isContainPorQ(lowestCommonAncestor(root.right, p, q), p, q);

        if (!isRootPorQ) {
            System.out.println();
            System.out.println(root.val);
            System.out.println(isLeftPorQ + " left " + root.left);
            System.out.println(isRightPorQ +" right " + root.right); // 이게 반환하는게 힘드네 // 반환을...
            if ((isLeftPorQ && isRightPorQ) || (!isLeftPorQ && !isRightPorQ)) {
                return root;
            }
            if (isLeftPorQ) {
                return root.left;
                // 스위칭을 시켜주던가 해야되지 않나?, 타고 올라가야되는데
                // 이게 안되? 따로 DTO만들면 가능하긴한데
            }

            return root.right;
        }

        return root;
    }

    private static boolean isContainPorQ(TreeNode node, TreeNode p, TreeNode q) {
        return (node.val == p.val) || (node.val == q.val);
    }

}
