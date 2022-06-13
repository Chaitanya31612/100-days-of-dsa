package practice;

public class MaxLenSubPosSum {
    public static int getMaxLen(int[] nums) {
        long cprod = 1;
        int currlen = 0, maxlen = 0;
        for(int i = 0; i < nums.length; i++) {
            cprod *= nums[i];
            currlen++;
            if(cprod > 0) maxlen = Math.max(maxlen, currlen);
            System.out.print(nums[i] + " ");
            if(cprod == 0) {
                cprod = 1;
                System.out.println("->" + maxlen + "  " + currlen);
                currlen = 0;
            }
        }

        cprod = 1; currlen = 0;
        for(int i = nums.length-1; i >= 0; i--) {
            cprod *= nums[i];
            currlen++;
            if(cprod > 0) maxlen = Math.max(maxlen, currlen);
//            System.out.print(nums[i] + " ");
            if(cprod == 0) {
                cprod = 1;
                currlen = 0;
//                System.out.println();
            }
        }
        System.out.println();
        return maxlen;
    }

    public static void main(String[] args) {
        int[] nums = {70,-18,75,-72,-69,-84,64,-65,0,-82,62,54,-63,-85,53,-60,-59,29,32,59,-54,-29,-45,0,-10,22,42,-37,-16,0,-7,-76,-34,37,-10,2,-59,-24,85,45,-81,56,86};
        System.out.println(getMaxLen(nums));
    }
}
