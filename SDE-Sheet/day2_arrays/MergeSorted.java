package day2_arrays;

// merge sorted arrays without extra space
public class MergeSorted {
  public void merge(int[] nums1, int m, int[] nums2, int n) {
    int i = 0, j = 0;

    while (i < m && j < n) {
      if (nums1[i] <= nums2[j]) {
        i++;
      } else {
        int temp = nums1[i];
        nums1[i] = nums2[j];
        nums2[j] = temp;

        // sort the nums2 array by placing the swaped at correct index
        for (int k = j; k < n - 1; k++) {
          if (nums2[k] > nums2[k + 1]) {
            temp = nums2[k];
            nums2[k] = nums2[k + 1];
            nums2[k + 1] = temp;
          }
        }
      }
    }

    while (j < n) {
      nums1[m + j] = nums2[j];
      j++;
    }
  }

  public static void main(String[] args) {

  }
}
