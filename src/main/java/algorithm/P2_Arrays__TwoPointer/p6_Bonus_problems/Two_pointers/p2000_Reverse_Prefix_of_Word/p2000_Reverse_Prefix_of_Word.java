package algorithm.P2_Arrays__TwoPointer.p6_Bonus_problems.Two_pointers.p2000_Reverse_Prefix_of_Word;

public class p2000_Reverse_Prefix_of_Word {
    public static void main(String[] args) {
        String input = "xyxzxe";
        char ch = 'z';
        String output = reversePrefix(input, ch);
        System.out.println(output);
    }

    public static String reversePrefix(String word, char ch) {
        int left = 0;

        char[] charArray = word.toCharArray();
        for (int right = 0; right < word.length(); right++) {
            if (ch == charArray[right]) {
                reverse(left, right, charArray);
                break;
            }
        }

        return new String(charArray);
    }

    private static char[] reverse(int left, int right, char[] charArray) {
        while (left < right) {
            char temp = charArray[left];
            charArray[left] = charArray[right];
            charArray[right] = temp;
            left++;
            right--;
        }
        return charArray;
    }
}
