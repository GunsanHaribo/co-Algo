package algorithm.leetCode_1회독중.P4_Heap.p3_Top_K.example.p347_Top_K_Frequent_Elements;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class p347_Top_K_Frequent_Elements {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3, 3,3};
        int k = 2;

        System.out.println(Arrays.toString(topKFrequent(nums, k)));
    }

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : nums) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>((v1, v2) -> counts.get(v1) - counts.get(v2));
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            heap.add(entry.getKey());

            if (heap.size() > k) {
                heap.remove();
            }
        }


        return heap
                .stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

}
