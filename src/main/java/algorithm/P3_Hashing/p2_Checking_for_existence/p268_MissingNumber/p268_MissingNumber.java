package algorithm.P3_Hashing.p2_Checking_for_existence.p268_MissingNumber;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class p268_MissingNumber {
    public static void main(String[] args) {
        int[] nums = {0, 1};
        int result = missingNumber(nums);
        System.out.println(result);
    }

    public static int missingNumber(int[] nums) {
        Set<Integer> numbers = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.toSet());

        for (int i = 0; i <= nums.length; i++) {
            if (!numbers.contains(i)) {
                return i;
            }
        }

        return -1;
    }
}
