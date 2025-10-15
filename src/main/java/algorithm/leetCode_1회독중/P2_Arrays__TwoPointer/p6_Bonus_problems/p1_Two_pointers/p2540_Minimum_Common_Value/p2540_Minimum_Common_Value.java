package algorithm.leetCode_1회독중.P2_Arrays__TwoPointer.p6_Bonus_problems.p1_Two_pointers.p2540_Minimum_Common_Value;

public class p2540_Minimum_Common_Value {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,6};
        int[] nums2 = {2,3,4,5};
        int output = getCommon(nums1, nums2);
        System.out.println(output);
    }

    public static int getCommon(int[] nums1, int[] nums2) {
        int min = Integer.MAX_VALUE;
        int num1Pointer = 0;
        int num2Pointer = 0;

        while ((num1Pointer < nums1.length) && (num2Pointer < nums2.length)) {
            if (nums1[num1Pointer] == nums2[num2Pointer]) {
                min = Math.min(min, nums1[num1Pointer]);
                num1Pointer++;
                num2Pointer++;
                continue;
            }
            if (nums1[num1Pointer] < nums2[num2Pointer]) {
                num1Pointer++;
                continue;
            }
            if (nums1[num1Pointer] > nums2[num2Pointer]) {
                num2Pointer++;
            }
        }

        if(min == Integer.MAX_VALUE){
            return -1;
        }

        return min;
    }
}
