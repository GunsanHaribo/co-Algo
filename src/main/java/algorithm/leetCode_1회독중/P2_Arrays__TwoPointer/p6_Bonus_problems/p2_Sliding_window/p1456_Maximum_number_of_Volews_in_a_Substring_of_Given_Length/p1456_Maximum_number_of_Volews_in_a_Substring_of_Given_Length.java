package algorithm.leetCode_1회독중.P2_Arrays__TwoPointer.p6_Bonus_problems.p2_Sliding_window.p1456_Maximum_number_of_Volews_in_a_Substring_of_Given_Length;

public class p1456_Maximum_number_of_Volews_in_a_Substring_of_Given_Length {
    public static void main(String[] args) {
        String input = "abciiidef";
        int k = 3;
        System.out.println(maxVowels(input, k));
    }

    public static int maxVowels(String s, int k) {
        int sum = 0;
        char[] charArray = s.toCharArray();
        for (int i = 0; i < k; i++) {
            if (isVowel(charArray[i])) {
                sum++;
            }
        }

        int max = sum;

        int left = 0;
        for(int right = k; right<s.length(); right++){
            if (isVowel(charArray[right])) {
                sum++;
            }
            if (isVowel(charArray[left])){
                sum--;
            }
            max = Math.max(sum, max);
            left++;
        }


        return max;
    }

    public static boolean isVowel(char s) {
        return s == 'a' || s == 'e' || s == 'i' || s == 'o' || s == 'u';
    }
}
