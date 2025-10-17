package algorithm.leetCode_1회독중.P7_DP.p1_1D_problems.practice.p70_ClimbingStairs.t2025_7_10;

import java.util.HashMap;
import java.util.Map;

public class p70_ClimbingStairs {

  public static void main(String[] args) {
    p70_ClimbingStairs solver = new p70_ClimbingStairs();
    int answer = solver.climbStairs(2);
    System.out.println(answer);
  }

  Map<Integer, Integer> memo = new HashMap<>();

  public int climbStairs(int n) {
    if (n < 0) {
      return 0;
    }
    if (n == 0) {
      return 1;
    }

    if(memo.containsKey(n)){
      return memo.get(n);
    }

    memo.put(n, climbStairs(n - 1) + climbStairs(n - 2));
    return memo.get(n);
  }

}
