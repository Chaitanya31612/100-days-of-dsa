package day10;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

    public List<int[][]> solveNQueens(int n) {
        List<int[][]> list = new ArrayList<>();
        int[][] board = new int[n][n];
        solveNQueensUtil(board, n, list, 0);
        return list;
    }

    public void solveNQueensUtil(int[][] board, int n, List<int[][]> list, int row) {
        if(row >= n) {
            list.add(board);
            return;
        }
        for(int col = 0; col < n; col++) {
            if(isSafe(board, n, row, col)) {
                board[row][col] = 1;
                if(nQueenUtil(board, n, row + 1)) {
                    list.add(board);
                }
                board[row][col] = 0;
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(new NQueen().nQueen(n));
    }
}
