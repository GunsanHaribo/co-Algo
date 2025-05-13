package algorithm.P4_Heap.P4_4_Bounus_problems.p373_Find_K_Pairs_with_Smallest_Sums;

import java.util.List;
import java.util.PriorityQueue;

public class p373_Find_K_Pairs_with_Smallest_Sums {
    public static void main(String[] args) {
//        int[] nums1 = {1, 7, 11};
//        int[] nums2 = {2, 4, 6};
//        int k = 3;

        int[] nums1 = {1, 2, 4, 5, 6};
        int[] nums2 = {3, 5, 7, 9};
        int k = 20;

        System.out.println(kSmallestPairs(nums1, nums2, k));
    }

    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<tuple> resultHeap = new PriorityQueue<>((v1, v2) -> (int) (tuple.sum(v2) - tuple.sum(v1)));

        int num1Pointer = 0;
        int num2Pointer = 0;
        int nums2Length = Math.min(k, nums2.length);
        int nums1Length = Math.min(k, nums1.length);
        for (int i = 0; i < k; i++) {
            if (num2Pointer >= nums2.length || num1Pointer >= nums1.length) {
                break;
            }

            int num1 = nums1[num1Pointer];
            int num2 = nums2[num2Pointer];
            if (num1 <= num2) {
                for (int index = num2Pointer; index < nums2Length; index++) {
                    resultHeap.add(new tuple(num1, nums2[index]));
                    if (resultHeap.size() > k) {
                        resultHeap.remove();
                    }
                }
                num1Pointer++;
            }
            if (num1 > num2) {
                for (int index = num1Pointer; index < nums1Length; index++) {
                    resultHeap.add(new tuple(nums1[index], num2));
                    if (resultHeap.size() > k) {
                        resultHeap.remove();
                    }
                }
                num2Pointer++;
            }
        }

        return resultHeap.stream()
                .map(tuple -> List.of(tuple.value1, tuple.value2))
                .toList();
    }

    record tuple(int value1, int value2) {
        public static long sum(tuple tuple) {
            return tuple.value1 + tuple.value2;
        }
    }

}
