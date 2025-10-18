package algorithm.leetCode_1.P5_BinaryTree.p5_BounsProblem.P0_BinaryTree.important.P1_very.p1372_Longest_ZigZag_Path_in_a_Binary_Tree.t2025_10_11;

import algorithm.leetCode_1.P5_BinaryTree.p1_Tree_Maker.TreeHelper;
import algorithm.leetCode_1.P5_BinaryTree.p1_Tree_Maker.TreeNode;

public class p1372_Longest_ZigZag_Path_in_a_Binary_Tree {

  public static void main(String[] args) {
    p1372_Longest_ZigZag_Path_in_a_Binary_Tree solver = new p1372_Longest_ZigZag_Path_in_a_Binary_Tree();
    TreeNode root = TreeHelper.buildTree(new Integer[]{
        1, null, 2, 3, 4, null, null, 5, 6, null, 7, null, null, null, 8
    });
//    TreeNode root = TreeHelper.buildTree(new Integer[]{
//        1
//    });
//    TreeNode root = TreeHelper.buildTree(new Integer[]{
//        1, 2, 3, null, 4, null, 5, 6, null, 7, 8, null, 9
//    });

    System.out.println(solver.longestZigZag(root));
  }

  public int longestZigZag(TreeNode root) {
    int max = 1;

    max = Math.max(max, dfs(root.left, 1, true));
    max = Math.max(max, dfs(root.right, 1, false));
    // 1. 들어가면, 왼쪽/오른쪽으로 지그재그 카운트를 보냅니다.



    return max - 1;
  }

  public int dfs(TreeNode node, int count, boolean isLeft) {
    if (node == null) {
      return count;
    }

    // 노드에 들어왔다면
    int max = dfs(node.right, 1, false);
    max = Math.max(max, dfs(node.left, 1, true));

    // 내 생각은, 이거 왼쪽 오른쪽 다 외워야함 ㄹㅇ로다가
    // 나온 이후에, 어떻게 또 해야함
    count++;

    // 현재 왼쪽인데 오른쪽이 없고 왼쪽만 있을떄
    if (isLeft) {
      // 지그재그로 더 갈 수 있을떄
      return Math.max(max, dfs(node.right, count, false));
    }
    // 오른쪽인데 왼쪽이 있을떄
    return Math.max(max, dfs(node.left, count, false));
  }

}
// 아 전혀 모르겠네,,, 좀더 생각해 봐야 될듯, 왜이렇게 못찾지 이거


// 아 이거 디버깅이 너무 오래 걸리는데... 후... 이걸 어떻게 해야하나
// 디버깅 능력이 그냥 타버렸는데, 디버깅해도 헷갈리긴한다.
// 시간 복잡도는 또 어떻게 생각해야되지?, 지금 이게 흐음.. O(Nk)정도 될것 같은데
// 이게 노드 별로 한번 더 보내야되는데, 이러고 싶지는 않은데, 지ㅁ은 처음노드에서만 진행을 해서 그러고
// 노드에 일단 들어오면 1로 해서 다시 보내줘야되긴함

// 미지 : 가장 긴 지그재그 경로를 반환 -> 간선의
// 자료 : 트리 하나
// 조건 :
// - 지그재그 : 현재 방향에서 왼쪽 오른쪽으로 바꿔야 합니다.
// --> 지그재그 체크하는기능,
// --> count하는기능,
// --> 지그재그를 더이상 할 수 없으면 max 비교하는기능 max를 놓아야긴함

// - 노드 하나를 선택하고 왼쪽 오른쪽으로 이동합니다. -> 근데 이거 완탐으로는 힘들 것 같은데
// - 1, 5 * 10^4 제급하면 2.5*10^9 제곱까지는 3억이 아니여서 괜찮음
// - O(N^2)까지는 가능합니다.