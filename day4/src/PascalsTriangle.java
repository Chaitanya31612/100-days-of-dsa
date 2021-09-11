import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PascalsTriangle {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> rowsList = new ArrayList<>();

        List<Integer> row = new ArrayList<>();

        for(int i = 0; i < numRows; i++) {
            row.add(0, 1);

            for(int j = 1; j < row.size() - 1; j++) {
                row.set(j, row.get(j) + row.get(j + 1));
            }

//            rowsList.add(row); // this will reference the final value of row and not the intermediate one
            rowsList.add(new ArrayList<>(row));
        }

        return rowsList;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numRows = sc.nextInt();

        System.out.println(generate(numRows));
    }
}
