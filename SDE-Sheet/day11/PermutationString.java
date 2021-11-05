package day11;

import java.util.ArrayList;
import java.util.List;

public class PermutationString {
    public List<String> permutation(String s) {
        List<String> list = new ArrayList<>();
        solve(list, new StringBuilder(), s);
        return list;
    }

    public void solve(List<String> list, StringBuilder tempStr, String str) {
        // base case
        if(tempStr.length() == str.length()) {
            list.add(tempStr.toString());
            return;
        }
        // recursive step
        for(int i = 0; i < str.length(); i++) {
            if(tempStr.indexOf(str.substring(i, i+1)) != -1) continue;
            tempStr.append(str.charAt(i));
            solve(list, tempStr, str);
            tempStr.setLength(tempStr.length() - 1);
        }
    }
    public static void main(String[] args) {
        String s = "123";
        System.out.println(new PermutationString().permutation(s));
    }
}
