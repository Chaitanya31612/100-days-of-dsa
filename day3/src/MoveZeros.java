import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MoveZeros {
    public static void moveZerosNaive(int[] nums) {
        int n = nums.length, countZeros = 0;
        ArrayList<Integer> list = new ArrayList<>(n);

        for(int num : nums) {
            if(num != 0)
                list.add(num);
            else
                countZeros++;
        }

        for(int i = 0; i < countZeros; i++)
            list.add(0);

        for(int i = 0; i < n; i++) {
            nums[i] = list.get(i);
        }
    }

    // without copy of array
    public static void moveZeros(int[] nums) {
        int n = nums.length;

        for(int i = 0; i < n; i++) {
            if(nums[i] == 0) {
                for(int j = i + 1; j < n; j++) {
                    if(nums[j] != 0) {
                        int temp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = temp;
                        break;
                    }
                }
            }
        }
    }

    public static void moveZerosFast(int[] nums) {
        int i = 0, j = 0;
        while(j < nums.length) {
            if(nums[j] != 0) {
                nums[i++] = nums[j];
            }
            j++;
        }
        while(i < nums.length) nums[i++] = 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];

        for(int i = 0; i < n; i++)
            nums[i] = sc.nextInt();

        moveZeros(nums);
        System.out.println(Arrays.toString(nums));
    }
}
