package day1_arrays;

public class BestTimeBuyStock {
  public int maxProfit(int[] prices) {
    int minSoFar = prices[0], maxProfit = 0;

    for (int i = 0; i < prices.length; i++) {
      minSoFar = Math.min(minSoFar, prices[i]);
      int profit = prices[i] - minSoFar;
      maxProfit = Math.max(profit, maxProfit);
    }

    return maxProfit;
  }

  public static void main(String[] args) {

  }
}
