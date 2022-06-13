package day1_arrays;

public class Sort012 {
    public void sortColors(int[] nums) {
        int[] count = new int[3];
        for(int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
        }

        int i = 0, c = 0;
        while(i < nums.length) {
            while(count[c] == 0) {
                c++;
            };
            nums[i++] = c;
            count[c]--;
        }
    }
}
