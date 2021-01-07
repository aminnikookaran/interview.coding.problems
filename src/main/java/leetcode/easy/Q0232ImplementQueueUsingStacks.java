package leetcode.easy;

import java.util.ArrayDeque;
import java.util.Deque;

// https://leetcode.com/problems/implement-queue-using-stacks/
public class Q0232ImplementQueueUsingStacks {
  class MyQueue1 {
    Deque<Integer> deque1;
    Deque<Integer> deque2;
    int front;

    /** Initialize your data structure here. */
    public MyQueue1() {
      deque1 = new ArrayDeque<>();
      deque2 = new ArrayDeque<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
      if (deque1.isEmpty()) front = x;
      deque1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
      if (deque2.isEmpty()) while (!deque1.isEmpty()) deque2.push(deque1.pop());
      return deque2.pop();
    }

    /** Get the front element. */
    public int peek() {
      if (!deque2.isEmpty()) return deque2.peek();
      return front;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
      return deque1.isEmpty() && deque2.isEmpty();
    }
  }
}
