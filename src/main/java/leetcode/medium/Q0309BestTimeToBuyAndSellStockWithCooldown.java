package leetcode.medium;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
public class Q0309BestTimeToBuyAndSellStockWithCooldown {
  // https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/discuss/75924/Most-consistent-ways-of-dealing-with-the-series-of-stock-problems
  // T[i][k][0] = max(T[i-1][k][0], T[i-1][k][1] + prices[i])
  // T[i][k][1] = max(T[i-1][k][1], T[i-2][k][0] - prices[i])
  public int maxProfit1(int[] prices) {
    if (prices == null || prices.length <= 1) return 0;

    int T_ik0_pre = 0, T_ik0 = 0, T_ik1 = Integer.MIN_VALUE;

    for (int price : prices) {
      int T_ik0_old = T_ik0;
      T_ik0 = Math.max(T_ik0, T_ik1 + price);
      T_ik1 = Math.max(T_ik1, T_ik0_pre - price);
      T_ik0_pre = T_ik0_old;
    }

    return T_ik0;
  }

  public int maxProfit2(int[] prices) {
    if (prices == null || prices.length <= 1) return 0;
    int[] s0 = new int[prices.length];
    int[] s1 = new int[prices.length];
    int[] s2 = new int[prices.length];
    s1[0] = -prices[0];
    s0[0] = 0;
    s2[0] = Integer.MIN_VALUE;
    for (int i = 1; i < prices.length; i++) {
      s0[i] = Math.max(s0[i - 1], s2[i - 1]);
      s1[i] = Math.max(s1[i - 1], s0[i - 1] - prices[i]);
      s2[i] = s1[i - 1] + prices[i];
    }
    return Math.max(s0[prices.length - 1], s2[prices.length - 1]);
  }

  public int maxProfit3(int[] prices) {
    if (prices == null || prices.length <= 1) return 0;
    int s0 = 0, s1 = -prices[0], s2 = Integer.MIN_VALUE, s0pre, s1pre, s2pre;
    for (int i = 1; i < prices.length; i++) {
      s0pre = s0;
      s1pre = s1;
      s2pre = s2;
      s0 = Math.max(s0pre, s2pre);
      s1 = Math.max(s1pre, s0pre - prices[i]);
      s2 = s1pre + prices[i];
    }
    return Math.max(s0, s2);
  }
}
