package problems;

import java.util.HashMap;
import java.util.Map;

public class PairSums {
  public static int numberOfWays(int[] arr, int k) {
    if (arr == null || arr.length == 0) return 0;
    int sum = 0;
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < arr.length; i++) {
      Integer count = map.get(k - arr[i]);
      if (count != null) sum += count;
      count = map.get(arr[i]);
      if (count == null) count = 0;
      map.put(arr[i], count + 1);
    }
    return sum;
  }

  public static void main(String[] args) {
    System.out.println(numberOfWays(new int[] {1, 2, 3, 4, 3}, 6));
    System.out.println(numberOfWays(new int[] {1, 5, 3, 3, 3}, 6));
  }
}
