package day1;

import java.util.*;

public class PascalTriangle {

  // Code for return list of all rows till numRows

  // the intuition behind this solution is that add the elements to previous
  // element starting from the end and add 1 to the temp array at the end. then
  // add the temp array into rowSet
  public static List<List<Integer>> generate(int numRows) {
    List<List<Integer>> rowSet = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();

    temp.add(1);

    for (int i = 0; i < numRows; i++) {
      rowSet.add(new ArrayList<>(temp));

      for (int j = temp.size() - 1; j >= 1; j--) {
        temp.set(j, temp.get(j) + temp.get(j - 1));
      }
      temp.add(temp.get(0));
    }

    return rowSet;
  }

  public static int nCr(int n, int r) {
    long res = 1;

    r = n - r < r ? n - r : r;
    for (int i = 0; i < r; i++) {
      res *= (n - i);
      res /= (i + 1);
    }

    return (int) res;
  }

  // Code for return pascal triangle entry for row r and column col
  // the logic is to find (r-1)C(c-1) where C is combinations
  // here suppose the row and column starting from 1
  public static int pascalTriangleValue(int r, int c) {
    return nCr(r - 1, c - 1);
  }

  public static List<Integer> getRow(int rowIndex) {
    List<Integer> list = new ArrayList<>();

    for (int i = 0; i < rowIndex + 1; i++) {
      list.add(nCr(rowIndex, i));
    }
    return list;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int numsRows = sc.nextInt();

    // System.out.println(generate(numsRows));

    // System.out.println(nCr(4, 2));
    System.out.println(getRow(numsRows));
    sc.close();
  }
}
