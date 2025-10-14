package algorithm.leetCode_1회독중.P4_Heap.P4_4_Bounus_problems.p2182_Construct_String_With_Repeat_Limit;

import java.util.*;

public class p2182_Construct_String_With_Repeat_Limit_TimeLimit {
    public static void main(String[] args) {
//        String s = "cczazcc";
//        int repeatLimit = 3;
        String s = "aababab";
        int repeatLimit = 2;


        System.out.println(repeatLimitedString(s, repeatLimit));
    }

    public static String repeatLimitedString(String s, int repeatLimit) {
        PriorityQueue<Character> heap = new PriorityQueue<>((v1, v2) -> v2.compareTo(v1));
        for (char c : s.toCharArray()) {
            heap.add(c);
        }

        // 다 좋은데 빼는게 조금 힘듬
        int left = 0;
        StringBuilder sb = new StringBuilder();
        for (int right = 0; right < s.length(); right++) {
            // 요소 추가
            Character now = heap.poll();
            sb.append(now);
            if (sb.charAt(left) != now) {
                left = right;
            }

            // 리미트를 토과할경우
            if ((right - left + 1) > repeatLimit) {
                sb.deleteCharAt(right);

                // 다른 char가 나올떄까지 뽑습니다.
                List<Character> temp = new ArrayList<>();
                Character tempChar = now;
                // TODO: 5/13/25 여기서 터질 것 같은데, 포인트가 뭐지? 일단위에서 NlogN + N *NlogN아...
                while (sb.charAt(left) == tempChar) {
                    temp.add(tempChar);
                    tempChar = heap.poll();
                    if (tempChar == null) {
                        return sb.toString();
                    }
                }
                sb.append(tempChar); // 다른거 나올경우, left=right
                left = right;

                heap.addAll(temp);
            }
        }

        return sb.toString();
    }

}
