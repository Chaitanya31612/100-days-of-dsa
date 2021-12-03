package day23;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class TopologicalSort {

    public void topologicalSort(ArrayList<ArrayList<Integer>> graph, int v) {
        boolean[] visited = new boolean[v];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < v; i++) {
            if(!visited[i]) {
                topologicalSortUtil(graph, v, i, visited, stack);
            }
        }

        while(!stack.isEmpty()) {
            System.out.print(stack.pop() + "->");
        }
    }

    private void topologicalSortUtil(ArrayList<ArrayList<Integer>> graph, int v, int s, boolean[] visited, Stack<Integer> stack) {
        visited[s] = true;

        for(int neigh: graph.get(s)) {
            if(!visited[neigh]) {
                topologicalSortUtil(graph, v, neigh, visited, stack);
            }
        }

        stack.push(s);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int e = sc.nextInt();

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < e; i++) {
            int fv = sc.nextInt();
            int sv = sc.nextInt();

            graph.get(fv).add(sv);
        }

        TopologicalSort ts = new TopologicalSort();

        ts.topologicalSort(graph, n);
    }
}
