package algorithm.P4_Heap.P4_2_Heap_examples.p1046_Last_Stone_Weight;

import java.util.PriorityQueue;

public class p1046_Last_Stone_Weight {
    public static void main(String[] args) {
//        int[] stones = {2, 7, 4, 1, 8, 1};
        int[] stones = {1};

        System.out.println(lastStoneWeight(stones));
    }

    public static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((v1, v2) -> v2 - v1);
        for (int stone : stones) {
            heap.add(stone);
        }

        while (heap.size() > 1) {
            Integer y = heap.poll();
            Integer x = heap.poll();

            if (x == y) {
                continue;
            }
            if (x <= y) {
                y = y - x;
                heap.add(y);
            }
        }

        if(heap.isEmpty()){
            return 0;
        }

        return heap.poll();
    }
}
