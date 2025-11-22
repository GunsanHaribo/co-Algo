package algorithm.leetCode_1.P8_Binary_Search.p1_on_arrays.example.p2300_Successful_Pairs_of_Spells_and_Potions;

import java.util.Arrays;

public class p2300_Successful_Pairs_of_Spells_and_Potions {

  public static void main(String[] args) {
    p2300_Successful_Pairs_of_Spells_and_Potions solver = new p2300_Successful_Pairs_of_Spells_and_Potions();
    int[] spells = {5, 1, 3};
    int[] potions = {1, 2, 3, 4, 5};
    int success = 7; //[4,0,3]

//    int[] spells = {3, 1, 2};
//    int[] potions = {8, 5, 8};
//    int success = 16; // 2,0,2

    System.out.println(Arrays.toString(solver.successfulPairs(spells, potions, success)));
  }

  public int[] successfulPairs(int[] spells, int[] potions, long success) {
    int[][] matrix = new int[spells.length][potions.length];
    Arrays.sort(potions);
    for (int y = 0; y < spells.length; y++) {
      for (int x = 0; x < potions.length; x++) {
        matrix[y][x] = spells[y] * potions[x];
      }
    }

    int[] answer = new int[spells.length];
    for (int i = 0; i < matrix.length; i++) {
      int left = 0;
      int right = matrix[i].length;
      int savedMid = 0;
      while (left < right) {
        int mid = left + (right - left) / 2;
        savedMid = mid;
        if (matrix[i][mid] < success) {
          left = mid + 1;
        } else {
          right = mid;
        }
      }
      answer[i] = Math.max(matrix[i].length - savedMid - 1, answer[i]);
    }

    return answer;
  }

}
