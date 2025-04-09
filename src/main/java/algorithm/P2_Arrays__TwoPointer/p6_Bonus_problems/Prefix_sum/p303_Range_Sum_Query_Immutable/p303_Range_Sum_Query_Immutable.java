package algorithm.P2_Arrays__TwoPointer.p6_Bonus_problems.Prefix_sum.p303_Range_Sum_Query_Immutable;

import java.util.Arrays;

public class p303_Range_Sum_Query_Immutable {
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
