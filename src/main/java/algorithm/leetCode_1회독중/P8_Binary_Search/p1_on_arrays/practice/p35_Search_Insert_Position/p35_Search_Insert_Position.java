package algorithm.leetCode_1회독중.P8_Binary_Search.p1_on_arrays.practice.p35_Search_Insert_Position;

public class p35_Search_Insert_Position {

  public static void main(String[] args) {
    p35_Search_Insert_Position solver = new p35_Search_Insert_Position();

//    int[] nums = {1, 3, 5, 6};
//    int target = 5;
//
    int[] nums = {1, 3, 5, 6};
    int target = 2;

    int answerIndex = solver.searchInsert(nums, target);
    System.out.println(answerIndex);
  }

  public int searchInsert(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;

    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] == target) {
        return mid;
      }

      if (nums[mid] > target) {
        right = mid - 1;
        continue;
      }

      if (nums[mid] < target) {
        left = mid + 1;
      }
    }

    return left;
  }

}
