package algorithm.leetCode_1.P4_Heap.p3_Top_K.example.p658_Find_K_Closest_Elements;

import java.util.*;

public class p658_Find_K_Closest_Elements {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        int k = 4;
        int x = 3;

        System.out.println(findClosestElements(arr, k, x));
    }

    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        // 만약에 같으면 수가 큰게 앞에 있어야되긴하네 (v2-v1)

        PriorityQueue<Integer> heap = new PriorityQueue<>((v1, v2) -> {
            int sub = Math.abs(v2 - x) - Math.abs(v1 - x);
            if (sub == 0) {
                return v2 - v1;
            }

            return sub;
        });

        for (int num : arr) {
            heap.add(num);

            if (heap.size() > k) {
                heap.remove();
            }
        }

        return heap.stream()
                .sorted(Comparator.comparing(Integer::intValue))
                .toList();
    }

}
