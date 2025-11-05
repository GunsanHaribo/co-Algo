package algorithm.leetCode_1.P7_DP.p2_Multi_dimensional.example.p1143_Longest_Common_Subsequence.t2025_11_04;

import java.util.Arrays;

public class p1143_Longest_Common_Subsequence {

  public static void main(String[] args) {
    p1143_Longest_Common_Subsequence solver = new p1143_Longest_Common_Subsequence();

//    String text1 = "abcde";
//    String text2 = "ace"; // 3
////
//    String text1 = "abc";
//    String text2 = "abc"; // 3

    // 210
//    String text1 = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
//    String text2 = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";

    //    // 같은게, 있으면 어떻게 해야되지?지
//    String text1 = "bsbininm";
//    String text2 = "jmjkbkjkv"; // 1

    String text1 = "pmjghexybyrgzczy";
    String text2 = "hafcdqbgncrcbihkd"; // 4

    System.out.println(solver.longestCommonSubsequence(text1, text2));
  }

  public int longestCommonSubsequence(String text1, String text2) {
    int text1Size = text1.length();
    int text2Size = text2.length();
    char[] text1CharArray = text1.toCharArray();
    char[] text2CharArray = text2.toCharArray();

    int[][] dp = new int[text1Size][text2Size];
    for (int y = 0; y < text1Size; y++) {
      for (int x = 0; x < text2Size; x++) {
        // 각 칸이 뭘 나타내는지 다시 해야됨
        // 이게, 이렇
        if (text1CharArray[y] == text2CharArray[x]) {
          if (validateBond(y - 1, x - 1, text1Size, text2Size)) {
            dp[y][x] = 1;
            continue;
          }
          dp[y][x] = 1 + dp[y - 1][x - 1];
        } else {
          int top = 0;
          if (y - 1 >= 0) {
            top = dp[y - 1][x];
          }
          int left = 0;
          if (x - 1 >= 0) {
            left = dp[y][x - 1];
          }
          dp[y][x] = Math.max(top, left);
        }
      }
    }

    for (int[] dd : dp) {
      System.out.println(Arrays.toString(dd));
    }
    return dp[text1Size - 1][text2Size - 1];
  }

  private boolean validateBond(int candidateY, int candidateX, int text1Size, int text2Size) {
    return candidateY >= text1Size || candidateX >= text2Size || candidateY < 0 || candidateX < 0;
  }

}
