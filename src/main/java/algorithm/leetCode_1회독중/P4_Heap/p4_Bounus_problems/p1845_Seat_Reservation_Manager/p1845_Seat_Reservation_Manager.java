package algorithm.leetCode_1회독중.P4_Heap.p4_Bounus_problems.p1845_Seat_Reservation_Manager;

import java.util.PriorityQueue;

public class p1845_Seat_Reservation_Manager {
    public static void main(String[] args) {
        p1845_Seat_Reservation_Manager manager = new p1845_Seat_Reservation_Manager(5);
        System.out.println(manager.reserve());
        System.out.println(manager.reserve());
        manager.unreserve(2);
        System.out.println(manager.reserve());
        System.out.println(manager.reserve());


    }

    private PriorityQueue<Integer> heap;
    private boolean[] reserveRecord;

    public p1845_Seat_Reservation_Manager(int n) {
        heap = new PriorityQueue<>();
        reserveRecord = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            heap.add(i);
        }
    }

    public int reserve() {
        Integer last = heap.poll();
        reserveRecord[last.intValue()] = false;

        return last;
    }

    public void unreserve(int seatNumber) {
        reserveRecord[seatNumber] = true;

        // 그리고 다시 넣는다.
        heap.add(seatNumber);
    }

}
