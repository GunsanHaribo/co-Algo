package algorithm.leetCode_1.P8_Binary_Search.p1_on_arrays.example.p74_Search_a_2D_Matrix;

import java.util.Arrays;

public class p74_Search_a_2D_Matrix {

  public static void main(String[] args) {
    p74_Search_a_2D_Matrix solver = new p74_Search_a_2D_Matrix();
    int[][] matrix = {
        {1, 3, 5, 7},
        {10, 11, 16, 20},
        {23, 30, 34, 60}
    };
    int target = 3; // true

//    int[][] matrix = {
//        {1, 3, 5, 7},
//        {10, 11, 16, 20},
//        {23, 30, 34, 60}
//    };
//    int target = 13; // false

    System.out.println(solver.searchMatrix(matrix, target));
  }


  public boolean searchMatrix(int[][] matrix, int target) {
    int m = matrix.length;
    int n = matrix[0].length;

    int[] flatMatrix = new int[m * n];
    int count = 0;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        flatMatrix[count++] = matrix[i][j];
      }
    }

    int left = 0;
    int right = flatMatrix.length - 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (flatMatrix[mid] == target) {
        return true;
      }
      if (flatMatrix[mid] < target) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }

    return false;
  }

}
