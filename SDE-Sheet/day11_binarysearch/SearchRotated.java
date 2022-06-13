package day11_binarysearch;

//https://leetcode.com/problems/search-in-rotated-sorted-array/discuss/1575072/Java-easy-solution-oror-Binary-Search-oror-Brute-and-optimal
public class SearchRotated {

    public int searchBrute(int[] nums, int target) {
        int pivot = -1;

        for(int i = 0; i < nums.length - 1; i++) {
            if(nums[i] > nums[i+1]) {
                pivot = i;
                break;
            }
        }

        if(pivot == -1) {
            return binarySearch(nums, 0, nums.length-1, target);
        }

        if(target >= nums[0] && target <= nums[pivot]) {
            return binarySearch(nums, 0, pivot, target);
        } else if(target >= nums[pivot+1] && target <= nums[nums.length-1]) {
            return binarySearch(nums, pivot+1, nums.length-1, target);
        }

        return -1;
    }

    public int binarySearch(int[] nums, int s, int e, int target) {
        if(s > e) return -1;

        int mid = (s + e) / 2;
        if(nums[mid] == target) {
            return mid;
        } else if(target < nums[mid]) {
            return binarySearch(nums, s, mid - 1, target);
        } else {
            return binarySearch(nums, mid + 1, e, target);
        }
    }

    // optimised
    public static int search(int[] nums, int target) {
        int l = 0, r = nums.length-1;
        while(l <= r) {
            int mid = (l + r) / 2;
            if(nums[mid] == target) {
                return mid;
            }

            // check if left array for mid is sorted
            if(nums[l] <= nums[mid]) {
                // if target lies in this range
                if(target >= nums[l] && target <= nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            // else right array from mid to end is sorted
            else {
                // if target lies in this range
                if(target >= nums[mid] && target <= nums[r]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {

    }
}


/*
* 0,1,2,4,5,6,7
* 4,5,6,7,0,1,2
* mid = target return
* l - 0, r - 6
* nums[l] <= nums[mid] // it means this array is sorted
* if(target >= nums[l] && <= mid
*   r = mid-1 // search in this array
* else
*   l = mid+1 // move to right one
*
* 1,2,3,4,5,6,7,8,9
* 7,8,9,1,2,3,4,5,6  target = 4
*
* */