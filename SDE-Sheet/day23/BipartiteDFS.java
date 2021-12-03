package day23;

import java.util.ArrayList;
import java.util.Arrays;

public class BipartiteDFS {
    // leetcode
    public boolean isBipartite(int[][] graph) {
        int v = graph.length;
        int[] color = new int[v];
        boolean[] visited = new boolean[v];
        Arrays.fill(color, -1);

        // bipartite using dfs
        for(int i = 0; i < v; i++) {
            if(!visited[i]) {
                color[i] = 0;
                if(!dfs(graph, i, color, visited))
                    return false;
            }
        }

        return true;
    }

    public boolean dfs(int[][] graph, int s, int[] color, boolean[] visited) {
        visited[s] = true;

        for(int neigh : graph[s]) {
            if(color[neigh] == -1) {
                color[neigh] = 1 - color[s];
                if(!dfs(graph, neigh, color, visited)) {
                    return false;
                }
            } else if(color[neigh] == color[s]) {
                return false;
            }
        }

        return true;
    }
    public boolean checkBipartite(ArrayList<ArrayList<Integer>> graph, int v) {
        boolean[] visited = new boolean[v];
        int[] color = new int[v];
        Arrays.fill(color, -1);

        for(int i = 0; i < v; i++) {
            if(!visited[i]) {
                if(!dfs(graph, i, visited, color))
                    return false;
            }
        }

        return true;
    }

    private boolean dfs(ArrayList<ArrayList<Integer>> graph, int s, boolean[] visited, int[] color) {
        visited[s] = true;

        for(int neigh: graph.get(s)) {
            if(color[neigh] == -1) {
                color[neigh] = 1 - color[s];

                if(!dfs(graph, neigh, visited, color))
                    return false;
            } else if(color[neigh] == color[s]) {
                return false;
            }
        }
        return true;
    }


}
