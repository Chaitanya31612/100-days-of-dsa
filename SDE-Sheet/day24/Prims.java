package day24;

import day23.Graph;

import java.util.Arrays;

public class Prims {

    public int minCostPrims(int[][] graph, int v) {
        int[] weight = new int[v];
        Arrays.fill(weight, Integer.MAX_VALUE);
        weight[0] = 0;

        boolean[] visited = new boolean[v];

        for(int i = 0; i < v; i++) {
            // find min cost from unvisted
            int minIdx = findMin(visited, weight);
            visited[minIdx] = true;
            for(int j = 0; j < v; j++) {
                int edgeweight = graph[minIdx][j];
                if(edgeweight > 0) {
                    if(!visited[j] && edgeweight < weight[j]) {
                        weight[j] = edgeweight;
                    }
                }
            }
        }

        // find min cost i.e sum of weight
        int sum = 0;
        for(int i = 0; i < v; i++) {
            sum += weight[i];
        }

        return sum;
    }

    public int findMin(boolean[] visited, int[] weight) {
        int minIdx = -1, min = Integer.MAX_VALUE;

        for(int i = 0; i < weight.length; i++) {
            if(!visited[i] && weight[i] < min) {
                min = weight[i];
                minIdx = i;
            }
        }

        return minIdx;
    }

    public static void main(String[] args) {
        Graph g = new Graph();
        int[][] graph = g.inputarray();
        int v = g.v;

        System.out.println(new Prims().minCostPrims(graph, v));
    }
}
