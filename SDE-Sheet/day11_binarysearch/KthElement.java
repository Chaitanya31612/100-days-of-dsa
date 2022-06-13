package day11_binarysearch;

public class KthElement {

    public long kthElementBrute( int arr1[], int arr2[], int n, int m, int k) {

        int[] arr3 = mergeSorted(arr1, arr2);
        return arr3[k-1];
    }

    public int[] mergeSorted(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        int[] nums3 = new int[n1 + n2];

        int i = 0, j = 0, k = 0;
        while(i < n1 && j < n2) {
            if(nums1[i] <= nums2[j]) {
                nums3[k++] = nums1[i++];
            } else {
                nums3[k++] = nums2[j++];
            }
        }

        while(i < n1) {
            nums3[k++] = nums1[i++];
        }

        while(j < n2) {
            nums3[k++] = nums2[j++];
        }

        return nums3;
    }

    // optimised
    public long kthElement( int arr1[], int arr2[], int n, int m, int k) {

        return mergeSorted(arr1, arr2, k);
    }

    public long mergeSorted(int[] nums1, int[] nums2, int K) {
        int n1 = nums1.length, n2 = nums2.length;
        int[] nums3 = new int[n1 + n2];

        int i = 0, j = 0, k = 0;
        long element = 0;
        while(i < n1 && j < n2 && k < K) {
            if(nums1[i] <= nums2[j]) {
                element = nums1[i++];
            } else {
                element = nums2[j++];
            }
            k++;
        }

        while(i < n1 && k < K) {
            element = nums1[i++];
            k++;
        }

        while(j < n2 && k < K) {
            element = nums2[j++];
            k++;
        }

        return element;
    }

    public static void main(String[] args) {

    }
}
