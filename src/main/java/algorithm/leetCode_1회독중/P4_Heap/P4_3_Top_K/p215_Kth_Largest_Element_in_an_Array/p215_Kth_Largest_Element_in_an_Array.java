package algorithm.leetCode_1회독중.P4_Heap.P4_3_Top_K.p215_Kth_Largest_Element_in_an_Array;

import java.util.PriorityQueue;

public class p215_Kth_Largest_Element_in_an_Array {
    public static void main(String[] args) {
//        int[] nums = {3, 2, 1, 5, 6, 4};
//        int k = 2;

        int[] nums = {3,2,3,1,2,4,5,5,6};
        int k = 4;


        System.out.println(findKthLargest(nums, k));
    }

    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int num : nums) {
            heap.add(num);

            if (heap.size() > k) {
                heap.remove();
            }
        }

        return heap.peek();
    }
}
