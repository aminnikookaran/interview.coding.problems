package leetcode.easy;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
public class Q0122BestTimeToBuyAndSellStockII {
  public int maxProfit1(int[] prices) {
    int profit = 0;
    for (int i = 1; i < prices.length; i++) profit += Math.max(0, prices[i] - prices[i - 1]);
    return profit;
  }

  public int maxProfit2(int[] prices) {
    int i = 0;
    int valley = prices[0];
    int peak = prices[0];
    int maxprofit = 0;
    while (i < prices.length - 1) {
      while (i < prices.length - 1 && prices[i] >= prices[i + 1]) i++;
      valley = prices[i];
      while (i < prices.length - 1 && prices[i] <= prices[i + 1]) i++;
      peak = prices[i];
      maxprofit += peak - valley;
    }
    return maxprofit;
  }
}
