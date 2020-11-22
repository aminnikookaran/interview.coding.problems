package hackerrank.algorithms.implementation;

import java.util.HashMap;
import java.util.Map;

// https://www.hackerrank.com/challenges/divisible-sum-pairs/problem
public class DivisibleSumPairs {
  public static int divisibleSumPairs(int k, int[] ar) {
    Map<Integer, Integer> numbers = new HashMap<>();
    int count = 0;
    for (int i = 0; i < ar.length; i++) {
      int remainder = ar[i] % k;
      int plus = (k - remainder) % k;
      Integer numberCount = numbers.get(plus);
      if (numberCount != null) count += numberCount;

      numberCount = numbers.get(remainder);
      if (numberCount == null) numberCount = 0;
      numbers.put(remainder, numberCount + 1);
    }
    return count;
  }

  public static void main(String[] args) {
    System.out.println(divisibleSumPairs(3, new int[] {1, 3, 2, 6, 1, 2}));
  }
}
