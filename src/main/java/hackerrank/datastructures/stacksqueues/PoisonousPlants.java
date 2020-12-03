package hackerrank.datastructures.stacksqueues;

import java.util.Stack;

// https://www.hackerrank.com/challenges/poisonous-plants/problem?h_l=interview&playlist_slugs%5B%5D%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D%5B%5D=stacks-queues
public class PoisonousPlants {
  public static int poisonousPlants1(int[] p) {
    int[] count = new int[p.length];
    Stack<Integer> stack = new Stack<>();
    int max = 0;
    for (int i = p.length - 1; i >= 0; i--) {
      int temp = 0;
      while (!stack.empty() && p[i] < p[stack.peek()]) {
        temp++;
        int index = stack.pop();
        temp = Math.max(temp, count[index]);
      }
      max = Math.max(max, temp);
      count[i] = temp;
      stack.push(i);
    }
    return max;
  }

  public static int poisonousPlants2(int[] p) { // wrong
    int[] count = new int[p.length];
    Stack<Integer> stack = new Stack<>();
    int max = 0;
    int i = 0;
    int temp = 0;
    while (i < p.length) {
      if (stack.isEmpty() || p[i] < p[stack.peek()]) {
        stack.push(i);
        count[i] = temp;
        temp = 0;
        i++;
      } else temp = Math.max(temp + 1, count[stack.pop()]);
      max = Math.max(max, temp);
    }
    return max;
  }

  public static int poisonousPlants3(int[] p) { // wrong
    int[] days = new int[p.length];
    Stack<Integer> s = new Stack<>();
    int maxa = 0;
    for (int i = 0; i < p.length; i++) {
      if (s.empty()) {
        s.push(i);
      } else {
        Integer temp = s.peek();
        if (p[i] < p[temp]) {
          int sc = 1;
          maxa = Math.max(maxa, sc);
          s.push(i);
          days[i] = sc;
        } else {
          Integer v = s.peek();
          int pr = days[v];
          while (!s.empty() && p[v] <= p[i]) {
            s.pop();
            if (s.empty()) break;
            pr = Math.max(pr, days[v]);
            v = s.peek();
          }
          if (s.empty()) {
            s.push(i);
          } else {
            s.push(i);
            days[i] = pr + 1;
            maxa = Math.max(maxa, pr + 1);
          }
        }
      }
    }
    return maxa;
  }

  public static void main(String[] args) {
    int[] p = new int[] {4, 3, 7, 5, 6, 4, 2};
    System.out.println(poisonousPlants1(p));
    System.out.println(poisonousPlants2(p));
  }
}
