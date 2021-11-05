package day11;

import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {
    public String getPermutationBrute(int n, int k) {
        String s = "";
        for(int i = 1; i <= n; i++)
            s += i;
        List<String> list = new ArrayList<>();
        solve(list, new StringBuilder(), s, k);
        return list.get(list.size() - 1);
    }

    public void solve(List<String> list, StringBuilder tempStr, String str, int k) {
        // base case
        if(tempStr.length() == str.length()) {
            list.add(tempStr.toString());
            return;
        }
        if(list.size() == k) return;
        // recursive step
        for(int i = 0; i < str.length(); i++) {
            if(tempStr.indexOf(str.substring(i, i+1)) != -1) continue;
            tempStr.append(str.charAt(i));
            solve(list, tempStr, str, k);
            tempStr.setLength(tempStr.length() - 1);
        }
    }
}
