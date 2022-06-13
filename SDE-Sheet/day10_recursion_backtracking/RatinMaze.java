package day10_recursion_backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RatinMaze {
    public static ArrayList<String> findPath(int[][] m, int n) {
        ArrayList<String> list = new ArrayList<>();

        // if starting or ending is 0 then we cannot reach destination
        if(m[0][0] == 0 || m[n-1][n-1] == 0)
            return list;

        boolean[][] visited = new boolean[n][n];
        for(boolean[] arr: visited)
            Arrays.fill(arr, false);

        findPathUtil(list, "", visited, m, n, 0, 0);
        Collections.sort(list);

        return list;
    }

    public static void findPathUtil(ArrayList<String> list, String str, boolean[][] visited, int[][] m, int n, int row, int col) {
        // base case
        if(row == n-1 && col == n-1) {
            list.add(str);
            return;
        }

        if(m[row][col] == 0 || visited[row][col])
            return;

        // recursive case
        visited[row][col] = true;
        // down move
        if(row < n-1) {
            findPathUtil(list, str + "D", visited, m, n, row+1, col);
        }
        // right move
        if(col < n-1) {

            findPathUtil(list, str + "R", visited, m, n, row, col+1);
        }
        // left move
        if(col > 0) {

            findPathUtil(list, str + "L", visited, m, n, row, col-1);
        }

        // up move
        if(row > 0) {

            findPathUtil(list, str + "U", visited, m, n, row-1, col);
        }
        visited[row][col] = false;
    }

    public static void main(String[] args) {
        String s = "Hello";
        List<String> list = new ArrayList<>();
        list.add(s);
        s += " there";
        list.add(s);
        System.out.println(list);

        List<List<Integer>> list1 = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        temp.add(5);
        list1.add(temp);
        temp.add(10);
        list1.add(temp);
        System.out.println(list1);
    }
}
