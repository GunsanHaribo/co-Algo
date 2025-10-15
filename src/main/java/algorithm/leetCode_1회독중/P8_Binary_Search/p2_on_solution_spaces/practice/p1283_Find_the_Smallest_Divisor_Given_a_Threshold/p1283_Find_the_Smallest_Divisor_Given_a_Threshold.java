package algorithm.leetCode_1회독중.P8_Binary_Search.p2_on_solution_spaces.practice.p1283_Find_the_Smallest_Divisor_Given_a_Threshold;

public class p1283_Find_the_Smallest_Divisor_Given_a_Threshold {

  public static void main(String[] args) {
    p1283_Find_the_Smallest_Divisor_Given_a_Threshold solver = new p1283_Find_the_Smallest_Divisor_Given_a_Threshold();
//    int[] nums = {1, 2, 5, 9};
//    int threshold = 6;

//    int[] nums = {44, 22, 33, 11, 1};
//    int threshold = 5;

//    int[] nums = {21212, 10101, 12121};
//    int threshold = 1000000;
//
    int[] nums = {44,22,33,11,1};
    int threshold = 5;

    int answer = solver.smallestDivisor(nums, threshold);
    System.out.println(answer);
  }

  public int smallestDivisor(int[] nums, int threshold) {
    int left = 1;
    int right = 0;

    for (int num : nums) {
      right = Math.max(right, num);
    }

    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (check(mid, nums, threshold)) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }

    return left;
  }

  public boolean check(int divisor, int[] nums, int threshold) {
    int sum = 0;
    for (int num : nums) {
      sum += Math.ceil(( (double) num / divisor));
    }

    return sum <= threshold;
  }

}
