package day23_graph;

import java.util.ArrayList;
import java.util.Scanner;

public class Graph {
    public int v, e;
    public ArrayList<ArrayList<Integer>> input() {
        Scanner sc = new Scanner(System.in);

        v = sc.nextInt();
        e = sc.nextInt();

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < v; i++)
            graph.add(new ArrayList<>());

        for(int i = 0; i < e; i++) {
            int fv = sc.nextInt();
            int sv = sc.nextInt();

            graph.get(fv).add(sv);
            graph.get(sv).add(fv);
        }

        return graph;
    }

    public ArrayList<ArrayList<Integer>> directedInput() {
        Scanner sc = new Scanner(System.in);

        v = sc.nextInt();
        e = sc.nextInt();

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < v; i++)
            graph.add(new ArrayList<>());

        for(int i = 0; i < e; i++) {
            int fv = sc.nextInt();
            int sv = sc.nextInt();

            graph.get(fv).add(sv);
        }

        return graph;
    }

    public int[][] inputarray() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter vertices and edges");
        v = sc.nextInt();
        e = sc.nextInt();

        int[][] graph = new int[v][v];

        System.out.println("Enter fv, sv, wt for " + e + " times");
        for(int i = 0; i < e; i++) {
            int fv = sc.nextInt();
            int sv = sc.nextInt();
            int wt = sc.nextInt();

            graph[fv][sv] = wt;
            graph[sv][fv] = wt;
        }

        return graph;
    }
}
