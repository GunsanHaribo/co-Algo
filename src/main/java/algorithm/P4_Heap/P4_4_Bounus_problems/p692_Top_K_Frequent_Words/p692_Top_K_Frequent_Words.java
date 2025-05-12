package algorithm.P4_Heap.P4_4_Bounus_problems.p692_Top_K_Frequent_Words;

import java.util.*;

public class p692_Top_K_Frequent_Words {

    public static void main(String[] args) {
        String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
        int k = 3;

        System.out.println(topKFrequent(words, k));
    }

    public static List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> countMap = new HashMap<>();
        for (String word : words) {
            countMap.put(word, countMap.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<String> heap = new PriorityQueue<>((v1, v2) -> {
            int sub = countMap.get(v1) - countMap.get(v2);
            if (sub == 0) {
                return v2.compareTo(v1);
            }

            return sub;
        });
        for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
            heap.add(entry.getKey());

            if (heap.size() > k) {
                heap.remove();
            }
        }

        return heap.stream()
                .sorted((v1, v2) -> {
                    int sub = countMap.get(v2) - countMap.get(v1);
                    if (sub == 0) {
                        return v1.compareTo(v2);
                    }

                    return sub;
                })
                .toList();
    }

}