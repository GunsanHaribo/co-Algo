package algorithm.P7_DP.p746_Min_Cost_Climbing_Stairs;

import java.util.HashMap;
import java.util.Map;

public class p746_Min_Cost_Climbing_Stairs {

  public static void main(String[] args) {
    int[] cost = new int[]{10, 15, 20};
//    int[] cost = new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1};

    p746_Min_Cost_Climbing_Stairs solver = new p746_Min_Cost_Climbing_Stairs();
    int answer = solver.minCostClimbingStairs(cost);
    System.out.println(answer);
  }

  Map<Integer, Integer> memo = new HashMap<>();

  public int minCostClimbingStairs(int[] cost) {
    int topOver = cost.length;
    return memoStairs(topOver, cost);
  }

  public int memoStairs(int currentStair, int[] cost) {
    if (currentStair < 0) {
      return 0;
    }
    if (currentStair == 0) {
      return cost[0];
    }
    if (currentStair == 1) {
      return cost[1];
    }

    int currentStairCost = 0;
    if (currentStair != cost.length) {
      currentStairCost = cost[currentStair];
    }

    if (memo.containsKey(currentStair)) {
      return memo.get(currentStair);
    }

    memo.put(currentStair, currentStairCost +
        Math.min(memoStairs(currentStair - 1, cost), memoStairs(currentStair - 2, cost)));

    return memo.get(currentStair);
  }


}
