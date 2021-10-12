import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Isomorphic {

    public static boolean areIsomorphic(String str1,String str2) {
        if(str1.length() != str2.length())
            return false;

        HashMap<Character, Character> map = new HashMap<>();
        HashSet<Character> set = new HashSet<>();

        for(int i = 0; i < str1.length(); i++) {
            if(!map.containsKey(str1.charAt(i))) {
                if(set.contains(str2.charAt(i)))
                    return false;
                set.add(str2.charAt(i));
                map.put(str1.charAt(i), str2.charAt(i));
            } else if (str2.charAt(i) != map.get(str1.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();

        System.out.println(areIsomorphic(str1, str2));
    }
}
