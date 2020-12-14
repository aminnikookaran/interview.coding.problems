package problems;

import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;

public class ContiguousSubarrays {
  public static int[] countSubarrays1(int[] arr) {
    if (arr == null) return null;
    int[] output = new int[arr.length];
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

  public static int[] countSubarrays2(int[] arr) {
    int[] result = new int[arr.length];
    Stack<Integer> deque = new Stack<>();
    int i = 0;
    while (i < arr.length) {
      if (deque.isEmpty() || arr[deque.peek()] > arr[i]) {
        deque.push(i++);
      } else {
        Integer index = deque.pop();
        arr[index] = deque.isEmpty() ? i : i - deque.peek() - 1;
      }
    }
    while (!deque.isEmpty()) {
      Integer index = deque.pop();
      arr[index] = deque.isEmpty() ? i : i - deque.peek() - 1;
    }
    return result;
  }

  public static void main(String[] args) {
    System.out.println(Arrays.asList(countSubarrays1(new int[] {3, 4, 1, 6, 2})));
    System.out.println(Arrays.asList(countSubarrays1(new int[] {2, 4, 7, 1, 5, 3})));
  }
}
