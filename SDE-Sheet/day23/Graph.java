package day23;

import java.util.ArrayList;
import java.util.Scanner;

public class Graph {
    int v, e;
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
}
