package day23;

import java.util.Arrays;

public class NoIslands {
    // if horizontally, vertically, diagonally
    int count = 0;
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(!visited[i][j] && grid[i][j] == '1') {
                    dfs(grid, i, j, visited);
                    for(boolean[] arr: visited){
                        System.out.println(Arrays.toString(arr));
                    }
                    count++;
                }
            }
        }

        return count;
    }

    // if horizontally, vertically, diagonally
    // left, left up diag, up, right up diag, right, right down, down, left down
    int[] dx = {0,-1,-1,-1,0,1,1,1};
    int[] dy = {-1,-1, 0,1,1,1,0,-1};

    public void dfs(char[][] grid, int i, int j, boolean[][] visited) {
        visited[i][j] = true;

        for(int k = 0; k < 8; k++) {
            int x = i + dx[k];
            int y = j + dy[k];

            if(x < 0 || y < 0 || x >= grid.length || y >= grid[0].length)
                continue;

            if(!visited[x][y] && grid[x][y] == '1') {
                dfs(grid, x, y, visited);
            }
        }

    }
}
