import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class SortArray {
    public static void sort(ArrayList<Integer> list) {
        if(list.size() <= 1) return;

        int temp = list.get(list.size() - 1);
        list.remove(list.size() - 1);
        sort(list);
        insert(list, temp);
    }

    public static void insert(ArrayList<Integer> list, int temp) {
        if(list.size() == 0 || list.get(list.size() - 1) <= temp) {
            list.add(temp);
            return;
        }

        int t = list.get(list.size() - 1);
        list.remove(list.size() - 1);
        insert(list, temp);
        list.add(t);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i < n; i++)
            list.add(sc.nextInt());

        sort(list);
        System.out.println(list);
    }
}
