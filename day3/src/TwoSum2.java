import java.util.Arrays;
import java.util.Scanner;

public class TwoSum2 {

    public static int binarySearch(int[] nums, int key, int ind) {
        int s = 0, e = nums.length - 1;


        while(s <= e) {
            int mid = s + (e - s) / 2;

            if(nums[mid] == key && mid != ind) {
                return mid;
            } else if(key > nums[mid]) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }

        return -1;
    }

    public static int[] twoSum(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++) {
            int searchInd = binarySearch(nums, target - nums[i], i);
            if(searchInd != -1) {
                return new int[]{Math.min(i + 1, searchInd + 1), Math.max(i + 1, searchInd + 1)};
            }
        }

        return new int[]{};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];

        for(int i = 0; i < n; i++)
            nums[i] = sc.nextInt();

        int target = sc.nextInt();

        System.out.println(Arrays.toString(twoSum(nums, target)));
    }
}
