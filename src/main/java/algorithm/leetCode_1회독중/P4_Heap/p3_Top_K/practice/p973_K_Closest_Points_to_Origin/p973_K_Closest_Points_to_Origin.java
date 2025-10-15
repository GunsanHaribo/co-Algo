package algorithm.leetCode_1회독중.P4_Heap.p3_Top_K.practice.p973_K_Closest_Points_to_Origin;

import java.util.Arrays;
import java.util.PriorityQueue;

public class p973_K_Closest_Points_to_Origin {
    public static void main(String[] args) {
        int[][] points = {{1, 3}, {-2, 2}};
        int k = 1;


        for (int[] answer : kClosest(points, k)) {
            System.out.println(Arrays.toString(answer));
        }

    }

    public static int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((v1, v2) -> calculatePowSum(v2) - calculatePowSum(v1));
        for (int[] point : points) {
            heap.add(point);

            if (heap.size() > k) {
                heap.remove();
            }
        }

        return heap.toArray(new int[k][]);
    }

    private static int calculatePowSum(int[] point) {
        return (int) (Math.pow(point[0], 2) + Math.pow(point[1], 2));
    }

}
