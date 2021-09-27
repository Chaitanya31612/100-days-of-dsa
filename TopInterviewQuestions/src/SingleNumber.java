import java.util.Scanner;

/* Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

You must implement a solution with a linear runtime complexity and use only constant extra space.*/
public class SingleNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++)
            nums[i] = sc.nextInt();

        // anything xor with 0 is itself
        int xor = 0;
        for(int i = 0; i < n; i++) {
            xor = xor ^ nums[i];
        }

        System.out.println(xor);
    }
}
