package algorithm.leetCode_1.P4_Heap.p4_Bounus_problems.p2182_Construct_String_With_Repeat_Limit;

import java.util.*;

public class p2182_Construct_String_With_Repeat_Limit_Optimize {
    public static void main(String[] args) {
//        String s = "aababab";
//        int repeatLimit = 2;

        String s = "cczazcc";
        int repeatLimit = 3;

        System.out.println(repeatLimitedString(s, repeatLimit));
    }

    public static String repeatLimitedString(String s, int repeatLimit) {
        Map<Character, Integer> charMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            charMap.put(c, charMap.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Map.Entry<Character, Integer>> heap = new PriorityQueue<>((v1, v2) -> v2.getKey().compareTo(v1.getKey()));
        heap.addAll(charMap.entrySet());

        StringBuilder result = new StringBuilder();
        while (heap.size() >= 1) {
            Map.Entry<Character, Integer> big = heap.poll();
            int min = Math.min(repeatLimit, big.getValue());
            result.append(String.valueOf(big.getKey()).repeat(min));

            int left = big.getValue() - min;
            if (left > 0) {
                Map.Entry<Character, Integer> secondBig = heap.poll();
                if (secondBig == null) {
                    return result.toString();
                }

                // 일단, heap에 카운트가 0인 것은 없다.
                int secondBigLeft = secondBig.getValue() - 1;
                result.append(secondBig.getKey());
                if (secondBigLeft > 0) {
                    secondBig.setValue(secondBigLeft);
                    heap.add(secondBig);
                }

                big.setValue(left);
                heap.add(big); // 여기서는 logN  -> 총합 NlogN, 남아있다면 다시 넣어준다
            }
        }

        return result.toString();
    }

}
