package algorithm.leetCode_1.P3_Hashing.p5_Bonus_Problem.checking_for_existence.p1436_Destination_City;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class p1436_Destination_City {
    public static void main(String[] args) {
        List<List<String>> paths = new ArrayList<>();
        paths.add(List.of("London", "New York"));
        paths.add(List.of("New York", "Lima"));
        paths.add(List.of("Lima", "Sao Paulo"));

        System.out.println(destCity(paths));
    }

    public static String destCity(List<List<String>> paths) {
        Set<String> startSet = new HashSet<>();
        for (List<String> path : paths) {
            startSet.add(path.get(0));
        }
        Set<String> endSet = new HashSet<>();
        for (List<String> path : paths) {
            endSet.add(path.get(1));
        }

        for (String end : endSet) {
            if (!startSet.contains(end)) {
                return end;
            }
        }

        throw new IllegalArgumentException("dfd");
    }
}
