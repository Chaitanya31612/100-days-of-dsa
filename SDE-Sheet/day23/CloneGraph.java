package day23;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

public class CloneGraph {
    HashMap<Integer, Node> visitedMap = new HashMap<>();
    public Node cloneGraph(Node node) {
        if(node == null) return null;

        Node cloneNode = new Node(node.val, new ArrayList<>());
        visitedMap.put(cloneNode.val, cloneNode);
        for(Node neigh : node.neighbors) {
            Node clonedNeigh = null;
            if(visitedMap.containsKey(neigh.val)) {
                clonedNeigh = visitedMap.get(neigh.val);
            } else {
                clonedNeigh = cloneGraph(neigh);
            }
            cloneNode.neighbors.add(clonedNeigh);
        }

        return cloneNode;
    }
}
