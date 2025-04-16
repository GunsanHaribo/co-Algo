package algorithm.P3_Hashing.p3_Counting.p1189_Maximum_Number_of_Balloons;

import java.util.*;

public class p1189_Maximum_Number_of_Balloons {
    public static void main(String[] args) {
        String text = "ballon";
        int result = maxNumberOfBalloons(text);
        System.out.println(result);
    }

    public static int maxNumberOfBalloons(String text) {
        Map<Character, Integer> results = new HashMap<>();
        for (char letter : "balloon".toCharArray()) {
            results.put(letter, 0);
        }

        for (char letter : text.toCharArray()) {
            results.computeIfPresent(letter, (k, v) -> v + 1);
        }

        int numberOfOL = Math.min(results.get('o') / 2, results.get('l') / 2);

        Integer maybeMin = results.values()
                .stream()
                .min(Comparator.comparing(Integer::intValue))
                .get();

        return Math.min(numberOfOL, maybeMin);
    }
}
