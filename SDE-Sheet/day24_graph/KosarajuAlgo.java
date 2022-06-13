package day24_graph;

import day23_graph.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class KosarajuAlgo {

    public List<List<Integer>> kosarajuAlgo(ArrayList<ArrayList<Integer>> graph, int v) {
        // first do topological sort to get ordering in finishing order
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[v];

        // fill the stack
        for(int i = 0; i < v; i++) {
            if(!visited[i]) {
                topologicalSort(graph, i, stack, visited);
            }
        }

        // reverse the graph or transpose the graph
        ArrayList<ArrayList<Integer>> transpose = new ArrayList<>();
        for(int i = 0; i < v; i++) {
            transpose.add(new ArrayList<>());
        }

        for(int i = 0; i < graph.size(); i++) {
            for(int j = 0; j < graph.get(i).size(); i++) {
                transpose.get(graph.get(i).get(j)).add(i);
            }
        }

        // now using the stack do a dfs
        Arrays.fill(visited, false);
        List<List<Integer>> list = new ArrayList<>();
        while(!stack.isEmpty()) {
            int top = stack.pop();
            if(!visited[top]) {
                List<Integer> l = dfs(transpose, top, visited, new ArrayList<>());
                list.add(new ArrayList<>(l));
            }
        }

        return list;
    }

    public void topologicalSort(ArrayList<ArrayList<Integer>> graph, int s, Stack<Integer> stack, boolean[] visited) {
        visited[s] = true;

        for(int neigh: graph.get(s)) {
            if(!visited[neigh]) {
                topologicalSort(graph, neigh, stack, visited);
            }
        }

        stack.push(s);
    }

    public List<Integer> dfs(ArrayList<ArrayList<Integer>> graph, int s, boolean[] visited, List<Integer> list) {
        visited[s] = true;
        list.add(s);
        for(int neigh: graph.get(s)) {
            if(!visited[neigh]) {
                dfs(graph, neigh, visited, list);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Graph g = new Graph();
        ArrayList<ArrayList<Integer>> graph = g.directedInput();
        int v = g.v;

        System.out.println(new KosarajuAlgo().kosarajuAlgo(graph, v));
    }
}
