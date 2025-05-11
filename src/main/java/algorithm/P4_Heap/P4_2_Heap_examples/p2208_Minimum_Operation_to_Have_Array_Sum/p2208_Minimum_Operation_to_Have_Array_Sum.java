package algorithm.P4_Heap.P4_2_Heap_examples.p2208_Minimum_Operation_to_Have_Array_Sum;

import java.util.PriorityQueue;

public class p2208_Minimum_Operation_to_Have_Array_Sum {
    public static void main(String[] args) {
//        int[] nums = {5, 19, 8, 1};
        int[] nums = {3, 8, 20};

        System.out.println(halveArray(nums));
    }

    public static int halveArray(int[] nums) {
        PriorityQueue<Double> heap = new PriorityQueue<>((v1, v2) -> Double.compare(v2, v1));
        for (int num : nums) {
            heap.add(num + 0.0);
        }

        double totalSum = heap.stream()
                .mapToDouble(Double::doubleValue)
                .sum()/2;

        int count = 0;
        while (totalSum > 0) {
            Double big = heap.poll();
            double half = big / 2;
            heap.add(half);
            totalSum -= half;

            count++;
        }


        return count;
    }

}
