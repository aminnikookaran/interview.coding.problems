package hackerrank.datastructures.stacksqueues;

import java.util.ArrayDeque;
import java.util.Deque;

public class QueuesATaleOfTwoStacks {
  public static class MyQueue<K> {
    Deque<K> deque1;
    Deque<K> deque2;

    public MyQueue() {
      deque1 = new ArrayDeque<>();
      deque2 = new ArrayDeque<>();
    }

    public void enqueue(K value) {
      deque1.push(value);
    }

    public K dequeue() {
      fillDeque2();
      return deque2.pop();
    }

    public K peek() {
      fillDeque2();
      return deque2.peek();
    }

    private void fillDeque2() {
      if (deque2.size() == 0) while (deque1.size() != 0) deque2.push(deque1.pop());
    }
  }
}
