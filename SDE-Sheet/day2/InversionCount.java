package day2;

import java.util.*;

public class InversionCount {

  // time - O(n2)
  public static long countInversionBrute(long[] arr, long n) {
    int count = 0;

    for (int i = 0; i < (int) n; i++) {
      for (int j = i + 1; j < (int) n; j++) {
        if (arr[i] > arr[j])
          count++;
      }
    }

    return count;
  }

  // using merge sort technique
  // time - O(nlogn) space - O(n) [merge sort space]
  public static long inversionCount(long[] arr, long n) {
    int count = mergeSort(arr, 0, (int) (n - 1));
    return count;
  }

  public static int mergeSort(long[] arr, int s, int e) {
    int count = 0;
    if (s < e) {
      int mid = s + (e - s) / 2;
      count += mergeSort(arr, s, mid);
      count += mergeSort(arr, mid + 1, e);
      count += merge(arr, s, mid, e);
    }

    return count;
  }

  public static int merge(long[] arr, int s, int mid, int e) {
    long[] temp = new long[e - s + 1];

    int i = s, j = mid + 1, k = 0, count = 0;
    while (i <= mid && j <= e) {
      if (arr[i] <= arr[j]) {
        temp[k++] = arr[i++];
      } else {
        temp[k++] = arr[j++];
        count += mid - i + 1;
      }
    }

    while (i <= mid)
      temp[k++] = arr[i++];
    while (j <= e)
      temp[k++] = arr[j++];

    for (int t = 0; t < temp.length; t++) {
      arr[s + t] = temp[t];
    }

    return count;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    long[] arr = new long[n];

    for (int i = 0; i < n; i++)
      arr[i] = sc.nextLong();

    // System.out.println(countInversionBrute(arr, n));
    System.out.println(inversionCount(arr, n));
    sc.close();
  }
}
