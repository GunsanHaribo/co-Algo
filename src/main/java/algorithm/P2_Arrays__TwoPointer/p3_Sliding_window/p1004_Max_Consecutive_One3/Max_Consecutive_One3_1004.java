package algorithm.P2_Arrays__TwoPointer.p3_Sliding_window.p1004_Max_Consecutive_One3;

public class Max_Consecutive_One3_1004 {

  public static void main(String[] args) {
    int[] nums = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
    int k = 2;

    System.out.println(longestOnes(nums, k));
  }

  public static int longestOnes(int[] nums, int k) {
    int left = 0;
    int curr = 0;
    int ans = 0;

    for (int right = 0; right < nums.length; right++) {
      if (nums[right] == 0) {
        curr++;
      }
      while (curr > k) {
        if (nums[left] == 0) {
          curr--;
        }
        left++;
      }

      ans = Math.max(ans, right - left + 1);
    }

    return ans;
  }
}