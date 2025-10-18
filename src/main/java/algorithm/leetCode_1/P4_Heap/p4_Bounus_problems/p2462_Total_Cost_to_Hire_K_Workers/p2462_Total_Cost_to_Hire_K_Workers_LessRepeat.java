package algorithm.leetCode_1.P4_Heap.p4_Bounus_problems.p2462_Total_Cost_to_Hire_K_Workers;

import java.util.PriorityQueue;

public class p2462_Total_Cost_to_Hire_K_Workers_LessRepeat {
    public static void main(String[] args) {
        int[] costs = {19,29,88,2,5,24,60,26,76,24,96,82,97,97,72,35,21,77,82,30,94,55,76,94,51,82,3,89,52,96,72,27,59,57,97,6,46,88,41,52,46,4,17};
        int k = 1;
        int candidates = 3;

        System.out.println(totalCost(costs, k, candidates));
    }

    public static long totalCost(int[] costs, int k, int candidates) {
        boolean[] isUsedIndex = new boolean[costs.length];
        PriorityQueue<tuple> heap = new PriorityQueue<>((v1, v2) -> {
            int sub = v1.value - v2.value;
            if (sub == 0) {
                return v1.index - v2.index;
            }
            return sub;
        });
        // 초기 힙값설정 - 1,2,4,1
        int leftHeapPointer = candidates - 1;
        int rightHeapPointer = costs.length - candidates;
        for (int index = 0; index <= leftHeapPointer; index++) {
            if (isUsedIndex[index]) {
                continue;
            }
            heap.add(new tuple(index, costs[index]));
            isUsedIndex[index] = true;
        }
        for (int index = costs.length - 1; index >= rightHeapPointer; index--) {
            if (isUsedIndex[index]) {
                continue;
            }
            heap.add(new tuple(index, costs[index]));
            isUsedIndex[index] = true;
        }

        // k번 횟수
        long totalCost = 0;
        for (int i = 0; i < k; i++) {
            tuple leastOne = heap.poll();
            totalCost += leastOne.value;

            if (leastOne.index <= leftHeapPointer) {
                leftHeapPointer++;
                if (leftHeapPointer >= costs.length || isUsedIndex[leftHeapPointer]) {
                    continue;
                }

                heap.add(new tuple(leftHeapPointer, costs[leftHeapPointer]));
                isUsedIndex[leftHeapPointer] = true;
            }
            if (leastOne.index >= rightHeapPointer) {
                rightHeapPointer--;
                if (leftHeapPointer < 0 || isUsedIndex[rightHeapPointer]) {
                    continue;
                }
                heap.add(new tuple(rightHeapPointer, costs[rightHeapPointer]));
                isUsedIndex[rightHeapPointer] = true;
            }
        }

        return totalCost;
    }

    record tuple(int index, int value) {
    }
}
