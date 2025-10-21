package algorithm.leetCode_1.P7_DP.p1_1D_problems.example.p2140_Solving_Questions_With_Brainpower.t2025_10_19;

public class p2140_Solving_Questions_With_Brainpower {

  public static void main(String[] args) {
    p2140_Solving_Questions_With_Brainpower solver = new p2140_Solving_Questions_With_Brainpower();
//    int[][] questions = {
//        {3, 2},
//        {4, 3},
//        {4, 4},
//        {2, 5}
//    };
//

    int[][] questions = {
        {1, 1},
        {2, 2},
        {3, 3},
        {4, 4},
        {5, 5}
    };

    System.out.println(solver.mostPoints(questions));
  }

  public long mostPoints(int[][] questions) {
    int n = questions.length;
    long[] dp = new long[n + 1];

    // 범위를 넘는 애들은 뭔가... 뭘 해줘야되는데,
    // ㅑ+1이든, 0이들어갈 곳을 만들어줘야함
    for (int i = n - 1; i > -1; i--) {
      int nextIndex = (questions[i][1] + i) + 1;
      if (nextIndex > n - 1) {
        nextIndex = n;
      }
      int pass = i + 1;
      if (pass > n - 1) {
        pass = n;
      }
      dp[i] = Math.max((long) questions[i][0] + dp[nextIndex], dp[pass]);
    }

    return dp[0];
  }

}
