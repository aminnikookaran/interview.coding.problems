package problems;

import java.util.Arrays;
import java.util.Collections;
import java.util.TreeMap;
import java.util.TreeSet;

public class ContiguousSubarrays {
  public static Integer[] countSubarrays(int[] arr) {
    if (arr == null) return null;
    Integer[] output = new Integer[arr.length];
    TreeMap<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());
    for (int i = 0; i < arr.length; i++) map.put(arr[i], i);
    TreeSet<Integer> tree = new TreeSet<>();
    for (Integer index : map.values()) {
      Integer higher = tree.higher(index);
      if (higher == null) higher = arr.length;
      higher--;
      Integer lower = tree.lower(index);
      if (lower == null) lower = -1;
      lower++;
      tree.add(index);
      output[index] = higher - lower + 1;
    }
    return output;
  }

  public static void main(String[] args) {
    System.out.println(Arrays.asList(countSubarrays(new int[] {3, 4, 1, 6, 2})));
    System.out.println(Arrays.asList(countSubarrays(new int[] {2, 4, 7, 1, 5, 3})));
  }
}
