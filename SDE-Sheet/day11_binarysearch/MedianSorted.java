package day11_binarysearch;

public class MedianSorted {
    public double findMedianSortedArraysBrute(int[] nums1, int[] nums2) {
        int[] nums3 = mergeSorted(nums1, nums2);

        int mid = nums3.length/2;
        if(nums3.length % 2 == 1) {
            return nums3[mid];
        } else {
            return (nums3[mid-1] + nums3[mid]) / 2.0;
        }
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

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        if(n2 < n1) return findMedianSortedArrays(nums2, nums1);
        int low = 0, high = n1; // overhere n2 > n1;

        while(low <= high) {
            int part1 = (low+high) / 2;
            int part2 = (n1+n2+1)/2 - part1;

            int l1 = part1-1 < 0 ? Integer.MIN_VALUE : nums1[part1-1];
            int l2 = part2-1 < 0 ? Integer.MIN_VALUE : nums2[part2-1];
            int r1 = part1 == n1 ? Integer.MAX_VALUE : nums1[part1];
            int r2 = part2 == n2 ? Integer.MAX_VALUE : nums2[part2];

            // this is our correct partition
            if(l1 <= r2 && l2 <= r1) {
                // size is even
                if(((n1+n2)&1) == 0) {
                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                } else {
                    return Math.max(l1, l2);
                }
            } else if(l1 > r2) {
                high = part1 - 1;
            } else {
                low = part1 + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

    }
}
