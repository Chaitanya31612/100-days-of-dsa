package day14;

import java.util.HashMap;

//https://leetcode.com/problems/lru-cache/discuss/1586478/java-easy-solution-with-explanation-hashmap-and-doubly-linked-list
// custom doubly linked list
class DList {
    int key, val;
    DList next = null;
    DList prev = null;

    public DList(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

class LRUCache {
    // map for storing key and corresponding (key-value) node in list
    HashMap<Integer, DList> map;

    // head and tail
    DList head = new DList(-1, -1);
    DList tail = new DList(-1, -1);
    // this is the size of lru cache
    int capacity;
    public LRUCache(int capacity) {
        map = new HashMap<>();
        head.next = tail;
        tail.prev = head;
        this.capacity = capacity;
    }

    // add next to head
    public void addnode(DList newNode) {
        map.put(newNode.key, newNode);
        DList temp = head.next;
        newNode.next = temp;
        newNode.prev = head;
        head.next = newNode;
        temp.prev = newNode;
    }

    // remove node
    public void removenode(DList node) {
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public int get(int key) {
        if(map.containsKey(key)) {
            DList node = map.get(key);
            removenode(node);
            addnode(node);
            return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)) {
            // remove that node from list and map
            removenode(map.get(key));
        } else if(map.size() == capacity) {
            // remove from tail and map
            removenode(tail.prev);
        }
        // add next to head
        addnode(new DList(key, value));
    }

    public static void main(String[] args) {
    }
}