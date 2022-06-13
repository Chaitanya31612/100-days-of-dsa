package day9_recursion;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartition {
    public List<List<String>> partition(String s) {
        List<List<String>> list = new ArrayList<>();
        partitionUtil(list, new ArrayList<>(), s);
        return list;
    }

    public void partitionUtil(List<List<String>> list, List<String> temp, String s) {
        // base case
        if(s.length() == 0) {
            list.add(new ArrayList<>(temp));
            return;
        }

        // recursive step
        for(int i = 0; i < s.length(); i++) {
            if(isPalindrome(s.substring(0, i + 1))) {
                temp.add(s.substring(0, i+1));
                partitionUtil(list, temp, s.substring(i+1));
                temp.remove(temp.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String s) {
        int n = s.length();
        for(int i = 0; i < n / 2; i++) {
            if(s.charAt(i) != s.charAt(n - i - 1)) {
                return false;
            }
        }

        return true;
    }
}
