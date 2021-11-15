package day12;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PowerSet {

    public List<String> AllPossibleStringsBrute(String s)
    {
        List<String> list = new ArrayList<>();
        char[] arr = s.toCharArray();
        powerSet(list, arr, new StringBuilder(), 0);
        list.remove(0);
        Collections.sort(list);
        return list;
    }


    public void powerSet(List<String> list, char[] arr, StringBuilder temp, int start) {
        list.add(temp.toString());
        for(int i = start; i < arr.length; i++) {
            // if(i != start && arr[i] == arr[i-1]) continue;
            temp.append(Character.toString(arr[i]));
            powerSet(list, arr, temp, i+1);
            temp.setLength(temp.length() - 1);
        }
    }

    // best approach
    public List<String> AllPossibleStrings(String s)
    {
        List<String> list = new ArrayList<>();

        for(int i = 1; i < (int)Math.pow(2, s.length()); i++) {
            String temp = "";
            for(int j = 0; j < s.length(); j++) {
                if(setBit(i, j)) {
                    temp += s.charAt(j);
                }
            }
            list.add(temp);
        }

        Collections.sort(list);

        return list;
    }

    public boolean setBit(int n, int i) {
        return (n & (1 << i)) != 0;
    }


    public static void main(String[] args) {
        PowerSet p = new PowerSet();
        System.out.println(p.AllPossibleStrings("abc"));
    }
}
