import java.util.HashSet;

public class ValidSudoku {
    public static boolean isValidSudoku(char[][] board) {
        int row = board.length, col = board[0].length;

        // check for every element of every row
        for(int i = 0; i < row; i++) {
            HashSet<Character> set = new HashSet<>();
            for(int j = 0; j < col; j++) {
                if(!set.contains(board[i][j])) {
                    set.add(board[i][j]);
                } else if(board[i][j] != '.') {
                    return false;
                }
            }
        }

        // check for every element of every column
        for(int j = 0; j < col; j++) {
            HashSet<Character> set = new HashSet<>();
            for(int i = 0; i < col; i++) {
                if(!set.contains(board[i][j])) {
                    set.add(board[i][j]);
                } else if(board[i][j] != '.') {
                    return false;
                }
            }
        }
        // check for 3 X 3 matrix adjacent to cell

        // LEFT TO DO

        int r = 0, c = 0, k = 3, l = 3;
        while(k-- > 0) {
            for (int i = 0; i < 3; i++) {
                HashSet<Character> set = new HashSet<>();
                while (l-- > 0) {
                    for (int j = 0; j < 3; j++) {
//                    System.out.println((r + i) + " " + (c + j));
                        System.out.print(board[r + i][c + j] + " ");
                        if (!set.contains(board[r + i][c + j])) {
                            set.add(board[r + i][c + j]);
                        } else if (board[r + i][c + j] != '.') {
                            return false;
                        }
                    }
                    c += 3;
                }
                System.out.println();
            }
            r += 3;
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board1 =
            {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
            };

        char[][] board2 = {
                {'.','.','.','.','5','.','.','1','.'},
                {'.','4','.','3','.','.','.','.','.'},
                {'.','.','.','.','.','3','.','.','1'},
                {'8','.','.','.','.','.','.','2','.'},
                {'.','.','2','.','7','.','.','.','.'},
                {'.','1','5','.','.','.','.','.','.'},
                {'.','.','.','.','.','2','.','.','.'},
                {'.','2','.','9','.','.','.','.','.'},
                {'.','.','4','.','.','.','.','.','.'}
        };

        System.out.println(isValidSudoku(board2));
    }
}
