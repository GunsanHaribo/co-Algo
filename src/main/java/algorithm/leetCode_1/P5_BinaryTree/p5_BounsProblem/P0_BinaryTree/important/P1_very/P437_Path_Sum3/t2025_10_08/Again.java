package algorithm.leetCode_1.P5_BinaryTree.p5_BounsProblem.P0_BinaryTree.important.P1_very.P437_Path_Sum3.t2025_10_08;

import algorithm.leetCode_1.P5_BinaryTree.p1_Tree_Maker.TreeHelper;
import algorithm.leetCode_1.P5_BinaryTree.p1_Tree_Maker.TreeNode;

public class Again {

  public static void main(String[] args) {
    Again solver = new Again();
    TreeNode root = TreeHelper.buildTree(new Integer[]{
        1, null, 2, null, 3, null, 4, null, 5
    });
    int targetSum = 3;
//    TreeNode root = TreeHelper.buildTree(new Integer[]{
//        10, 5, -3, 3, 2, null, 11, 3, -2, null, 1
//    });
//    int targetSum = 8;

    System.out.println(solver.pathSum(root, targetSum));
  }

  public int pathSum(TreeNode root, int targetSum) {
    if (root == null) {
      return 0;
    }
    int count = 0;
    if (targetSum - root.val == 0) {
      count++;
//      return count; // 여기서 멈춰야되는 이유가 있나?, 밑에서 더 나올 수도 있잖아, 여기도 2가 나오는데;;
    }

    count += pathSum(root.left, targetSum - root.val); // 본인꺼 까고 왼쪽오른쪽
    count += pathSum(root.right, targetSum - root.val); // 본인꺼 까고 왼쪽 오른쪽

    // 안까고 시작? 근데 이건 생략할 수는 없고 아예 처음 부터 해야함. targetSum 처음 부터, 여기는 이렇게 넘겨주면깐 거에서 넘겨주잖아
    count += pathSum(root.left, targetSum); // 건너 뛸 수는 없으니깐, 여기는 아예 처음 부터 돌려야됨, 그니깐 원본 targetSum이 유지가 되야함//
    count += pathSum(root.right, targetSum); // 왜 이렇게 하면 안되지?

    return count;
  }

}