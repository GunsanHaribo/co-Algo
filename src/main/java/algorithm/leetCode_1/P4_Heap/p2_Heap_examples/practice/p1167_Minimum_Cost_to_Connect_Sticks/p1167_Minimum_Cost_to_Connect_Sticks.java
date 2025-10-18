package algorithm.leetCode_1.P4_Heap.p2_Heap_examples.practice.p1167_Minimum_Cost_to_Connect_Sticks;

import java.util.PriorityQueue;

public class p1167_Minimum_Cost_to_Connect_Sticks {
    public static void main(String[] args) {
//        int[] sticks = {1,8,3,5};
//        int[] sticks = {2,4,3};
        int[] sticks = {5};

        System.out.println(connectSticks(sticks));
    }

    public static int connectSticks(int[] sticks) {
        if (sticks.length == 1) {
            return 0;
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int stick : sticks) {
            heap.add(stick);
        }

        int cost = 0;
        while (heap.size() > 1) {
            int firstMin = heap.poll();
            int secondMin = heap.poll();

            cost += firstMin + secondMin;
            heap.add(firstMin + secondMin);
        }

        return cost;
    }
}
