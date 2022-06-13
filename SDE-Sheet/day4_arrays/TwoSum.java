package day4_arrays;

import java.util.*;

public class TwoSum {
    public static int[] twoSumBrute(int[] nums, int target) {
        int[] ans = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i != j && nums[i] + nums[j] == target) {
                    ans[0] = i;
                    ans[1] = j;
                    return ans;
                }
            }
        }
        return ans;
    }

    // this won't work because after sorting the indices are changed
    public static int[] twoSumBetter(int[] nums, int target) {
        Arrays.sort(nums);

        int[] ans = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int el = nums[i];
            int findIdx = binarySearch(nums, target - el, i);
            System.out.println(el + " " + findIdx);
            if (findIdx != -1) {
                ans[0] = i;
                ans[1] = findIdx;
                break;
            }
        }
        return ans;
    }

    public static int binarySearch(int[] nums, int target, int i) {
        int s = 0, e = nums.length - 1;

        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (nums[mid] == target && mid != i) {
                return mid;
            }
            if (mid == target && mid == i) {
                if (mid - 1 >= s && nums[mid - 1] == target)
                    return mid - 1;
                if (mid + 1 <= e && nums[mid + 1] == target)
                    return mid + 1;
            } else if (target < nums[mid]) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }

        return -1;
    }

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], new ArrayList<>());
            }
            map.get(nums[i]).add(i);
            map.put(nums[i], map.get(nums[i]));
        }

        System.out.println(map);
        int[] ans = new int[2];
        for (Map.Entry<Integer, ArrayList<Integer>> entry : map.entrySet()) {
            if (map.containsKey(target - entry.getKey())) {
                if (entry.getKey() == target - entry.getKey()) {
                    if (map.get(entry.getKey()).size() >= 2) {
                        ans[0] = map.get(entry.getKey()).get(0);
                        ans[1] = map.get(entry.getKey()).get(1);
                        return ans;
                    }
                } else {
                    ans[0] = map.get(entry.getKey()).get(0);
                    ans[1] = map.get(target - entry.getKey()).get(0);
                    return ans;
                }

            }
        }
        return ans;
    }

    public static int[] twoSumBest(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int[] ans = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(target - nums[i])) {
                map.put(nums[i], i);
            } else {
                ans[0] = i;
                ans[1] = map.get(nums[i]);
                break;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int target = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++)
            nums[i] = sc.nextInt();

        // System.out.println(Arrays.toString(twoSumBetter(nums, target)));
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }
}
