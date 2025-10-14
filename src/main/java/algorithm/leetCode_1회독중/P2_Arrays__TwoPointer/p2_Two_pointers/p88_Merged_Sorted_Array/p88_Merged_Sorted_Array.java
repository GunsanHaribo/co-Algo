package algorithm.leetCode_1회독중.P2_Arrays__TwoPointer.p2_Two_pointers.p88_Merged_Sorted_Array;

import java.util.Arrays;

public class p88_Merged_Sorted_Array {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int m = 3;
        int[] nums2 = {2,5,6};
        int n = 3;
        merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));

//
//        int[] nums1 = {1};
//        int m = 1;
//        int[] nums2 = {};
//        int n = 0;
//        merge(nums1, m, nums2, n);
//        System.out.println(Arrays.toString(nums1));


//        int[] nums1 = {0};
//        int m = 0;
//        int[] nums2 = {1};
//        int n = 1;
//        merge(nums1, m, nums2, n);
//        System.out.println(Arrays.toString(nums1));
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int nums1Pointer = m - 1;
        int nums2Pointer = n - 1;
        int totalPointer = m + n - 1;


        while (nums2Pointer >= 0 && nums1Pointer >= 0) {
            if (nums1[nums1Pointer] > nums2[nums2Pointer]) {
                nums1[totalPointer] = nums1[nums1Pointer];
                nums1Pointer--;
            }else{
                nums1[totalPointer] = nums2[nums2Pointer];
                nums2Pointer--;
            }

            totalPointer--;
        }

        if (nums1Pointer < 0) {
            while (totalPointer >= 0) {
                nums1[totalPointer] = nums2[nums2Pointer];

                totalPointer--;
                nums2Pointer--;
            }
        }
    }
}
