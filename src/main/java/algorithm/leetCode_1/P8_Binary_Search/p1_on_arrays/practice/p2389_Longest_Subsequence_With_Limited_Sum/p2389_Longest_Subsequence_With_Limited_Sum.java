package algorithm.leetCode_1.P8_Binary_Search.p1_on_arrays.practice.p2389_Longest_Subsequence_With_Limited_Sum;

import java.util.Arrays;

public class p2389_Longest_Subsequence_With_Limited_Sum {

  public static void main(String[] args) {
    p2389_Longest_Subsequence_With_Limited_Sum solver = new p2389_Longest_Subsequence_With_Limited_Sum();
//    int[] nums = {4, 5, 2, 1};
//    int[] queries = {3, 10, 21};

    int[] nums = {2,3,4,5};
    int[] queries = {1};

    int[] answer = solver.answerQueries(nums, queries);
    System.out.println(Arrays.toString(answer));
  }

  public int[] answerQueries(int[] nums, int[] queries) {
    int[] answer = new int[queries.length];
    Arrays.sort(nums);
    int[] prefixSum = new int[nums.length];
    prefixSum[0] = nums[0];
    for (int i = 1; i < nums.length; i++) {
      prefixSum[i] = nums[i] + prefixSum[i - 1];
    }
    System.out.println(Arrays.toString(prefixSum));

    for (int i = 0; i < queries.length; i++) {
      answer[i] = binarySearch(prefixSum, queries[i]);
    }

    return answer;
  }

  public int binarySearch(int[] prefixSum, int query) {
    int left = 0;
    int right = prefixSum.length - 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (prefixSum[mid] == query) {
        return mid+1;
      }
      if (prefixSum[mid] < query) {
        left = mid + 1;
        continue;
      }
      if (prefixSum[mid] > query) {
        right = mid - 1;
      }
    }

    return left;
  }

}
