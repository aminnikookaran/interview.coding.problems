package hackerrank.datastructures.stacksqueues;

import java.util.Stack;

// https://www.hackerrank.com/challenges/largest-rectangle/problem?h_l=interview&playlist_slugs%5B%5D%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D%5B%5D=stacks-queues
public class LargestRectangle {
  public static long largestRectangle(int[] h) {
    if (h == null || h.length == 0) return 0;
    Stack<Integer> stack = new Stack<Integer>();
    int max = 0;
    int i = 0;
    while (i < h.length) {
      // push index to stack when the current height is larger than the previous one
      if (stack.isEmpty() || h[i] >= h[stack.peek()]) {
        stack.push(i);
        i++;
      } else {
        // calculate max value when the current height is less than the previous one
        int index = stack.pop();
        int height = h[index];
        int width = stack.isEmpty() ? i : i - stack.peek() - 1;
        max = Math.max(height * width, max);
      }
    }
    while (!stack.isEmpty()) {
      int index = stack.pop();
      int height = h[index];
      int width = stack.isEmpty() ? i : i - stack.peek() - 1;
      max = Math.max(height * width, max);
    }
    return max;
  }

  public static void main(String[] args) {
    System.out.println(largestRectangle(new int[] {1, 2, 3, 4, 5}));
  }
}
