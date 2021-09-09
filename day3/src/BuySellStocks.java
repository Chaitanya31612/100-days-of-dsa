import java.util.Scanner;

public class BuySellStocks {
    public static int maxProfitNaive(int[] prices) {
        int n = prices.length;

        int profit = 0;

        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                if(prices[j] - prices[i] > 0 && prices[j] - prices[i] > profit) {
                    profit = prices[j] - prices[i];
                }
            }
        }

        return profit;
    }

    public static int maxProfit(int[] prices) {
        int minSoFar = prices[0], maxProfit = 0;

        for(int i = 0; i < prices.length; i++) {
            minSoFar = Math.min(minSoFar, prices[i]);
            int profit = prices[i] - minSoFar;
            maxProfit = Math.max(profit, maxProfit);
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] prices = new int[n];

        for(int i = 0; i < n; i++) {
            prices[i] = sc.nextInt();
        }

        System.out.println(maxProfit(prices));
    }
}
