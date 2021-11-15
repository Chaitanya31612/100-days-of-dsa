package day13;

import java.util.ArrayList;

public class StackArray {
    // stack with array
    /*
    * array should be dynamic-> arraylist
    * add to the end, push func
    * pop fun -> removing from the end
    * peek fun -> return last
    * isEmpty
    *
    * */

    ArrayList<Integer> list = new ArrayList<>();

    public void push(int val) {
        list.add(val);
    }
    public void add(int val, int idx) {
        list.add(idx, val);
    }

    public int pop() {
        if(isEmpty()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return list.remove(list.size() - 1);
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }

    public void print() {
        for (Integer integer : list) {
            System.out.print(integer + ", ");
        }
        System.out.println();
    }

}
