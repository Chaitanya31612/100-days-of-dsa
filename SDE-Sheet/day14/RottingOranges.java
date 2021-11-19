package day14;
//https://leetcode.com/problems/rotting-oranges/discuss/1586822/Java-easy-solution-oror-Brute-and-Optimised-oror-BFS
public class RottingOranges {
    public int orangesRotting(int[][] grid) {
        int totalorange = 0, freshorange = 0, minutes = 0;
        int row = grid.length, col = grid[0].length;
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(grid[i][j] == 1) {
                    freshorange++;
                    totalorange++;
                }
                if(grid[i][j] == 2)
                    totalorange++;
            }
        }
        if(totalorange == freshorange) return -1;

        while(freshorange != 0) {
            for(int i = 0; i < row; i++) {
                for(int j = 0; j < col; j++) {
                    if(grid[i][j] == 0) continue;
                    if(grid[i][j] == 2) {
                        // top
                        if(i-1 >= 0 && grid[i-1][j] == 1) {
                            grid[i-1][j] = 3;
                            freshorange--;
                        }
                        // left
                        if(j-1 >= 0 && grid[i][j-1] == 1) {
                            grid[i][j-1] = 3;
                            freshorange--;
                        }
                        // right
                        if(j+1 < col && grid[i][j+1] == 1) {
                            grid[i][j+1] = 3;
                            freshorange--;
                        }
                        // down
                        if(i+1 < row && grid[i+1][j] == 1) {
                            grid[i+1][j] = 3;
                            freshorange--;
                        }
                    }
                }
            }
            for(int i = 0; i < row; i++)
                for(int j = 0; j < col; j++)
                    if(grid[i][j] == 3)
                        grid[i][j] = 2;

            minutes++;
        }
        return minutes;
    }
}
