package algorithm.leetCode_1.P5_BinaryTree.p5_BounsProblem.P0_BinaryTree.again.P1_very.P437_Path_Sum3.t2025_10_27;

import algorithm.leetCode_1.P5_BinaryTree.p1_Tree_Maker.TreeHelper;
import algorithm.leetCode_1.P5_BinaryTree.p1_Tree_Maker.TreeNode;

public class P437_Path_Sum3 {

  public static void main(String[] args) {
    P437_Path_Sum3 solver = new P437_Path_Sum3();
    TreeNode root = TreeHelper.buildTree(new Integer[]{
        10, 5, -3, 3, 2, null, 11, 4, -2, null, 1
    });
    int targetSum = 8;
//    TreeNode root = TreeHelper.buildTree(new Integer[]{
//        5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1
//    });
//    int targetSum = 22;
//    TreeNode root = TreeHelper.buildTree(new Integer[]{
//        1000000000, 1000000000, null, 294967296, null,
//        1000000000, null, 1000000000, null, 1000000000
//    });
//    int targetSum = 0;

    System.out.println(solver.pathSum(root, targetSum));
  }

  public int pathSum(TreeNode root, int targetSum) {
    // 자기자신 순회하는데, 자기자신 순회할떄는 왼쪽 오른쪽으로 갈라지지 않게
    // 이러면, 같은걸 계속 도니깐 안됨, 자기자신을 포함하면서 자식것도 돌면, 밑에 자식걸 해줄 필요가 없잖슴
    // 이러면 부모 혼자 돌리면 안되나? 그러면 부모를 제외하고 돌릴 수가 없잖아
    if (root == null) {
      return 0;
    }
    // 이러면 n번 도는거 아닌가, 근데 본인거 포함해서 targetSum 있는지 체크해줘야되긴 하잖아
    // 각자 노드마다 N순회, 자식 노드도 N순회 이러면 N^N인데, N^N 아닌가?, 노드마다 N번가니한 N*N이 맞긴데
    // targetSum 순회를 해야되긴하고, 왼쪽 오른쪽으로 넣어줘야되긴하는데
    int count = dfs(root, targetSum, 0);

    // 왼쪽 count
    count += pathSum(root.left, targetSum);
    // 오른쪽노드 count
    count += pathSum(root.right, targetSum);

    return count;
  }

  // 합구하는 문제
  public int dfs(TreeNode root, long targetSum, int count) {
    // 여기서 count 주는게 맞지 않나..? 라는 생각이 들긴하네
    if (root == null) {
      return 0;
    }
    // 다음에 -+이 나올 수도 있어서 그냥 올리면 안됨, 밑에꺼, count가 몇번 반복되서 그런가?
    long newTargetSum = targetSum - root.val;
    if (newTargetSum == 0) {
      count++;
    }
    // 왜 2가 됬지 이거?, 현재 카운트에서 뭘 어떻게 잘 못해서 그런 것 같은데
    // 2가 올라오는 이유가 뭐지? 뭔가,,, 순회를 할때, 뭔가가 잘못되는 것 같은데
    // count를 순회를 할떄, 이어서 넣어주면 안되는 것 같은데,
    // count를 넣어주면 올라올떄 이전에 반영된 것도 합치네
    count += dfs(root.left, newTargetSum, 0);
    count += dfs(root.right, newTargetSum, 0);

    return count;
  }

}
