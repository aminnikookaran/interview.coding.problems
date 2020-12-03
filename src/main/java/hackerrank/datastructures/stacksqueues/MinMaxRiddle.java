package hackerrank.datastructures.stacksqueues;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

// https://www.hackerrank.com/challenges/min-max-riddle/problem?h_l=interview&playlist_slugs%5B%5D%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D%5B%5D=stacks-queues
public class MinMaxRiddle {
  public static long[] riddle1(long[] arr) {
    long[] maxes = new long[arr.length];
    long[][] temp = new long[2][arr.length];
    for (int i = 0; i < arr.length; i++) {
      temp[0][i] = arr[i];
      maxes[0] = Math.max(maxes[0], temp[0][i]);
    }
    int k = 0;
    for (int i = 1; i < arr.length; i++) {
      k = i % 2;
      for (int j = 0; j < arr.length - i; j++) {
        temp[k][j] = Math.min(temp[1 - k][j], temp[1 - k][j + 1]);
        maxes[i] = Math.max(maxes[i], temp[k][j]);
      }
    }
    return maxes;
  }

  public static long[] riddle2(long[] arr) {
    Stack<Integer> stack = new Stack<>();
    Map<Long, Integer> map1 = new HashMap<>();
    int i = 0;
    while (i < arr.length) {
      if (stack.isEmpty() || arr[stack.peek()] < arr[i]) {
        stack.push(i);
        i++;
      } else {
        int index = stack.pop();
        long number = arr[index];
        int width = stack.isEmpty() ? i : i - stack.peek() - 1;
        Integer oldWidth = map1.get(number);
        if (oldWidth == null || width > oldWidth) map1.put(number, width);
      }
    }
    while (!stack.isEmpty()) {
      int index = stack.pop();
      long number = arr[index];
      int width = stack.isEmpty() ? i : i - stack.peek() - 1;
      Integer oldWidth = map1.get(number);
      if (oldWidth == null || width > oldWidth) map1.put(number, width);
    }
    Map<Integer, Long> map2 = new HashMap<>();
    for (Map.Entry<Long, Integer> entry : map1.entrySet()) {
      Long number = map2.get(entry.getValue());
      if (number == null || entry.getKey() > number) map2.put(entry.getValue(), entry.getKey());
    }
    long[] maxes = new long[arr.length];
    for (int j = maxes.length - 1; j >= 0; j--) {
      Long number = map2.get(j + 1);
      if (number == null || (j < maxes.length - 1 && maxes[j + 1] > number)) number = maxes[j + 1];
      maxes[j] = number;
    }
    return maxes;
  }

  public static void main(String[] args) {
    long[] riddle2 = riddle2(new long[] {9, 9, 3, 10, 10, 10, 1, 3, 5});
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0; i < riddle2.length; i++) stringBuilder.append(riddle2[i]).append(" ");
    System.out.println(stringBuilder);
  }
}
