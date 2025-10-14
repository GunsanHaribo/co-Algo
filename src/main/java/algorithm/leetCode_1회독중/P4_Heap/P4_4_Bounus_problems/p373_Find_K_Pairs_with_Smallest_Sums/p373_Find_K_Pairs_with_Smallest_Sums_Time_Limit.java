package algorithm.leetCode_1회독중.P4_Heap.P4_4_Bounus_problems.p373_Find_K_Pairs_with_Smallest_Sums;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class p373_Find_K_Pairs_with_Smallest_Sums_Time_Limit {
    public static void main(String[] args) {
//        int[] nums1 = {1, 7, 11};
//        int[] nums2 = {2, 4, 6};
//        int k = 3;
//

//        int[] nums1 = {1, 1, 2};
//        int[] nums2 = {1, 2, 3};
//        int k = 2;
        int[] nums1 = {1, 2, 4, 5, 6};
        int[] nums2 = {3, 5, 7, 9};
        int k = 20;

        System.out.println(kSmallestPairs(nums1, nums2, k).size());
    }

    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<List<Integer>> resultHeap = new PriorityQueue<>((v1, v2) -> (int) (sumList(v2) - sumList(v1)));

        int num1Pointer = 0;
        int num2Pointer = 0;
        int nums2LoopLength = Math.min(k, nums2.length);
        int nums1LoopLength = Math.min(k, nums1.length);
        for (int i = 0; i < k; i++) {
            if (num2Pointer >= nums2.length || num1Pointer >= nums1.length) {
                break;
            }

            int num1 = nums1[num1Pointer];
            int num2 = nums2[num2Pointer];
            if (num1 <= num2) {
                // TODO: 5/14/25 이렇게 나머지 숫자들을 너무 많이 돌았던게 문제
                for (int index = num2Pointer; index < nums2LoopLength; index++) {
                    resultHeap.add(List.of(num1, nums2[index]));
                    if (resultHeap.size() > k) {
                        resultHeap.remove();
                    }
                }
                num1Pointer++;
            }
            if (num1 > num2) {
                for (int index = num1Pointer; index < nums1LoopLength; index++) {
                    resultHeap.add(List.of(nums1[index], num2));
                    if (resultHeap.size() > k) {
                        resultHeap.remove();
                    }
                }
                num2Pointer++;
            }
        }

        return new ArrayList<>(resultHeap);
    }

    private static long sumList(List<Integer> list) {
        return list.get(0) + list.get(1);
    }

}
