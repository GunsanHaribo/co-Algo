package algorithm.P4_Heap.P4_4_Bounus_problems.p2182_Construct_String_With_Repeat_Limit;

import java.util.*;

public class p2182_Construct_String_With_Repeat_Limit {
    public static void main(String[] args) {
        String s = "cczazcc";
        int repeatLimit = 3;

        System.out.println(repeatLimitedString(s, repeatLimit));
    }

    public static String repeatLimitedString(String s, int repeatLimit) {
        // 큰수부터 빠지게
        PriorityQueue<Character> heap = new PriorityQueue<>((v1, v2) -> v2.compareTo(v1));
        for (char c : s.toCharArray()) {
            heap.add(c);
        }

        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            // 마지막 요소와 현재요소가 같은지 비교
            Character newChar = heap.poll();
            if (sb.length() > 1) {
                if (!newChar.equals(sb.charAt(sb.length() - 1))) {
                    count = 0;
                }
            }
            sb.append(newChar);
            count++;

            // 만약에 limit에 도착했다면
            if (count == repeatLimit) {
                // 다른거 찾아야한다.
                // 같은 거 다 뽑아서 넣기
                List<Character> tmpChar = new ArrayList<>();
                Character other = newChar;
                while (newChar.equals(other)) {
                    // 아 이거 다른거 뽑을 수도 있네...
                    // 아 이게 싫은데...
                    other = heap.poll();
                    tmpChar.add(other);
                }
                // 없으면
                if(heap.isEmpty()){
                    return sb.toString();
                }
                // 남아있는게 있으면
//                sb.append()

            }


        }

        return sb.toString();
    }

}
