import java.util.ArrayList;
import java.util.Scanner;

public class StockBuySellPrint {

    public static void stockBuySell(int[] arr, int n) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int i = 0;

        if(n == 1) {
            System.out.println("No Profit");
            return;
        }

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

        if(res.size() == 0)
            System.out.println("No Profit");

        for(int t = 0; t < res.size(); t++) {
            if(t == res.size() - 1)
                System.out.print("(" + res.get(t).get(0) + " " + res.get(t).get(1) + ")");
            else
                System.out.print("(" + res.get(t).get(0) + " " + res.get(t).get(1) + ") ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        stockBuySell(arr, n);
    }
}
