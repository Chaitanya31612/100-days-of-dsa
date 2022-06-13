package day17_binarytree;

import java.util.*;


public class BottomView {
    public ArrayList <Integer> bottomView(Node root)
    {
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<NodeLevel> queue = new LinkedList<>();
        queue.add(new NodeLevel(root, 0));

        while(!queue.isEmpty()) {
            NodeLevel front = queue.poll();

            map.put(front.level, front.node.data);

            if(front.node.left != null) {
                queue.add(new NodeLevel(front.node.left, front.level-1));
            }

            if(front.node.right != null) {
                queue.add(new NodeLevel(front.node.right, front.level+1));
            }
        }

        // System.out.println(map);
        ArrayList<Integer> list = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            list.add(entry.getValue());
        }
        return list;
    }
}
