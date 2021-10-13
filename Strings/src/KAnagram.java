import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class KAnagram {

    static boolean areKAnagrams(String s1, String s2, int k) {
        if(s1.length() != s2.length()) {
            return false;
        }

        // frequency map
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        int n = s1.length();
        for(int i = 0; i < n; i++) {
            if(!map1.containsKey(s1.charAt(i))) {
                map1.put(s1.charAt(i), 0);
            }
            map1.put(s1.charAt(i), map1.get(s1.charAt(i)) + 1);

            if(!map2.containsKey(s2.charAt(i))) {
                map2.put(s2.charAt(i), 0);
            }
            map2.put(s2.charAt(i), map2.get(s2.charAt(i)) + 1);
        }

        int count = 0;
        for(Map.Entry<Character, Integer> entry: map1.entrySet()) {
            if(!map2.containsKey(entry.getKey())) {
                count += entry.getValue();
            } else {
                if(!entry.getValue().equals(map2.get(entry.getKey()))) {
                    count += Math.abs(entry.getValue() - map2.get(entry.getKey()));
                }
            }
        }

        if((count&1) == 1 || count > k) {
            return false;
        }

        return true;
    }

    public static boolean areAnagramsbetter(String s1, String s2, int k) {
        if(s1.length() != s2.length())
            return false;

        int[] arr1 = new int[26];
        int[] arr2 = new int[26];

        int n = s1.length();

        for(int i = 0; i < n; i++) {
            arr1[s1.charAt(i) - 'a']++;
            arr2[s2.charAt(i) - 'a']++;
        }

        int count = 0;

        for(int i = 0; i < 26; i++) {
            if(arr1[i] != 0 && arr2[i] == 0) {
                count += arr1[i];
            } else if(arr2[i] != 0 && arr1[i] == 0) {
                count += arr2[i];
            } else if(arr1[i] != 0 && arr2[i] != 0 && arr1[i] != arr2[i]) {
                count += Math.abs(arr1[i] - arr2[i]);
            }
        }

        if((count / 2) > k)
            return false;

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        int n = sc.nextInt();

//        System.out.println(areKAnagrams(s1, s2, n));
        System.out.println(areAnagramsbetter(s1, s2, n));
    }
}

//u o v w h q f a e m q o d y k s j j
//s w w h z s i o w o c j f y a d v j
//zjwusu
//wetkfj
//1