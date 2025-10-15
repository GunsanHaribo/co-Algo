package algorithm.leetCode_1회독중.P7_DP.p2_d2.example.p1143_Longest_Common_Subsequence;

import java.util.Arrays;

public class p1143_Longest_Common_Subsequence {

  public static void main(String[] args) {
    p1143_Longest_Common_Subsequence solver = new p1143_Longest_Common_Subsequence();
//    String text1 = "abcde";
//    String text2 = "ace";
//    String text1 = "abc";
//    String text2 = "def";
//
//    String text1 = "abc";
//    String text2 = "abc";

//    String text1 = "bl";
//    String text2 = "yby";
    String text1 = "cccccccccccccccc";
    String text2 = "bbbbbbbbbbbbbbbb";

    int answer = solver.longestCommonSubsequence(text1, text2);
    System.out.println(answer);
  }

  int[][] memo;

  public int longestCommonSubsequence(String text1, String text2) {
    char[] text1s = text1.toCharArray();
    char[] text2s = text2.toCharArray();

    memo = new int[text1s.length][text2s.length];

    for (int[] m : memo) {
      Arrays.fill(m, -1);
    }

    return dp(text1s, text2s, 0, 0);
  }

  //  Map<Pair, Integer> memo = new HashMap<>();


  public int dp(char[] text1s, char[] text2s, int text1Pointer, int text2Pointer) {
    if (text1s.length <= text1Pointer || text2s.length <= text2Pointer) {
      return 0;
    }
    // 이미 다 계산 간거여도 0이여서 계산 했는지 안했는지 구분이 안되서 계속 도네
    if (memo[text1Pointer][text2Pointer] != -1) {
      return memo[text1Pointer][text2Pointer];
    }
    if (text1s[text1Pointer] == text2s[text2Pointer]) {
      int answer = dp(text1s, text2s, text1Pointer + 1, text2Pointer + 1) + 1;
      memo[text1Pointer][text2Pointer] = answer;
      return answer;
    }

    int answer = Math.max(
        dp(text1s, text2s, text1Pointer + 1, text2Pointer),
        dp(text1s, text2s, text1Pointer, text2Pointer + 1)
    );
    memo[text1Pointer][text2Pointer] = answer;
    return answer;
  }

  record Pair(int text1, int text2) {

  }

}
