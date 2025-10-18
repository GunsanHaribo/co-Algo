package algorithm.leetCode_1.P4_Heap.p2_Heap_examples.example.p295_Find_Median_from_Data_Stream;

import java.util.PriorityQueue;

public class p295_Find_Median_from_Data_Stream {
    public static void main(String[] args) {
//        int[] nums = {1, 2};
//        int[] nums2 = {1, 2, 3};

        p295_Find_Median_from_Data_Stream dd = new p295_Find_Median_from_Data_Stream();
        dd.addNum(7);
        dd.addNum(5);
        dd.addNum(2);
        dd.addNum(1);
        dd.addNum(10);
        dd.addNum(100);
//        dd.addNum(3);

//        dd.addNum(-1);
//        dd.addNum(-2);
//        dd.addNum(-3);

        System.out.println(dd.findMedian());
    }

    private PriorityQueue<Double> leftMaxHeap;
    private PriorityQueue<Double> rightMinHeap;

    public p295_Find_Median_from_Data_Stream() {
        this.leftMaxHeap = new PriorityQueue<>((v1, v2) -> Double.compare(v2, v1));
        this.rightMinHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        // 둘다 비었을때는 왼쪽부터
        if (leftMaxHeap.isEmpty() && rightMinHeap.isEmpty()) {
            leftMaxHeap.add(num + 0.0);
            return;
        }

        // 오른쪽보다 큰수이면 오른쪽에
        if ((rightMinHeap.peek() != null && num >= rightMinHeap.peek())) {
            rightMinHeap.add(num + 0.0);
            replaceQueue();
            return;
        }

        // 오른쪽이 없거나 오른쪽이 비었으면 왼쪽에
        if (rightMinHeap.peek() == null || leftMaxHeap.peek() != null && num < rightMinHeap.peek()) {
            leftMaxHeap.add(num + 0.0);
            replaceQueue();
        }
    }

    private void replaceQueue() {
        if (leftMaxHeap.size() > rightMinHeap.size() + 1) {
            rightMinHeap.add(leftMaxHeap.poll());
            return;
        }
        if (leftMaxHeap.size() < rightMinHeap.size()) {
            leftMaxHeap.add(rightMinHeap.poll());
        }
    }

    public double findMedian() {
        System.out.println(leftMaxHeap);
        System.out.println(rightMinHeap);
        // 홀수
        int halfQuarter = (leftMaxHeap.size() + rightMinHeap.size()) % 2;
        if (halfQuarter == 1) {
            return leftMaxHeap.peek();
        }

        // 짝수
        return (leftMaxHeap.peek() + rightMinHeap.peek() + 0.0) / 2;
    }
}
