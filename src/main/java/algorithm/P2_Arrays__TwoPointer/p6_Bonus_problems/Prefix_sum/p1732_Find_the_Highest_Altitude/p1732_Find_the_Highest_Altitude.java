package algorithm.P2_Arrays__TwoPointer.p6_Bonus_problems.Prefix_sum.p1732_Find_the_Highest_Altitude;

import java.util.Arrays;

public class p1732_Find_the_Highest_Altitude {
    public static void main(String[] args) {
        int[] gain = {-5, 1, 5, 0, -7};
        int result = largestAltitude(gain);
        System.out.println(result);
    }

    public static int largestAltitude(int[] gain) {
        int[] results = new int[gain.length+1];
        for (int i = 0; i < gain.length; i++) {
            results[i+1] += results[i] + gain[i];
        }

        return Arrays.stream(results)
                .max()
                .getAsInt();
    }
}
