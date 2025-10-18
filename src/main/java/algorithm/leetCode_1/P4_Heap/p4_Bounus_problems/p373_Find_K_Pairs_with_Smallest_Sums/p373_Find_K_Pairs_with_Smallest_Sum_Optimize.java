package algorithm.leetCode_1.P4_Heap.p4_Bounus_problems.p373_Find_K_Pairs_with_Smallest_Sums;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class p373_Find_K_Pairs_with_Smallest_Sum_Optimize {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 4, 5, 6};
        int[] nums2 = {3, 5, 7, 9};
        int k = 20;

        System.out.println(kSmallestPairs(nums1, nums2, k).size());
    }

    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0 || k == 0) return result;

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
                (a, b) -> (nums1[a[0]] + nums2[a[1]]) - (nums1[b[0]] + nums2[b[1]])
        );

        for (int i = 0; i < Math.min(k, nums1.length); i++) {
            minHeap.add(new int[]{i, 0}); // nums1[i] + nums2[0]
        }

        while (k-- > 0 && !minHeap.isEmpty()) {
            int[] pairIndex = minHeap.poll();
            int i = pairIndex[0];
            int j = pairIndex[1];
            result.add(List.of(nums1[i], nums2[j]));

            if (j + 1 < nums2.length) {
                minHeap.add(new int[]{i, j + 1}); // 다음 가능한 쌍을 힙에 추가
            }
        }

        return result;
    }

}
