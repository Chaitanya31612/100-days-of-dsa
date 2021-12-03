package day23;

import java.util.ArrayList;

public class DetectCycleDFS {

    public boolean hasCycle(ArrayList<ArrayList<Integer>> graph, int v) {
        boolean[] visited = new boolean[v];

        for(int i = 0; i< v; i++) {
            if(!visited[i]) {
                if(checkCycleDFS(graph, i, -1, visited))
                    return true;
            }
        }

        return false;
    }

    private boolean checkCycleDFS(ArrayList<ArrayList<Integer>> graph, int s, int parent, boolean[] visited) {
        visited[s] = true;

        for(int neigh: graph.get(s)) {
            if(!visited[neigh]) {
                return checkCycleDFS(graph, neigh, s, visited);
            } else if(s != parent) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Graph g = new Graph();
        ArrayList<ArrayList<Integer>> graph = g.input();
        int v = g.v;

        System.out.println(new DetectCycleDFS().hasCycle(graph, v));
    }
}
