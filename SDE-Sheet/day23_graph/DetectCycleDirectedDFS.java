package day23_graph;

import java.util.ArrayList;

public class DetectCycleDirectedDFS {

    public boolean checkCycle(ArrayList<ArrayList<Integer>> graph, int v) {
        boolean[] visited = new boolean[v];
        boolean[] path = new boolean[v];

        for(int i = 0; i < v; i++) {
            if(!visited[i]) {
                if(dfs(graph, i, visited, path)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(ArrayList<ArrayList<Integer>> graph, int s, boolean[] visited, boolean[] path) {
        visited[s] = true;
        path[s] = true;

        for(int neigh: graph.get(s)) {
            if(!visited[neigh]) {
                if(dfs(graph, neigh, visited, path))
                    return true;
            } else if(path[neigh]) {
                return true;
            }
        }

        path[s] = false;
        return false;
    }

    public static void main(String[] args) {
        Graph g = new Graph();
        ArrayList<ArrayList<Integer>> graph = g.directedInput();
        int v = g.v;

        System.out.println(graph);

        System.out.println(new DetectCycleDirectedDFS().checkCycle(graph, v));
    }
}
