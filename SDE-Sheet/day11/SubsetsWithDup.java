package day11;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class SubsetsWithDup {
    public static void main(String[] args) {
        List<Integer> l1 = new ArrayList<>();
        l1.add(2);
        l1.add(3);
        List<Integer> l2 = new ArrayList<>();
        l2.add(2);
        l2.add(3);
        HashSet<List<Integer>> set = new HashSet<>();
        set.add(l1);
        set.add(l2);
        System.out.println(set);
    }
}
