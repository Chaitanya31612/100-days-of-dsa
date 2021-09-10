import java.util.Arrays;
import java.util.Scanner;

public class MatrixReshape {
    public static int[][] matrixReshapeNaive(int[][] mat, int r, int c) {
        int m = mat.length, n = mat[0].length;
        int[] val = new int[m * n];

        if((m == r && n == c) || (m*n != r*c))
            return mat;

        int k = 0;
        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++)
                val[k++] = mat[i][j];


        int[][] ans = new int[r][c];

        k = 0;
        for(int i = 0; i < r; i++)
            for(int j = 0; j < c; j++)
                ans[i][j] = val[k++];

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] mat = new int[m][n];

        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++)
                mat[i][j] = sc.nextInt();

        int r = sc.nextInt();
        int c = sc.nextInt();

        int[][] ans = matrixReshapeNaive(mat, r, c);
        for(int[] arr: ans)
            System.out.println(Arrays.toString(arr));
    }
}
