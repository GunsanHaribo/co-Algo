package algorithm.leetCode_1.P5_BinaryTree.p5_BounsProblem.P0_BinaryTree.important.P1_very.firstP1372_Longest_ZigZag_Path_in_a_Binary_Tree.t2025_10_27;

import algorithm.leetCode_1.P5_BinaryTree.p1_Tree_Maker.TreeHelper;
import algorithm.leetCode_1.P5_BinaryTree.p1_Tree_Maker.TreeNode;

public class p1372_Longest_ZigZag_Path_in_a_Binary_Tree {

  public static void main(String[] args) {
    p1372_Longest_ZigZag_Path_in_a_Binary_Tree solver = new p1372_Longest_ZigZag_Path_in_a_Binary_Tree();
    TreeNode root = TreeHelper.buildTree(new Integer[]{
        1, null, 1, 1, 1, null, null, 1, 1, null, 1, null, null, null, 1
    });

    System.out.println(solver.longestZigZag(root));
  }

  public int longestZigZag(TreeNode root) {
    return dfs(root).previousMax;
  }

  public State dfs(TreeNode root) {
    if (root == null) {
      return new State(0, null);
    }

    // 현재 왼쪽인 상태에서? -> 아니 나도 올려줘야되니깐
    // 왼쪽 자식 노드에서 왼쪽으로 갈 수 있는 최대, 오른쪽에서 갈 수 있는 최대
    // 오른쪽 자식 노드에서 왼쪽으로 갈 수 있는 최대, 오른쪽으로 갈 수 있는 최대
    // 현재 부모에서는
    // 왼쪽 자식 노드에서 오른쪽에서 나온 최대 +1과 왼쪽 자식노드에서 왼쪽에서 나온 최대
    // 오른쪽 자식 노드에서 오른쪽에서 나온 최대와 왼쪽에서 나온 최대+1
    State leftMax = dfs(root.left);
    if (!leftMax.isLeft) {
      return new State(leftMax.previousMax + 1, true);
    } else {
      return new State(leftMax.previousMax, true);
    }
    // 그러지 무조건 반환하긴 하니깐 이렇게 하면
    // 어떻게 할건데,
//    State rightMax = dfs(root.right);
//    if (rightMax.isLeft) {
//      return new State(Math.max(rightMax.previousMax + 1, leftMax.previousMax), false);
//    } else {
//      return new State(Math.max(rightMax.previousMax, leftMax.previousMax), false);
//    }

  }

  private record State(int previousMax, Boolean isLeft) {

  }

}
