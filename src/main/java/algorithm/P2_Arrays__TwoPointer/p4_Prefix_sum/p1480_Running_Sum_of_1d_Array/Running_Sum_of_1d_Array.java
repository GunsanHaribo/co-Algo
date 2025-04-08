package algorithm.P2_Arrays__TwoPointer.p4_Prefix_sum.p1480_Running_Sum_of_1d_Array;

import java.util.Arrays;

public class Running_Sum_of_1d_Array {

  public static void main(String[] args) {
    int[] nums ={1,2,3,4};
    System.out.println(Arrays.toString(runningSum(nums)));
  }

  public static int[] runningSum(int[] nums) {
    int[] prefixSum = new int[nums.length];
    prefixSum[0] = nums[0];

    for (int i = 1; i < nums.length; i++) {
      prefixSum[i] = prefixSum[i - 1] + nums[i];
    }

    return prefixSum;
  }
}
