package algorithm.P2_Arrays__TwoPointer.p6_Bonus_problems.Sliding_window.p1208_Get_Equal_Substrings_Within_Budget;

public class p1208_Get_Equal_Substrings_Within_Budget {
    public static void main(String[] args) {
        String s = "abcd";
        String t = "cdef";
        int maxCost = 3;
        int result = equalSubstring(s, t, maxCost);
        System.out.println(result);
    }

    public static int equalSubstring(String s, String t, int maxCost) {
        int left =0;
        int sum = 0;
        int maxSize = Integer.MIN_VALUE;

        char[] charArrayS = s.toCharArray();
        char[] charArrayT = t.toCharArray();
        for (int right = 0; right < t.length(); right++) {
            sum += Math.abs(charArrayS[right]- charArrayT[right]);
            while(maxCost < sum){
                sum -= Math.abs(charArrayS[left]- charArrayT[left]);
                left++;
            }
            maxSize = Math.max(maxSize, right - left + 1);
        }

        return maxSize;
    }
}
