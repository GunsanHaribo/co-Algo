package algorithm.P5_BinaryTree.P5_BounsProblem.P0_BinaryTree.important.P1_very.p1372_Longest_ZigZag_Path_in_a_Binary_Tree.t2025_10_11;


import algorithm.P5_BinaryTree.P1_Tree_Maker.TreeHelper;
import algorithm.P5_BinaryTree.P1_Tree_Maker.TreeNode;

// 이전 것이 왜 안되는지 생각해야됨
public class Again {
  // 1. 1 -> 1에서 가장 긴 지그재그를 판단해야 되는데
  // 2. 2 -> 2에서 자기 자식중에 max를 정해서 줘야함
  // 3. 2-4
  // 4. 2-4-5
  // 정답: 2-4-5-7

  public static void main(String[] args) {
    Again solver = new Again();
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
