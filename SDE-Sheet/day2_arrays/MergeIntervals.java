package day2_arrays;

import java.util.*;

// https://leetcode.com/problems/merge-intervals/discuss/1529743/Java-easy-solution-merge-intervals

public class MergeIntervals {

  public static int[][] merge(int[][] intervals) {
    ArrayList<int[]> list = new ArrayList<>();

    if (intervals.length == 0)
      return intervals;

    // sort the intervals array based on a[0] using comparator
    Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

    int s = intervals[0][0], e = intervals[0][1];

    for (int i = 1; i < intervals.length; i++) {
      if (e < intervals[i][0]) {
        list.add(new int[] { s, e });
        s = intervals[i][0];
        e = intervals[i][1];
      } else {
        e = Math.max(e, intervals[i][1]);
      }
    }
    list.add(new int[] { s, e });

    // one way to change list to array
    // int[][] ans = new int[list.size()][2];
    // for (int i = 0; i < list.size(); i++) {
    // ans[i][0] = list.get(i).get(0);
    // ans[i][1] = list.get(i).get(1);
    // }

    return list.toArray(new int[0][]);
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[][] intervals = new int[n][n];
    for (int i = 0; i < n; i++)
      for (int j = 0; j < 2; j++)
        intervals[i][j] = sc.nextInt();

    Arrays.toString(merge(intervals));
  }
}
