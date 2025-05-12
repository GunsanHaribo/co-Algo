package algorithm.P4_Heap.P4_4_Bounus_problems.p2462_Total_Cost_to_Hire_K_Workers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class p2462_Total_Cost_to_Hire_K_Workers {

    public static void main(String[] args) {
        int[] costs = {1,2,4,1};
        int k = 3;
        int candidates = 3;

        System.out.println(totalCost(costs, k, candidates));
    }

    public static long totalCost(int[] costs, int k, int candidates) {
        List<Integer> costList = new ArrayList<>(Arrays.stream(costs)
                .boxed()
                .toList());

        PriorityQueue<tuple> heap = new PriorityQueue<>((v1, v2) -> {
            int sub = v2.value - v1.value;
            if (sub == 0) {
                return v2.index - v1.index;
            }
            return sub;
        });

        int total = 0;
        for (int i = 0; i < k; i++) {
            if (costList.size() < candidates) {
                tuple poll = getLeastCostLessCandidate(costList, heap);
                costList.remove(poll.index);
                total += poll.value;
                continue;
            }

            tuple poll = getLeastCost(candidates, costList, heap);
            costList.remove(poll.index);
            total += poll.value;
        }

        return total;
    }

    private static tuple getLeastCost(int candidates, List<Integer> costList, PriorityQueue<tuple> heap) {
        for (int index = 0; index < candidates; index++) {
            heap.add(new tuple(index, costList.get(index)));
            if (heap.size() > 1) {
                heap.remove();
            }
        }
        for (int index = costList.size() - 1; index > costList.size() - 1 - candidates; index--) {
            heap.add(new tuple(index, costList.get(index)));
            if (heap.size() > 1) {
                heap.remove();
            }
        }

        return heap.poll();
    }

    private static tuple getLeastCostLessCandidate(List<Integer> costList, PriorityQueue<tuple> heap) {
        for (int index = 0; index < costList.size(); index++) {
            heap.add(new tuple(index, costList.get(index)));
            if (heap.size() > 1) {
                heap.remove();
            }
        }

        return heap.poll();
    }

    record tuple(int index, int value) {
    }
}
