package day10_recursion_backtracking;

import java.util.*;
//https://leetcode.com/problems/n-queens/discuss/1566119/Java-easy-solution-2ms-oror-Backtracking
public class NQueen {
    public boolean isSafe(int[][] board, int n, int row, int col) {
        // check in the column
        for(int i = 0; i <= row; i++) {
            if(board[i][col] == 1) {
                return false;
            }
        }

        // check left diagonal
        for(int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if(board[i][j] == 1)
                return false;
        }

        // check for right diagonal
        for(int i = row, j = col; i >= 0 && j < n; i--, j++) {
            if(board[i][j] == 1)
                return false;
        }

        return true;
    }
    public boolean nQueen(int n) {
        int[][] board = new int[n][n];
        return nQueenUtil(board, n, 0);
    }

    public boolean nQueenUtil(int[][] board, int n, int row) {
        if(row >= n) return true;
        for(int col = 0; col < n; col++) {
            if(isSafe(board, n, row, col)) {
                board[row][col] = 1;
                if(nQueenUtil(board, n, row + 1)) {
                    return true;
                }
                board[row][col] = 0;
            }
        }

        return false;
    }

    public List<int[][]> solveNQueens01(int n) {
        List<int[][]> list = new ArrayList<>();
        int[][] board = new int[n][n];
        solveNQueensUtil01(board, n, list, 0);
        return list;
    }

    public boolean solveNQueensUtil01(int[][] board, int n, List<int[][]> list, int row) {
        if(row >= n) {
            return true;
        }
        for(int col = 0; col < n; col++) {
            if(isSafe(board, n, row, col)) {
                board[row][col] = 1;
                if(solveNQueensUtil01(board, n, list,row + 1)) {
                    list.add(board);
                    return true;
                }
                board[row][col] = 0;
            }
        }
        return false;
    }

    // leetcode
    public boolean isSafePlace(char[][] board, int n, int row, int col) {
        // check in the column
        for(int i = 0; i <= row; i++) {
            if(board[i][col] == 'Q') {
                return false;
            }
        }

        // check left diagonal
        for(int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if(board[i][j] == 'Q')
                return false;
        }

        // check for right diagonal
        for(int i = row, j = col; i >= 0 && j < n; i--, j++) {
            if(board[i][j] == 'Q')
                return false;
        }

        return true;
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> list = new ArrayList<>();
        char[][] board = new char[n][n];
        for(char[] arr: board)
            Arrays.fill(arr, '.');
        solveNQueensUtil(board, n, list, 0);
        return list;
    }

    public void solveNQueensUtil(char[][] board, int n, List<List<String>> list, int row) {
        if(row == n) {
            List<String> temp = new ArrayList<>();
            for(char[] chArr: board) {
                temp.add(new String(chArr));
            }
            list.add(new ArrayList<>(temp));
            return;
        }

        for(int col = 0; col < n; col++) {
            if(isSafePlace(board, n, row, col)) {
                board[row][col] = 'Q';
                solveNQueensUtil(board, n, list, row + 1);
                board[row][col] = '.';
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
//        System.out.println(new NQueen().nQueen(n));
//        List<int[][]> list = new NQueen().solveNQueens01(n);
//        for (int[][] ints : list) {
//            for (int[] arr : ints) {
//                System.out.println(Arrays.toString(arr));
//            }
//            System.out.println();
//        }

        List<List<String>> list = new NQueen().solveNQueens(n);
        System.out.println(list);
    }
}
