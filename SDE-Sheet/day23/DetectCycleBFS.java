package day23;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DetectCycleBFS {

    public boolean hasCycle(ArrayList<ArrayList<Integer>> graph, int v) {
        boolean[] visited = new boolean[v];
        Queue<Integer> queue = new LinkedList<>();
        int[] parent = new int[v];
        for(int i = 0; i < v; i++)
            parent[i] = i;
        queue.add(0);
        visited[0] = true;

        while(!queue.isEmpty()) {
            int front = queue.poll();

            for(int neigh: graph.get(front)) {
                if(!visited[neigh]) {
                    queue.add(neigh);
                    visited[neigh] = true;
                    parent[neigh] = front;
                } else if(parent[neigh] != front) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Graph g = new Graph();
        ArrayList<ArrayList<Integer>> graph = g.input();
        int v = g.v;

        System.out.println(new DetectCycleBFS().hasCycle(graph, v));
    }
}
