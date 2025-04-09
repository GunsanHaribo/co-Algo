package algorithm.P2_Arrays__TwoPointer.p6_Bonus_problems.Two_pointers.p917_Reverse_Only_Letters;

public class p917_Reverse_Only_Letters {
    public static void main(String[] args) {
        String input = "a-bC-dEf-ghIj";
        String output = reverseOnlyLetters(input);
        System.out.println(output);
    }

    public static String reverseOnlyLetters(String s) {
        int left = 0;
        int right = s.length() - 1;
        char[] charArray = s.toCharArray();

        while (left < right) {
            if (!isLetter(charArray[left])) {
                left++;
                continue;
            }
            if (!isLetter(charArray[right])) {
                right--;
                continue;
            }
            char temp = charArray[left];
            charArray[left] = charArray[right];
            charArray[right] = temp;
            left++;
            right--;
        }


        return new String(charArray);
    }

    private static boolean isLetter(char c) {
        return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z');
    }
}
