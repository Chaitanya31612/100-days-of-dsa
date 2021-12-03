package day23;

import java.util.ArrayList;

public class DetectCycleUnionFInd {
    // detect cycle using union find
    public boolean hasCycleUnion(ArrayList<ArrayList<Integer>> graph, int v) {
        int[] parent = new int[v];
        for(int i = 0; i < parent.length; i++)
            parent[i] = i;

        for(int i = 0; i < graph.size(); i++) {
            for(int neigh : graph.get(i)) {

                int sourceParent = findParent(i, parent);
                int destinationParent = findParent(neigh, parent);

                if(sourceParent == destinationParent) {
                    return true;
                }
                parent[destinationParent] = sourceParent;
            }
        }

        return false;
    }

    public int findParent(int v, int[] parent) {
        if(v == parent[v]) {
            return v;
        }

        return findParent(parent[v], parent);
    }


    // cycle detection using dfs


    public static void main(String[] args) {
        Graph g = new Graph();
        ArrayList<ArrayList<Integer>> graph = g.input();
        int v = g.v;

        System.out.println(new DetectCycleUnionFInd().hasCycleUnion(graph, v));
    }
}
