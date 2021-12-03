package day23;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class GraphCodes {

    public static ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        ArrayList<Integer> list = new ArrayList<>();

        // for unconnected also
        for(int i = 0; i < V; i++) {
            if(!visited[i]) {
                dfsUtil(i, adj, visited, list);
            }
        }

        return list;
    }

    private static void dfsUtil(int s, ArrayList<ArrayList<Integer>> graph, boolean[] visited, ArrayList<Integer> list) {
        list.add(s);
        visited[s] = true;

        for(int neigh : graph.get(s)) {
            if(!visited[neigh]) {
                dfsUtil(neigh, graph, visited, list);
            }
        }
    }

    public static ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();

        ArrayList<Integer> list = new ArrayList<>();

        queue.add(0);
        visited[0] = true;

        while(!queue.isEmpty()) {
            int front = queue.poll();
            list.add(front);

            for(int neigh : adj.get(front)) {
                if(!visited[neigh]) {
                    queue.add(neigh);
                    visited[neigh] = true;
                }
            }
        }

        return list;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of vertex and edges");
        int v = sc.nextInt();
        int e = sc.nextInt();

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < v; i++) {
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i < e; i++) {
            int fv = sc.nextInt();
            int sv = sc.nextInt();

            graph.get(fv).add(sv);
            graph.get(sv).add(fv);
        }

        System.out.println(dfsOfGraph(v, graph));
        System.out.println(bfsOfGraph(v, graph));
    }
}

/*
* 4 4
* 0 1
* 1 2
* 2 3
* 3 1
* */