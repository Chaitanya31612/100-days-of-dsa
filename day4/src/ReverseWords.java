import java.util.Scanner;

public class ReverseWords {
    public static String reverseWords(String s) {
        // this will change more than one spaces to one
        s = s.replaceAll("\\s+"," ");

        String[] strArr = s.split(" ");

        StringBuilder newStr = new StringBuilder();
        for(String str : strArr) {
            for(int i = str.length() - 1; i >=0; i--) {
                newStr.append(str.charAt(i));
            }
            newStr.append(" ");
        }

        return newStr.toString().trim();
    }

    public static String reverseWordsBetter(String s) {
        char[] ca = s.toCharArray();
        for (int i = 0; i < ca.length; i++) {
            if (ca[i] != ' ') {   // when i is a non-space
                int j = i;
                while (j + 1 < ca.length && ca[j + 1] != ' ') { j++; } // move j to the end of the word
                reverse(ca, i, j);
                i = j;
            }
        }
        return new String(ca);
    }

    private static void reverse(char[] ca, int i, int j) {
        for (; i < j; i++, j--) {
            char tmp = ca[i];
            ca[i] = ca[j];
            ca[j] = tmp;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        System.out.println(reverseWords(s));
    }
}
