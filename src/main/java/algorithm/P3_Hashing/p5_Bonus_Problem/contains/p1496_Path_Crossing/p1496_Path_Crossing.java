package algorithm.P3_Hashing.p5_Bonus_Problem.contains.p1496_Path_Crossing;

import java.util.HashSet;
import java.util.Set;

public class p1496_Path_Crossing {
    public static void main(String[] args) {
        String path = "NESWW";

        System.out.println(isPathCrossing(path));
    }

    public static boolean isPathCrossing(String path) {
        int[] start = {0, 0};
        // N, S, E, W
        int[][] dydx = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};


        int dx = 0;
        int dy = 0;
        Set<String> set = new HashSet<>();
        set.add(start[0] + "," + start[1]);
        for (char p : path.toCharArray()) {
            if (p == 'N') {
                dy = dydx[0][0];
                dx = dydx[0][1];
            }
            if (p == 'S') {
                dy = dydx[1][0];
                dx = dydx[1][1];
            }
            if (p == 'E') {
                dy = dydx[2][0];
                dx = dydx[2][1];
            }
            if (p == 'W') {
                dy = dydx[3][0];
                dx = dydx[3][1];
            }

            start[0] += dy;
            start[1] += dx;

            if (set.contains(start[0] + "," + start[1])) {
                return true;
            }
            set.add(start[0] + "," + start[1]);
        }

        return false;
    }
}
