package day14_stack_queue;

import java.util.HashMap;

public class LFU {
    class DList {
        int key, val, freq;
        DList next = null, prev = null;

        public DList(int key, int val, int freq) {
            this.key = key;
            this.val = val;
            this.freq = freq;
        }
        @Override
        public String toString() {
            return String.format("[" + key + ", " + val + ", " + freq + "]");
        }


    }

    class LFUCache {
        HashMap<Integer, DList> map = new HashMap<>();

        DList head = new DList(-1,-1,-1);
        DList tail = new DList(-1,-1,-1);
        int capacity;
        public LFUCache(int capacity) {
            head.next = tail;
            tail.prev = head;
            this.capacity = capacity;
        }

        public void print() {
            DList temp = head.next;
            while(temp.next != null) {
                System.out.print("{" + temp.key + "," + temp.freq + "} ->");
                temp = temp.next;
            }
            System.out.println();
        }

        public void addnode(DList newNode) {
            map.put(newNode.key, newNode);
            DList temp = head.next;
            DList pre = head;
            while(temp != tail) {
                if(temp.freq <= newNode.freq) {
                    break;
                }
                pre = temp;
                temp = temp.next;
            }
            newNode.next = temp;
            newNode.prev = pre;
            pre.next = newNode;
            temp.prev = newNode;
        }

        public void removenode(DList node) {
            map.remove(node.key);
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        public int get(int key) {
            if(map.containsKey(key)) {
                DList node = map.get(key);
                removenode(node);
                node.freq++;
                addnode(node);
                print();
                return node.val;
            }

            return -1;
        }

        public void put(int key, int value) {
            if(capacity == 0) return;
            if(map.containsKey(key)) {
                DList node = map.get(key);
                removenode(node);
                addnode(new DList(key, value, node.freq));
                print();
                return;
            } else if(map.size() == capacity) {
                removenode(tail.prev);
            }
            addnode(new DList(key, value, 1));
            print();
        }
    }

}
