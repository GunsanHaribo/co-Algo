package algorithm.leetCode_1.P8_Binary_Search.p1_on_arrays.example.p704_Binary_Search.t2025_10_29;

public class p704_Binary_Search {

  public static void main(String[] args) {
    p704_Binary_Search solver = new p704_Binary_Search();
//    int[] nums = {-1, 0, 3, 5, 9, 12};
//    int target = 9;
    int[] nums = {-1, 0, 3, 5, 9, 12};
    int target = 2;

    System.out.println(solver.search(nums, target));
  }

  public int search(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;

    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] == target) {
        return mid;
      }
      if (nums[mid] < target) {
        left = mid + 1; // target쪽으로 이동해야함
      }
      if (nums[mid] > target) {
        right = mid - 1;
      }
    }

    return -1;
  }

}
