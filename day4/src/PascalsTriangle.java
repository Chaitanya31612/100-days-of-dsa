import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PascalsTriangle {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();

        if(numRows == 1) {
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(1);
            list.add(temp);

            return list;
        }
        if (numRows == 2) {
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(1);
            list.add(temp);
//            temp.add(1);
//            temp.add(1);
            list.add(temp);

            return list;
        }

        return list;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numRows = sc.nextInt();

        System.out.println(generate(numRows));
    }
}
