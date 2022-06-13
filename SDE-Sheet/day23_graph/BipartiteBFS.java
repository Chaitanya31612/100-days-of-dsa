package day23_graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BipartiteBFS {

    // leetcode


    // this is for connected graph
    public boolean checkBipartite(ArrayList<ArrayList<Integer>> graph, int v) {
        Queue<Integer> queue = new LinkedList<>();
        int[] color = new int[v]; // bipartite graph needs to be colored with only 2 colors
        Arrays.fill(color, -1);
        queue.add(0);
        color[0] = 0;

        while(!queue.isEmpty()) {
            int front = queue.poll();

            for(int neigh: graph.get(front)) {
                if(color[neigh] == color[front]) {
                    return false;
                } else if(color[neigh] == -1) {
                    color[neigh] = 1 - color[front];
                    queue.add(neigh);
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {

    }
}
