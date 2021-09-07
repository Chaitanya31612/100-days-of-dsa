public class SearchInsertPosition {

    public static int searchInsert(int[] nums, int target) {
        int s = 0, e = nums.length - 1, mid;


        while(s <= e) {
            mid = s + (e - s) / 2;

            if(target == nums[mid]) {
                return mid;
            } else if(target > nums[mid]) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }

        return s;
    }
    public static void main(String[] args) {

        // find position of target if not present
        int[] nums = {1, 3, 5, 6};

        System.out.println(searchInsert(nums, 0));
    }
}
