package algorithm.leetCode_1회독중.P5_BinaryTree.P4_BinarySearchTrees.pratice.p270_Closest_Binary_Search_Tree_Value;

import algorithm.leetCode_1회독중.P5_BinaryTree.P1_Tree_Maker.TreeHelper;
import algorithm.leetCode_1회독중.P5_BinaryTree.P1_Tree_Maker.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class Worst_p270_Closest_Binary_Search_Tree_Value {

  public static void main(String[] args) {
    Worst_p270_Closest_Binary_Search_Tree_Value solver = new Worst_p270_Closest_Binary_Search_Tree_Value();
    TreeNode root = TreeHelper.buildTree(new Integer[]{4, 2, 5, 1, 3});
    double target = 3.714286;

    System.out.println((int) target); // 가장 가까운 수를 어떻게 내려주지?
    System.out.println(solver.findNearestNode(root, target));
  }

  public int findNearestNode(TreeNode root, double target) {
    // 가장 가까운 정수 구하기
    int nearestTargetInt = 0;

    // 넣어줘서 찾는다.
    Integer nearestOneInTree = dfs(root, nearestTargetInt);
    if (nearestOneInTree == null) {
      List<Integer> nodes = new ArrayList<>();
      getTree(root, nodes);
      int index = nodes.indexOf(nearestTargetInt);
      int frontIndex = index-1;
      int behindIndex = index+1; // size를 넘는지 안넘는지 체크
      List<Integer> candidates = new ArrayList<>();
      // 여기서 넣어주고, 차를 계산합니다.
//      for(){
//
//      }
//      target


      return 0;
    }

    return nearestOneInTree;
  }

  public void getTree(TreeNode node, List<Integer> nodes) {

  }

  public Integer dfs(TreeNode node, int target) {
    if (node == null) {
      return null;
    }
    if (node.val == target) {
      return target;
    }
    if (node.val < target) {
      if (node.right == null) {
        node.right = new TreeNode(target);
        return null;
      }
      return dfs(node.right, target);
    }

    if (node.left == null) {
      node.left = new TreeNode(target);
      return null;
    }
    return dfs(node.left, target);
  }

}
