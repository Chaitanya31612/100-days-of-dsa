package day21_bst;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// in codec.java

public class SerializeAndDeserialize {
    public static void main(String[] args) {
        int[] arr = {1,2,3,43};
        String s = Arrays.toString(arr);
        System.out.println(s);
        List<String> list = Arrays.asList(s.substring(1, s.length() - 1).split(", "));

        System.out.println(list);
        System.out.println(list.get(1));

        List<Integer> l = new ArrayList<>();
        l.add(34);
        l.add(45);
        l.add(null);
        String sy = l.toString();
        System.out.println(sy);
        List<String> l2 = Arrays.asList(sy.substring(1, sy.length() - 1).split(", "));
        System.out.println(l2.get(1));
        System.out.println(l2.get(2));

        String str = "null";
        System.out.println(Integer.parseInt(str));
    }
}
