import java.util.Scanner;

public class MinSwaps {

    public static int minSwaps(int nums[]) {
        int n = nums.length;
        int[][] graph = new int[n][n];

        for(int i = 0; i < n; i++) {
            int count = 0;
            for(int c = 0; c < n; c++) {
                if(nums[c] < nums[i])
                    count++;
            }
            if(i != count)
                graph[i][count] = 1;
        }

        int ans = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(graph[i][j] == 1 && graph[j][i] == 1) {
                    ans++;
                }
            }
        }

        return ans / 2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++)
            nums[i] = sc.nextInt();

        System.out.println(minSwaps(nums));
    }
}
