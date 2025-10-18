package algorithm.leetCode_1.P4_Heap.p2_Heap_examples.practice.p1962_Remove_Stones_to_Minimize_the_Total;

import java.util.Comparator;
import java.util.PriorityQueue;

public class p1962_Remove_Stones_to_Minimize_the_Total {
    public static void main(String[] args) {
        int[] piles = {4,3,6,7};
        int k = 3;

        System.out.println(minStoneSum(piles, k));
    }

    public static int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());
        int sum = 0;
        for (int stones : piles) {
            sum += stones;
            heap.add(stones);
        }

        for (int i = 0; i < k; i++) {
            int max = heap.poll();
            int minus = (int) (double) (max / 2);
            max -= minus;
            heap.add(max);

            sum -= minus;
        }

        return sum;
    }

}
