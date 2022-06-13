package day23_graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DetectCycleDirectedBFS {
    // check if the graph is DAG i.e it's topological sort length is equal to number of vertices, then it won't have cycle
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        Queue<Integer> queue = new LinkedList<>();

        int[] indegree = new int[V];

        for(int i = 0; i < adj.size(); i++) {
            for(int node : adj.get(i)) {
                indegree[node]++;
            }
        }

        for(int i = 0; i < indegree.length; i++) {
            if(indegree[i] == 0){
                queue.add(i);
            }
        }
        int cnt = 0;
        while(!queue.isEmpty()) {
            int front = queue.poll();
            cnt++;
            for(int neigh: adj.get(front)) {
                indegree[neigh]--;
                if(indegree[neigh] == 0) {
                    queue.add(neigh);
                }
            }
        }

        return !(cnt == V); // if it is equal that means our graph is DAG
    }
}
