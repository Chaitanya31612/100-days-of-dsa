package day2;

import java.util.*;

// https://leetcode.com/problems/rotate-image/discuss/1529662/Java-easy-solution-with-explanation-oror-0ms-100-faster

public class RotateImage {

  public static void rotate(int[][] matrix) {
    // given matrix will be square matrix
    int n = matrix.length;

    // first find the transpose of the matrix
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
      }
    }

    // reverse every row of the matrix
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n / 2; j++) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[i][n - j - 1];
        matrix[i][n - j - 1] = temp;
      }
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[][] matrix = new int[n][n];
    for (int i = 0; i < n; i++)
      for (int j = 0; j < n; j++)
        matrix[i][j] = sc.nextInt();

    rotate(matrix);

    for (int[] arr : matrix)
      System.out.println(Arrays.toString(arr));

    sc.close();
  }
}