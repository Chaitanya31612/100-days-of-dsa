import java.util.ArrayList;
import java.util.Scanner;

public class StockBuySell {

    public static ArrayList<ArrayList<Integer>> stockBuySell(int[] arr, int n) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int i = 0;

        if(n == 1)
            return res;

        while(i < n - 1) {
            // first find the local minima
            while(i < (n - 1) && arr[i + 1] <= arr[i])
                i++;

            // if array is in decreasing order
            if(i == n - 1)
                break;

            int buy = i;
            i++;

            // find the local maxima
            while(i < n && arr[i] >= arr[i - 1])
                i++;

            int sell = i - 1;
            ArrayList<Integer> list = new ArrayList<>();
            list.add(buy);
            list.add(sell);
            res.add(list);
        }
        return res;
    }

    public static ArrayList<ArrayList<Integer>> stockBuySellinitial(int[] arr, int n) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        int minSoFar = arr[0], minInd = 0, endInd = 0;
        for(int i = 1; i < n; i++) {
            if(arr[i] >= arr[i - 1]) {
                endInd = i;
            } else {
                ArrayList<Integer> l = new ArrayList<>();
                l.add(minInd); l.add(endInd);
                list.add(l);
                minInd = i;
            }
        }

        if(minInd != n - 1) {
            ArrayList<Integer> l = new ArrayList<>();
            l.add(minInd); l.add(endInd);
            list.add(l);
        }

        return list;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        System.out.println(stockBuySell(arr, n));
    }
}
