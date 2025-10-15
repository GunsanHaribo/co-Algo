package algorithm.leetCode_1회독중.P3_Hashing.p5_Bonus_Problem.counting.p1512_Number_of_Good_Pairs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class p1512_Number_of_Good_Pairs {

  public static void main(String[] args) {
    p1512_Number_of_Good_Pairs solver = new p1512_Number_of_Good_Pairs();
    int[] nums = {1, 2, 3, 1, 1, 3};

    System.out.println(solver.numIdenticalPairs(nums));
  }

  Map<Integer, Integer> records = new HashMap<>();

  public int numIdenticalPairs(int[] nums) {
    int count = 0;
    for (int num : nums) {
      if (records.containsKey(num)) {
        count += records.get(num);
        records.put(num, records.get(num) + 1);
      }else {
        records.put(num, 1);
      }
    }

    return count;
  }

}
