package algorithm.leetCode_1회독중.P4_Heap.p4_Bounus_problems.p2336_Smallest_Number_in_Infinite_Set;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class p2336_Smallest_Number_in_Infinite_Set {
    public static void main(String[] args) {
        p2336_Smallest_Number_in_Infinite_Set pppppp = new p2336_Smallest_Number_in_Infinite_Set();
        pppppp.addBack(2);
    }

    private Set<Integer> alreayOut = new HashSet<>();
    private PriorityQueue<Integer> heap = new PriorityQueue<>();

    public p2336_Smallest_Number_in_Infinite_Set() {
        for (int i = 1; i <= 1000; i++) {
            heap.add(i);
        }
    }

    public int popSmallest() {
        Integer poll = heap.poll();
        alreayOut.add(poll);
        return poll;
    }

    public void addBack(int num) {
        if (!alreayOut.contains(num)) {
            return;
        }

        heap.add(num);
        alreayOut.remove(num);
    }
}
