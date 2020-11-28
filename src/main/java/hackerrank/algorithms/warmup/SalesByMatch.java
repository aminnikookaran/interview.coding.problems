package hackerrank.algorithms.warmup;

import java.util.HashMap;
import java.util.Map;

// https://www.hackerrank.com/challenges/sock-merchant/problem?h_l=interview&playlist_slugs%5B%5D%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D%5B%5D=warmup
public class SalesByMatch {
  public static int sockMerchant(int n, int[] ar) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i : ar) {
      Integer count = map.get(i);
      map.put(i, count == null ? 1 : count + 1);
    }
    int sum = 0;
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) sum += entry.getValue() / 2;
    return sum;
  }
}
