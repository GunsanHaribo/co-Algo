package algorithm.leetCode_1회독중.P3_Hashing.p2_Checking_for_existence.p1426_Counting_Elements;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class p1426_Counting_Elements {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        int result = countElements(nums);
        System.out.println(result);


        int[] nums2 = {1,1,3,3,5,5,7,7};
        int result2 = countElements(nums2);
        System.out.println(result2);

        int[] nums3 = {1,1,2,3};
        int result3 = countElements(nums3);
        System.out.println(result3);
    }


    public static int countElements(int[] arr) {
        Set<Integer> numbers = Arrays.stream(arr)
                .boxed()
                .collect(Collectors.toSet());

        int count = 0;
        for (int element : arr) {
            if (numbers.contains(element+1)) {
                count++;
            }
        }

        return count;
    }
}
