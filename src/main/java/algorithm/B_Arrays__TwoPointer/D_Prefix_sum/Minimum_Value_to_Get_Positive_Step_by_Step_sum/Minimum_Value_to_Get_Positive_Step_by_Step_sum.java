package algorithm.B_Arrays__TwoPointer.D_Prefix_sum.Minimum_Value_to_Get_Positive_Step_by_Step_sum;

public class Minimum_Value_to_Get_Positive_Step_by_Step_sum {

  public static void main(String[] args) {
    int[] nums = {-3, 2, -3, 4, 2};
    System.out.println(minStartValue(nums));
  }

  public static int minStartValue(int[] nums) {
    int minPrefixSum = 0;
    int prefixSum = 0;

    for (int num : nums) {
      prefixSum += num;
      minPrefixSum = Math.min(minPrefixSum, prefixSum);
    }

    return 1 - minPrefixSum;
  }
}
