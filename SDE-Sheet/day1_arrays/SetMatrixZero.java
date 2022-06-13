package day1_arrays;

import java.util.*;

// https://leetcode.com/problems/set-matrix-zeroes/discuss/1528048/Java-Solution-using-Pair

public class SetMatrixZero {

  static class Pair {
    int first;
    int second;

    Pair(int first, int second) {
      this.first = first;
      this.second = second;
    }
  }

  // time - O(m * n) space - O(number of zeros)
  public static void setZeroesBrute(int[][] matrix) {
    ArrayList<Pair> list = new ArrayList<>();
    int m = matrix.length;
    int n = matrix[0].length;

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (matrix[i][j] == 0) {
          list.add(new Pair(i, j));
        }
      }
    }
    for (Pair e : list) {
      // set column as 0
      for (int i = 0; i < m; i++) {
        matrix[i][e.second] = 0;
      }
      // set rows as 0
      for (int j = 0; j < n; j++) {
        matrix[e.first][j] = 0;
      }
    }
  }

  // this approach can work when input matrix is positive
  public static void setZerosBrute2(int[][] matrix) {
    int m = matrix.length;
    int n = matrix[0].length;

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (matrix[i][j] == 0) {
          for (int k = 0; k < m; k++) {
            if (matrix[k][j] != 0)
              matrix[k][j] = -1;
          }
          for (int k = 0; k < n; k++) {
            if (matrix[i][k] != 0)
              matrix[i][k] = -1;
          }
        }
      }
    }

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (matrix[i][j] == -1)
          matrix[i][j] = 0;
      }
    }
  }

  // optimal, time - O(2*(m*n)) space - O(1)
  // the logic is to use the first row and first column as dummny array for
  // storing whether the corresponding row/column will be zero
  public static void setZerosOptimal(int[][] matrix) {
    int m = matrix.length;
    int n = matrix[0].length;

    // col0 is used to represent the value at [0][0]
    int col0 = 1;

    for (int i = 0; i < m; i++) {
      if (matrix[i][0] == 0)
        col0 = 0;
      for (int j = 1; j < n; j++) {
        if (matrix[i][j] == 0) {
          matrix[0][j] = matrix[i][0] = 0;
        }
      }
    }

    // now iterate from the back so that the index [0][0] is addressed at the last
    for (int i = m - 1; i >= 0; i--) {
      for (int j = n - 1; j >= 1; j--) {
        if (matrix[i][0] == 0 || matrix[0][j] == 0) {
          matrix[i][j] = 0;
        }
      }
      if (col0 == 0)
        matrix[i][0] = 0;
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int m = sc.nextInt();
    int n = sc.nextInt();
    int[][] matrix = new int[m][n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        matrix[i][j] = sc.nextInt();
      }
    }

    // setZeroesBrute(matrix);
    // setZerosBrute2(matrix);
    setZerosOptimal(matrix);
    for (int[] arr : matrix)
      System.out.println(Arrays.toString(arr));

    sc.close();
  }
}