package day3_arrays;

public class SearchMatrix {
  public boolean searchMatrix(int[][] matrix, int target) {
    int m = matrix.length, n = matrix[0].length;
    int start = 0, end = m - 1;

    while (start <= end) {
      int mid = (start + end) / 2;
      if (target >= matrix[mid][0] && target <= matrix[mid][n - 1]) {
        int s = 0, e = n - 1;
        while (s <= e) {
          int md = (s + e) / 2;
          if (matrix[mid][md] == target)
            return true;
          else if (target < matrix[mid][md]) {
            e = md - 1;
          } else {
            s = md + 1;
          }
        }
        return false;
      } else if (target < matrix[mid][0]) {
        end = mid - 1;
      } else {
        start = mid + 1;
      }
    }

    return false;
  }

  public static void main(String[] args) {

  }
}
