package Stocks;

// Best time to buy and sell stock
public class BTBSS {
    public int maxProfit(int[] prices) {
        int minSoFar = Integer.MAX_VALUE, ans = 0;
        for(int el: prices) {
            minSoFar = Math.min(minSoFar, el);
            ans = Math.max(ans, el - minSoFar);
        }
        return ans;
    }
}
