import java.util.Scanner;

public class Celebrity {

    public static int celebrity(int[][] M, int n) {
        for(int j = 0; j < n; j++) {
            boolean flag = true;
            for(int i = 0; i < n; i++) {
                if(i == j)
                    continue;

                if(M[i][j] != 1) {
                    flag = false;
                }
            }
            if(flag) {
                for(int i = 0; i < n; i++) {
                    if(M[j][i] == 1) {
                        flag = false;
                        break;
                    }
                }
                if(flag) return j;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] M = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                M[i][j] = sc.nextInt();
            }
        }

        System.out.println(celebrity(M, n));
    }
}
