package day10;

import java.util.List;

public class MColoring {
    //Function to determine if graph can be coloured with at most M colours such
    //that no two adjacent vertices of graph are coloured with same colour.
    public static boolean graphColoring(List<Integer>[] G, int[] color, int i, int C)
    {
        // base case
        if(i == color.length) {
            return true;
        }
        // recursive call
        for(int clr = 1; clr <= C; clr++) {
            if(isSafe(G, color, clr, i)) {
                color[i] = clr;
                if(graphColoring(G, color, i+1, C)) {
                    return true;
                }
                color[i] = 0;
            }
        }
        return false;
    }

    public static boolean isSafe(List<Integer>[] G, int[] color, int clr, int idx) {
        // check the neighbors of idx
        for(int neigh : G[idx]) {
            if(color[neigh] == clr) return false;
        }

        return true;
    }
}
