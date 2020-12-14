package cracking.moderate;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SumSwap {
  int[] findSwapValues1(int[] array1, int[] array2) {
    Integer target = getTarget(array1, array2);
    if (target == null) return null;
    return findDifference1(array1, array2, target);
  }

  /* Find a pair of values with a specific difference. */
  int[] findDifference1(int[] array1, int[] array2, int target) {
    Set<Integer> contents2 = getContents(array2);
    for (int one : array1) {
      int two = one - target;
      if (contents2.contains(two)) {
        int[] values = {one, two};
        return values;
      }
    }
    return null;
  }

  /* Put contents of array into hash set. */
  Set<Integer> getContents(int[] array) {
    Set<Integer> set = new HashSet<Integer>();
    for (int a : array) set.add(a);
    return set;
  }

  Integer getTarget(int[] array1, int[] array2) {
    int sum1 = Arrays.stream(array1).sum();
    int sum2 = Arrays.stream(array2).sum();
    if ((sum1 - sum2) % 2 != 0) return null;
    return (sum1 - sum2) / 2;
  }

  /* arrays should be sorted.*/
  int[] findSwapValues(int[] array1, int[] array2) {
    Integer target = getTarget(array1, array2);
    if (target == null) return null;
    return findDifference(array1, array2, target);
  }

  int[] findDifference(int[] array1, int[] array2, int target) {
    int a = 0;
    int b = 0;

    while (a < array1.length && b < array2.length) {
      int difference = array1[a] - array2[b];
      /* Compare difference to target. If difference is too small, then make it
       * bigger by moving a to a bigger value. If it is too big, then make it
       * smaller by moving b to a bigger value. If it's just right, return this
       * pair. */
      if (difference == target) {
        int[] values = {array1[a], array2[b]};
        return values;
      } else if (difference < target) a++;
      else b++;
    }

    return null;
  }
}
