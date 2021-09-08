import java.util.Arrays;
import java.util.Scanner;

public class MergeSorted {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0, j = 0;

        while(i < m && j < n) {
            if(nums1[i] <= nums2[j]) {
                i++;
            } else {
                int temp = nums1[i];
                nums1[i] = nums2[j];
                nums2[j] = temp;

                int k = j;
                for(; k < n - 1; k++) {
                    if(nums2[k] > nums2[k+1]) {
                        temp = nums2[k];
                        nums2[k] = nums2[k + 1];
                        nums2[k + 1] = temp;
                    }
                }
            }
        }

        while(j < n) {
            nums1[i++] = nums2[j++];
        }
    }

    public static void mergeNaive(int[] nums1, int m, int[] nums2, int n) {
        int[] nums3 = new int[m + n];

        int i = 0, j = 0, k = 0;

        while(i < m && j < n) {
            if(nums1[i] <= nums2[j]) {
                nums3[k++] = nums1[i++];
            } else {
                nums3[k++] = nums2[j++];
            }
        }

        while(i < m) {
            nums3[k++] = nums1[i++];
        }

        while(j < n) {
            nums3[k++] = nums2[j++];
        }

        System.arraycopy(nums3, 0, nums1, 0, m + n);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();

        int[] nums1 = new int[m + n];
        int[] nums2 = new int[n];

        for(int i = 0; i < m; i++)
            nums1[i] = sc.nextInt();

        for(int j = 0; j < n; j++)
            nums2[j] = sc.nextInt();

//        mergeNaive(nums1, m, nums2, n);
        merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }
}
