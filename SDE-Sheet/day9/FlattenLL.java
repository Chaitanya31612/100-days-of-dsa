package day9;

import java.util.ArrayList;
import java.util.Collections;

class Node
{
    int data;
    Node next;
    Node bottom;

    Node(int d)
    {
        data = d;
        next = null;
        bottom = null;
    }
}

public class FlattenLL {
    Node flattenBrute(Node root)
    {
        if(root == null) return null;
        ArrayList<Integer> list = new ArrayList<>();
        Node temp = root;
        while(temp != null) {
            list.add(temp.data);
            Node tempBottom = temp.bottom;
            while(tempBottom != null) {
                list.add(tempBottom.data);
                tempBottom = tempBottom.bottom;
            }
            temp = temp.next;
        }
        Collections.sort(list);
        Node newRoot = new Node(list.get(0));
        Node curr = newRoot;
        for(int i = 1; i< list.size(); i++) {
            curr.bottom = new Node(list.get(i));
            curr = curr.bottom;
        }

        return newRoot;
    }

    Node mergeLists(Node l1, Node l2) {
        Node temp = new Node(0);
        Node res = temp;
        while(l1 != null && l2 != null) {
            if(l1.data <= l2.data) {
                temp.bottom = l1;
                l1 = l1.bottom;
            } else {
                temp.bottom = l2;
                l2 = l2.bottom;
            }
            temp = temp.bottom;
        }

        if(l1 != null) temp.bottom = l1;
        else temp.bottom = l2;

        return res.bottom;
    }
    Node flatten(Node root)
    {
        if(root == null || root.next == null) {
            return root;
        }

        root.next = flatten(root.next);
        root = mergeLists(root, root.next);

        return root;
    }
    public static void main(String[] args) {

    }
}
