package algorithm.leetCode_1회독중.P5_BinaryTree.p1_Tree_Maker;

public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        TreeNode treeNode = (TreeNode) o;

        return val == treeNode.val;
    }

    @Override
    public int hashCode() {
        return val;
    }

    @Override
    public String toString() {
        return val + "";
    }

}
