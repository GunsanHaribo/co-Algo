package algorithm.leetCode_1.P5_BinaryTree.p5_BounsProblem.P0_BinaryTree.important.P1_very.P437_Path_Sum3.t2025_10_08;

import algorithm.leetCode_1.P5_BinaryTree.p1_Tree_Maker.TreeHelper;
import algorithm.leetCode_1.P5_BinaryTree.p1_Tree_Maker.TreeNode;

//이렇게 하면 각 원소마다 한번씩 더 실행되는게 문제
public class AgainFailedTurnTwice {

  public static void main(String[] args) {
    AgainFailedTurnTwice solver = new AgainFailedTurnTwice();
    TreeNode root = TreeHelper.buildTree(new Integer[]{
        1,null,2,null,3,null,4,null,5
    });
    int targetSum = 3;
    System.out.println(solver.pathSum(root, targetSum));
  }

  private int count = 0;

  public int pathSum(TreeNode root, int targetSum) {
    dfs(root, targetSum, 0);
    return count;
  }

  // 1에다 넣었을때랑 2에서 시작했을떄 2번 도네
  // 밑에서 같은 로직을 한번 더 계산을 해버리네;;,
  // 흐음... 이런 상황에서는 어떻게 해야되지, 왜 이게 한번 더갈까 근데? 이유가 뭐지?
  // 아니 이거 중복되는 연산이 있네, 어디가
  public void dfs(TreeNode root, int targetSum, int currentSum) {
    if(root == null){
      return;
    }
    int sum = currentSum + root.val;
    if(targetSum == sum){
      System.out.println("들어옴:" + root.val);
      count++;
    }

    // 본인꺼 있을떄 왼쪽, 오른쪽으로 보낸다.
    // 본인거 없을때,... 없을떄면 그냥 0이여야함, 건너뛸수는 없음
    dfs(root.left, targetSum, sum);
    dfs(root.right, targetSum, sum);

    dfs(root.left, targetSum, 0);
    dfs(root.right, targetSum, 0);
  }
  // 시간 복잡도, ~이면의 방향 판단은 처음으로 가는가?, 이것인 것 같습니다.
  // 노드 수는 1000^1000. -> N^2해도 괜찮을 것 같음
  // 다만 지금처럼 N^N으로 하면 힘들지 않나 싶긴함.
  // 내 생각을 시간 복잡도에 맞게 해야됨

}
